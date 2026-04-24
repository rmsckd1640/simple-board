package com.example.simple_board.controller;

import com.example.simple_board.domain.Board;
import com.example.simple_board.dto.BoardWriteRequest;
import com.example.simple_board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    /**
     * 게시글 목록 조회
     */
    @GetMapping("/board/list")
    public String list(Model model){
        List<Board> boards = boardService.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    /**
     * 게시글 상세 조회
     */
    @GetMapping("/board/view/{id}")
    public String view(@PathVariable Long id, Model model){
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/view";
    }

    /**
     * 글쓰기 페이지 이동
     */
    @GetMapping("/board/write")
    public String writeForm(){
        return "board/write";
    }

    /**
     * 글쓰기 저장 실행
     */
    @PostMapping("/board/write")
    public String write(BoardWriteRequest dto){
        Board board = new Board(dto.getTitle(), dto.getContent(), dto.getWriter(), dto.getPassword());
        boardService.save(board);
        return "redirect:/board/list"; // 저장 후 목록 페이지로 강제 이동
    }

}
