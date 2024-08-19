package com.example.furniturerental.backend.Service;

import com.example.furniturerental.backend.Entity.CustomerFeedbackEntity;
import com.example.furniturerental.backend.Pojo.CustomerFeedbackPojo;

import java.util.List;
import java.util.Optional;

public interface CustomerFeedbackService {
    void saveCustomerFeedback(CustomerFeedbackPojo customerFeedbackPojo);
    List<CustomerFeedbackEntity> getAllCustomerFeedback();
    Optional<CustomerFeedbackEntity> getCustomerFeedbackById(Integer id);
    void deleteCustomerFeedback(Integer id);
}