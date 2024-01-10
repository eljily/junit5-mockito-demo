package com.example.flywaydemo;

import com.example.flywaydemo.entity.AppUser;
import com.example.flywaydemo.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlywayDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlywayDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AppUserRepository appUserRepository){
        return args -> {
            AppUser user = AppUser.builder()
                    .firstName("sidibrahim")
                    .build();
            appUserRepository.save(user);
        };
    }
}
