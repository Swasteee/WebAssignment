package com.example.furniturerental.backend.Service;

public interface LoginService {
    boolean authenticateUser(String email, String password);
}
