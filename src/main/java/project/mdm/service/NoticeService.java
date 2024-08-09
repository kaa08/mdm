package project.mdm.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.request.notice.NoticeUpdateDto;
import project.mdm.dto.request.notice.NoticeWriteDto;
import project.mdm.dto.response.notice.ResNoticeDetailsDto;
import project.mdm.dto.response.notice.ResNoticeListDto;
import project.mdm.dto.response.notice.ResNoticeWriteDto;
import project.mdm.entity.Member;
import project.mdm.entity.Notice;
import project.mdm.repository.MemberRepository;
import project.mdm.repository.NoticeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {

    private final NoticeRepository noticeRepository;
    private final MemberRepository memberRepository;

    // 공지사항 - 공지사항 전체 조회
    public Page<ResNoticeListDto> getAllNotices(Pageable pageable) {
        Page<Notice> notices = noticeRepository.findAllWithMember(pageable);
        List<ResNoticeListDto> list = notices.getContent().stream()
                .map(ResNoticeListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, notices.getTotalElements());
    }

    // 공지사항 - 공지사항 검색
    public Page<ResNoticeListDto> search(SearchData searchData, Pageable pageable) {
        Page<Notice> result = null;
        if (!searchData.getTitle().isEmpty()) {
            result = noticeRepository.findAllTitleContaining(searchData.getTitle(), pageable);
        } else if (!searchData.getContent().isEmpty()) {
            result = noticeRepository.findAllContentContaining(searchData.getContent(), pageable);
        } else if (!searchData.getWriterName().isEmpty()) {
            result = noticeRepository.findAllUsernameContaining(searchData.getWriterName(), pageable);
        }
        List<ResNoticeListDto> list = result.getContent().stream()
                .map(ResNoticeListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

    // 관리자 페이지 - 공지사항 작성
    public ResNoticeWriteDto write(NoticeWriteDto noticeDTO, Member member) {

        Notice notice = NoticeWriteDto.ofEntity(noticeDTO);
        Member writerMember = memberRepository.findByEmail(member.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member Email", member.getEmail())
        );
        notice.setMappingMember(writerMember);
        Notice saveNotice = noticeRepository.save(notice);
        return ResNoticeWriteDto.fromEntity(saveNotice, writerMember.getNickname());
    }

    // 공지사항 - 공지사항 조회
    public ResNoticeDetailsDto detail(Long noticeId) {
        Notice findNotice = noticeRepository.findByIdWithMember(noticeId).orElseThrow(
                () -> new ResourceNotFoundException("Notice", "Notice Id", String.valueOf(noticeId))
        );
        // 조회수 증가
        findNotice.upViewCount();
        return ResNoticeDetailsDto.fromEntity(findNotice);
    }

    // 공지사항 - 공지사항 수정
    public ResNoticeDetailsDto update(Long noticeId, NoticeUpdateDto noticeDTO) {
        Notice updateNotice =noticeRepository.findByIdWithMember(noticeId).orElseThrow(
                () -> new ResourceNotFoundException("Notice", "Notice Id", String.valueOf(noticeId))
        );
        updateNotice.update(noticeDTO.getTitle(), noticeDTO.getContent());
        return ResNoticeDetailsDto.fromEntity(updateNotice);
    }

    // 공지사항 - 공지사항 삭제
    public void delete(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

}
