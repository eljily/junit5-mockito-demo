package com.example.flywaydemo.repository;
import com.example.flywaydemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
}
