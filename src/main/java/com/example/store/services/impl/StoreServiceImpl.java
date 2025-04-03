package com.example.store.services.impl;

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

        int decreasedQuantity = storeItem.getQuantity() - quantity;
        if (decreasedQuantity < 0) {
            throw new IllegalArgumentException("Not enough quantity");
        }

        storeItem.setQuantity(decreasedQuantity);
        storeItemRepository.save(storeItem);
    }

    public void increaseItemCapacity(Long itemId, int quantity) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        int increasedQuantity = storeItem.getQuantity() + quantity;
        storeItem.setQuantity(increasedQuantity);
        storeItemRepository.save(storeItem);
    }

    public void makeItemInfinitelyAvailable(Long itemId) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.setQuantity(-1);
        storeItemRepository.save(storeItem);
    }

    public void makeItemInfinitelyUnavailable(Long itemId) {
        StoreItem storeItem = storeItemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Store item not found"));

        storeItem.setQuantity(0);
        storeItemRepository.save(storeItem);
    }
}
