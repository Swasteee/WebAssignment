package com.example.furniturerental.backend.Service.impl;

import com.example.furniturerental.backend.Entity.RegistrationEntity;
import com.example.furniturerental.backend.Repository.LoginRepository;
import com.example.furniturerental.backend.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl  implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean authenticateUser(String email, String password) {
        RegistrationEntity user = loginRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
