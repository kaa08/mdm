package project.mdm.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.request.board.SearchData;
import project.mdm.dto.request.inquiry.InquiryUpdateDto;
import project.mdm.dto.request.inquiry.InquiryWriteDto;
import project.mdm.dto.response.inquiry.ResInquiryDetailsDto;
import project.mdm.dto.response.inquiry.ResInquiryListDto;
import project.mdm.dto.response.inquiry.ResInquiryWriteDto;
import project.mdm.entity.Inquiry;
import project.mdm.entity.Member;
import project.mdm.repository.InquiryRepository;
import project.mdm.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final MemberRepository memberRepository;

    // 페이징 리스트
    public Page<ResInquiryListDto> getAllInquiries(Pageable pageable) {
        Page<Inquiry> inquiries = inquiryRepository.findAllWithMember(pageable);
        List<ResInquiryListDto> list = inquiries.getContent().stream()
                .map(ResInquiryListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, inquiries.getTotalElements());
    }

    // 게시글 검색, isEmpty() == ""
    public Page<ResInquiryListDto> search(SearchData searchData, Pageable pageable) {
        Page<Inquiry> result = null;
        if (!searchData.getTitle().isEmpty()) {
            result = inquiryRepository.findAllTitleContaining(searchData.getTitle(), pageable);
        } else if (!searchData.getContent().isEmpty()) {
            result = inquiryRepository.findAllContentContaining(searchData.getContent(), pageable);
        } else if (!searchData.getWriterName().isEmpty()) {
            result = inquiryRepository.findAllUsernameContaining(searchData.getWriterName(), pageable);
        }
        List<ResInquiryListDto> list = result.getContent().stream()
                .map(ResInquiryListDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, result.getTotalElements());
    }

    // 게시글 등록
    public ResInquiryWriteDto write(InquiryWriteDto inquiryDTO, Member member) {

        Inquiry inquiry = InquiryWriteDto.ofEntity(inquiryDTO);
        Member writerMember = memberRepository.findByEmail(member.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member Email", member.getEmail())
        );
        inquiry.setMappingMember(writerMember);
        Inquiry saveInquiry = inquiryRepository.save(inquiry);
        return ResInquiryWriteDto.fromEntity(saveInquiry, writerMember.getUsername());
    }

    // 게시글 상세보기
    public ResInquiryDetailsDto detail(Long inquiryId) {
        Inquiry findInquiry = inquiryRepository.findByIdWithMember(inquiryId).orElseThrow(
                () -> new ResourceNotFoundException("Inquiry", "Inquiry Id", String.valueOf(inquiryId))
        );
        return ResInquiryDetailsDto.fromEntity(findInquiry);
    }

/*    // 문의글 수정
    public ResInquiryDetailsDto update(Long inquiryId, InquiryUpdateDto inquiryDTO) {
        Inquiry updateInquiry = inquiryRepository.findByIdWithMember(inquiryId).orElseThrow(
                () -> new ResourceNotFoundException("Inquiry", "Inquiry Id", String.valueOf(inquiryId))
        );
        updateInquiry.update(inquiryDTO.getTitle(), inquiryDTO.getContent());
        return ResInquiryDetailsDto.fromEntity(updateInquiry);
    }*/

    // 게시글 삭제
    public void delete(Long inquiryId) {
        inquiryRepository.deleteById(inquiryId);
    }

}
