package com.example.Exam.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany
    private List<Orders> orders = new ArrayList<>();

    public void addOrder(Orders order) {
        orders.add(order);
    }

}
