package com.app.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
