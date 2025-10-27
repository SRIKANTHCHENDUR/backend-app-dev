package com.examly.springapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String company;
    
    public Customer(String name, String email, String phone, String company) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.company = company;
    }
}