package com.example.Exam.service;

import com.example.Exam.model.Store;
import com.example.Exam.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Store addStore(Store store) {
        return storeRepository.save(store);
    }
}
