package com.example.store.services.impl;

import com.example.store.domain.Quantity;
import com.example.store.domain.entities.Store;
import com.example.store.domain.entities.StoreItem;
import com.example.store.repositories.StoreItemRepository;
import com.example.store.repositories.StoreRepository;
import com.example.store.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final StoreItemRepository storeItemRepository;

    @Override
    public Store createStore(Store store) {
        if (storeRepository.existsByNameIgnoreCase(store.getName())) {
            throw new IllegalArgumentException("Store already exists");
        }
        return storeRepository.save(store);
    }

    public void decreaseItemCapacity(Long itemId, int quantity) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.decreaseQuantity( quantity);
        storeItemRepository.save(storeItem);
    }

    public void increaseItemCapacity(Long itemId, int quantity) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.increaseQuantity(quantity);
        storeItemRepository.save(storeItem);
    }

    public void makeItemInfinitelyAvailable(Long itemId) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.setQuantity(Quantity.INFINITE);
        storeItemRepository.save(storeItem);
    }

    public void makeItemInfinitelyUnavailable(Long itemId) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.setQuantity(Quantity.BLOCKED);
        storeItemRepository.save(storeItem);
    }
}
