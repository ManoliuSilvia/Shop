package com.example.demo.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Integer sc_id;
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<User> users;
}
