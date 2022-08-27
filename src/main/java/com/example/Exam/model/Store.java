package com.example.Exam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<Product> products = new ArrayList<>();

    @OneToOne
    private Owner owner;

    @OneToMany
    private List<Client> clients = new ArrayList<>();
}
