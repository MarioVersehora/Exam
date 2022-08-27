package com.example.Exam.service;

import com.example.Exam.exception.NoClientException;
import com.example.Exam.exception.NoStoreException;
import com.example.Exam.model.Client;
import com.example.Exam.model.Orders;
import com.example.Exam.model.Store;
import com.example.Exam.repository.ClientRepository;
import com.example.Exam.repository.OrderRepository;
import com.example.Exam.repository.ProductRepository;
import com.example.Exam.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final StoreRepository storeRepository;

    private final ProductRepository productRepository;

    public Orders placeOrder(Integer clientId, Integer storeId, List<Integer> productsId) throws NoClientException, NoStoreException {
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isEmpty()) {
            throw new NoClientException("No client found!");
        }

        Optional<Store> store = storeRepository.findById(storeId);

        if (store.isEmpty()) {
            throw new NoStoreException("No store found!");
        }


        return orderRepository.save(Orders.builder()
                .client(client.get())
                .products(productRepository.findByIdIn(productsId))
                .build());
    }

    public List<Orders> findAllOrdersByClientId(Integer clientId) {
        Client client = clientRepository.findById(clientId).get();
        return orderRepository.findAll().stream()
                .filter(o -> o.getClient().getName().equals(client.getName()))
                .collect(Collectors.toList());
    }




}
