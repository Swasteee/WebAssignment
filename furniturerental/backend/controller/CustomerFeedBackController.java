package com.example.furniturerental.backend.controller;

import com.example.furniturerental.backend.Entity.CustomerFeedbackEntity;
import com.example.furniturerental.backend.Pojo.CustomerFeedbackPojo;
import com.example.furniturerental.backend.Service.CustomerFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor

public class CustomerFeedBackController {
    private final CustomerFeedbackService customerFeedbackService;

    @PostMapping("/feedback")
    public void customerFeedback(@RequestBody CustomerFeedbackPojo customerFeedback) {
        customerFeedbackService.saveCustomerFeedback(customerFeedback);
    }

    @GetMapping("/feedbacks")
    public List<CustomerFeedbackEntity> getAllCustomerFeedback() {
        return customerFeedbackService.getAllCustomerFeedback();
    }

    @GetMapping("/feedbacks/{id}")
    public Optional<CustomerFeedbackEntity> getCustomerFeedbackById(@PathVariable Integer id) {
        return customerFeedbackService.getCustomerFeedbackById(id);
    }

    @DeleteMapping("/feedbacks/{id}")
    public void deleteCustomerFeedback(@PathVariable Integer id) {
        customerFeedbackService.deleteCustomerFeedback(id);
    }
}

