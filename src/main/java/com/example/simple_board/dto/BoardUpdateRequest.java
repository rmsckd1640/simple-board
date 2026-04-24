package com.example.simple_board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardUpdateRequest {
    private final String title;
    private final String content;
    private final String writer;
}
