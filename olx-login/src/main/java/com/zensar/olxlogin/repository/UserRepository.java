package com.zensar.olxlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxlogin.entity.RegisterUser;

public interface UserRepository extends JpaRepository<RegisterUser, Integer> {

}
