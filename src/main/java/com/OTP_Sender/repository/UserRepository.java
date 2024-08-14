package com.OTP_Sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OTP_Sender.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
