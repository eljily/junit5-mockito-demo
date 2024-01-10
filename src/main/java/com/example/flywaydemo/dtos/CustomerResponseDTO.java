package com.example.flywaydemo.dtos;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class CustomerResponseDTO {
    private String firstName;
    private String lastName;
}
