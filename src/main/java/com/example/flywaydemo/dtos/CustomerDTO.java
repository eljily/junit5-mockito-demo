package com.example.flywaydemo.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class CustomerDTO {
    private int id;
    private String firstName;
    private String lastName;
}
