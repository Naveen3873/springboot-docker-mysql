package com.app.demo.dto;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
    private String role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
