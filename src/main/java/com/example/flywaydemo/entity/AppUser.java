package com.example.flywaydemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @Builder
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
}
