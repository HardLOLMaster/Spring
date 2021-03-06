package com.github.hardlolmaster.module2.homework1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Genre implements Serializable {
    private Long id;
    private String name;
}
