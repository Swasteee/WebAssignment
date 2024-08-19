package com.example.furniturerental.backend.Service.impl;

import com.example.furniturerental.backend.Entity.CustomerFeedbackEntity;
import com.example.furniturerental.backend.Pojo.CustomerFeedbackPojo;
import com.example.furniturerental.backend.Repository.CustomerFeedbackRepository;
import com.example.furniturerental.backend.Service.CustomerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CustomerFeedbackServiceImpl implements CustomerFeedbackService {

    private final CustomerFeedbackRepository customerFeedbackRepository;
    @Override
    public void saveCustomerFeedback(CustomerFeedbackPojo customerFeedbackPojo) {
        CustomerFeedbackEntity customerFeedbackEntity = new CustomerFeedbackEntity();
        customerFeedbackEntity.setId(customerFeedbackPojo.getId());
        customerFeedbackEntity.setSuggestions(customerFeedbackPojo.getSuggestions());
        customerFeedbackEntity.setRate_Website(customerFeedbackPojo.getRate_Website());
        customerFeedbackEntity.setConvenience(customerFeedbackPojo.getConvenience());
        customerFeedbackRepository.save(customerFeedbackEntity);
    }

    @Override
    public List<CustomerFeedbackEntity> getAllCustomerFeedback() {
        return  customerFeedbackRepository.findAll();
    }

    @Override
    public Optional<CustomerFeedbackEntity> getCustomerFeedbackById(Integer id) {
        return customerFeedbackRepository.findById(id);
    }

    @Override
    public void deleteCustomerFeedback(Integer id) {
        customerFeedbackRepository.deleteById(id);
    }

    }

