package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Register;

public interface RegisterRepo extends JpaRepository<Register, String> {

}
