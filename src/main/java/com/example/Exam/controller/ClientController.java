package com.example.Exam.controller;

import com.example.Exam.exception.NoClientException;
import com.example.Exam.exception.NoOrderException;
import com.example.Exam.repository.ClientRepository;
import com.example.Exam.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping("{clientId}")
    public Integer getTotalSpentOnAllOrders(@PathVariable Integer clientId) throws NoClientException, NoOrderException {
        return clientService.getTotalSpentOnAllOrders(clientId);

    }
}
