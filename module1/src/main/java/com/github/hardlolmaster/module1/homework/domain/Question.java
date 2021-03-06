package com.github.hardlolmaster.module1.homework.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private int number;
    private String question;
    private List<String> answers;
    private int rightAnswer;
    private int answer;

}
