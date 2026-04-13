package com.example.simple_board.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor //기본 생성자
public class Board {
    @Id //pk 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키 자동생성 어노테이션, IDENTITY 전략은 기본 키 생성을 데이터베이스에 위임하는 전략이다.
    private Long id;

    @Column(nullable = false) //NULL을 허용하지 않음
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String writer;

    private String password;

    private LocalDateTime createdDate;

    //데이터 생성을 위한 생성자
    public Board(String title, String content, String writer, String password){
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
        this.createdDate = LocalDateTime.now();
    }
}