package com.codewitharjun.fullstackbackend.repository;

import com.codewitharjun.fullstackbackend.model.LoginCredentials;
import com.codewitharjun.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginCredentialsRepository extends JpaRepository<LoginCredentials,Long> {

}
