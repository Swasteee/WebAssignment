package com.example.furniturerental.backend.Pojo;

import lombok.Getter;
import lombok.Setter;


    @Getter
    @Setter
    public class PasswordChangeRequest {
        private String email;
        private String newPassword;
}
