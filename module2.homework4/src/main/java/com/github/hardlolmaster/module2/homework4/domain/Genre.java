package com.github.hardlolmaster.module2.homework4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Genre implements Serializable {
    @Id
    private BigInteger id;
    private String name;
}