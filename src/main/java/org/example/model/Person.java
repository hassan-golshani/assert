package org.example.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public final class Person {
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private boolean agreementAccepted;
    private LocalDateTime birthdate;
}
