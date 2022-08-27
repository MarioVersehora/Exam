package com.example.Exam.service;

import com.example.Exam.exception.NoClientException;
import com.example.Exam.exception.NoOrderException;
import com.example.Exam.model.Client;
import com.example.Exam.model.Orders;
import com.example.Exam.model.Product;
import com.example.Exam.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Integer getTotalSpentOnAllOrders(Integer clientId) throws NoClientException, NoOrderException {
        Optional<Client> client = clientRepository.findById(clientId);

        if (client.isEmpty()) {
            throw new NoClientException("No client found!");
        }

        List<Orders> orders = client.get().getOrders();
        if(orders.isEmpty()) {
            throw new NoOrderException("No order found!");
        }
        Integer totalPrice = 0;

        for (Orders order : orders) {
            List<Product> products = order.getProducts();
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
        }

        return totalPrice;
    }

}
