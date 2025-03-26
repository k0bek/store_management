package com.example.store.services.impl;

import com.example.store.domain.entities.Store;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Override
    public Store createStore(Store store) {
        if(storeRepository.existsByNameIgnoreCase(store.getName())) {
            throw new IllegalArgumentException("Store already exists");
        }
        return storeRepository.save(store);
    }
}
