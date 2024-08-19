package com.example.furniturerental.backend.Service.impl;

import com.example.furniturerental.backend.Entity.RegistrationEntity;
import com.example.furniturerental.backend.Pojo.RegistrationPojo;
import com.example.furniturerental.backend.Repository.RegistrationRepository;
import com.example.furniturerental.backend.Service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;
import java.util.Optional;

public class RegistrationServiceImpl  implements RegistrationService {
    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public void saveData(RegistrationPojo registrationPojo) {
        RegistrationEntity registration = new RegistrationEntity();
        registration.setId(registrationPojo.getId());
        registration.setUsername(registrationPojo.getUsername());
        registration.setPassword(registrationPojo.getPassword());
        registration.setFull_name(registrationPojo.getFull_name());
        registration.setEmail(registrationPojo.getEmail());
        registration.setContact_us(registrationPojo.getContact_us());
        registrationRepository.save(registration);
    }

    @Override
    public RegistrationPojo findUserByEmail(String email) {
        RegistrationEntity entity = registrationRepository.findByEmail(email);
        if (entity != null) {
            RegistrationPojo pojo = new RegistrationPojo();
            BeanUtils.copyProperties(entity, pojo);
            return pojo;
        }
        return null;
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        RegistrationEntity user = registrationRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }

    @Override
    public List<RegistrationEntity> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Optional<RegistrationEntity> getRegistrationsById(Integer id) {
        return registrationRepository.findById(id);
    }

    @Override
    public void deleteRegistration(Integer id) {
        registrationRepository.deleteById(id);
    }
}

