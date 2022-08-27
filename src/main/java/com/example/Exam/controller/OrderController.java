package com.example.Exam.controller;

import com.example.Exam.exception.NoClientException;
import com.example.Exam.exception.NoStoreException;
import com.example.Exam.model.Orders;
import com.example.Exam.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;


    @PostMapping("{clientId}/{storeId}")
    public Orders placeOrder(@PathVariable Integer clientId, @PathVariable Integer storeId, @RequestBody List<Integer> productsId) throws NoClientException, NoStoreException {
        return orderService.placeOrder(clientId, storeId, productsId);
    }

    @GetMapping("{clientId}")
    public List<Orders> findAllOrdersByClientId(@PathVariable Integer clientId) {
        return orderService.findAllOrdersByClientId(clientId);
    }


}
