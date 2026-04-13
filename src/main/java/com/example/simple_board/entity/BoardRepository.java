package com.example.simple_board.entity;

import com.example.simple_board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

//프록시 빈
public interface BoardRepository extends JpaRepository<Board, Long> {

}