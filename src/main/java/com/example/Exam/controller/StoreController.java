package com.example.Exam.controller;

import com.example.Exam.model.Store;
import com.example.Exam.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("store")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public Store addStore(@RequestBody Store store) {
        return storeService.addStore(store);
    }
}
