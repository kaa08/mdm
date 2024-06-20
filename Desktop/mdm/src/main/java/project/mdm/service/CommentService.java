package project.mdm.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import project.mdm.common.exception.ResourceNotFoundException;
import project.mdm.dto.request.comment.CommentDto;
import project.mdm.dto.response.comment.ResCommentDto;
import project.mdm.entity.Board;
import project.mdm.entity.Comment;
import project.mdm.entity.Member;
import project.mdm.repository.BoardRepository;
import project.mdm.repository.CommentRepository;
import project.mdm.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 커뮤니티 - 커뮤니티 댓글 목록 조회
    public Page<ResCommentDto> getAllComments(Pageable pageable, Long boardId) {
        Page<Comment> comments = commentRepository.findAllWithMemberAndBoard(pageable, boardId);
        List<ResCommentDto> commentList = comments.getContent().stream()
                .map(ResCommentDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(commentList, pageable, comments.getTotalElements());
    }

    // 커뮤니티 - 커뮤니티 댓글 작성
    public ResCommentDto write(Long boardId, Member member, CommentDto writeDto) {
        // board 정보 검색
        Board board = boardRepository.findById(boardId).orElseThrow(
                () -> new ResourceNotFoundException("Board", "Board id", String.valueOf(boardId))
        );
        // member(댓글 작성자) 정보 검색
        Member commentWriter = memberRepository.findById(member.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "Member id", String.valueOf(member.getId()))
        );
        // Entity 변환, 연관관계 매핑
        Comment comment = CommentDto.ofEntity(writeDto);
        comment.setBoard(board);
        comment.setMember(commentWriter);

        Comment saveComment = commentRepository.save(comment);
        return ResCommentDto.fromEntity(saveComment);
    }

    // 커뮤니티 - 댓글 수정
    public ResCommentDto update(Long commentId, CommentDto commentDto) {
        Comment comment = commentRepository.findByIdWithMemberAndBoard(commentId).orElseThrow(
                () -> new ResourceNotFoundException("Comment", "Comment Id", String.valueOf(commentId))
        );
        comment.update(commentDto.getContent());
        return ResCommentDto.fromEntity(comment);
    }

    // 마이페이지 - 사용자 별 커뮤니티 댓글 조회
    public Page<ResCommentDto> getCommentByMember(Pageable pageable, Member member) {
        Page<Comment> comments = commentRepository.findAllByMember(member, pageable);
        List<ResCommentDto> list = comments.getContent().stream()
                .map(ResCommentDto::fromEntity)
                .collect(Collectors.toList());
        return new PageImpl<>(list, pageable, comments.getTotalElements());
    }

    // 커뮤니티 - 커뮤니티 댓글 삭제
    public void delete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
