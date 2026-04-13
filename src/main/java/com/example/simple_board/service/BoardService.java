package com.example.simple_board.service;

import com.example.simple_board.domain.Board;
import com.example.simple_board.entity.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor // final이 붙은 필드의 생성자를 자동으로 생성 (의존성 주입)
@Transactional(readOnly = true) // 기본적으로 읽기 전용으로 설정 (성능 최적화)
public class BoardService {

    //이 객체는 한 번 태어나면 절대로 바뀌지 않음.
    private final BoardRepository boardRepository;

    /**
     * 게시글 저장
     */
    @Transactional //쓰기 작업이므로 readOnly = false (기본값)
    public Long save(Board board){
        return boardRepository.save(board).getId();
    }

    /**
     * 게시글 전체 조회
     */
    public List<Board> findAll(){
        return boardRepository.findAll();
    }

    /**
     * 게시글 상세 조회
     */
    public Board findById(Long id){
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));
    }
}
