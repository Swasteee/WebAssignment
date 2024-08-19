package com.example.furniturerental.backend.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Customer Feedback")
@Getter
@Setter
public class CustomerFeedbackEntity {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parameter_setup_seq_gen")

    @SequenceGenerator(name = "parameter_setup_seq_gen", sequenceName = "parameters_setup_seq", allocationSize = 1)

    @Id
    private Integer id;

    @Column(name="Suggestions")
    private String suggestions;

    @Column(name="Rate Website")
    private String rate_Website;

    @Column(name="convenience")
    private String convenience;
}
