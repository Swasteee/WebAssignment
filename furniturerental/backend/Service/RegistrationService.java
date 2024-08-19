package com.example.furniturerental.backend.Service;

import com.example.furniturerental.backend.Entity.RegistrationEntity;
import com.example.furniturerental.backend.Pojo.RegistrationPojo;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
    void saveData(RegistrationPojo registrationPojo);
    RegistrationPojo findUserByEmail(String email);
    boolean authenticateUser(String email, String password);
    List<RegistrationEntity> getAllRegistrations();
    Optional<RegistrationEntity> getRegistrationsById(Integer id);
    void deleteRegistration(Integer id);
}
