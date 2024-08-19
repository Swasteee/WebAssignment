package com.example.furniturerental.backend.Repository;

import com.example.furniturerental.backend.Entity.CustomerFeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerFeedbackRepository extends JpaRepository<CustomerFeedbackEntity, Integer> {
}

