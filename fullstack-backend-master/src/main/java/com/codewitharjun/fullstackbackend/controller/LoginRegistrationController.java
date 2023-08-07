package com.codewitharjun.fullstackbackend.controller;

import com.codewitharjun.fullstackbackend.exception.UserNotFoundException;
import com.codewitharjun.fullstackbackend.model.LoginCredentials;
import com.codewitharjun.fullstackbackend.model.User;
import com.codewitharjun.fullstackbackend.repository.LoginCredentialsRepository;
import com.codewitharjun.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class LoginRegistrationController {

    @Autowired
    private  LoginCredentialsRepository loginCredentialsRepository;

    public ResponseEntity<LoginCredentials> newLogin(@RequestBody LoginCredentials newLogin) {
        // Perform password encoding here using BCryptPasswordEncoder

        // Save the login credentials to the "login_credentials" table
        LoginCredentials savedLogin = loginCredentialsRepository.save(newLogin);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLogin);
    }
    @GetMapping("/credentialss")
    List<LoginCredentials> getAllUsers(){
        return  loginCredentialsRepository.findAll();
    }

    @GetMapping("/credentials/{id}")
    LoginCredentials getUserById(@PathVariable Long login_id){
        return  loginCredentialsRepository.findById(login_id)
                .orElseThrow(()-> new UserNotFoundException(login_id));
    }

}