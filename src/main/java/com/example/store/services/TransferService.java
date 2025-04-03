package com.example.store.services;

import com.example.store.domain.Quantity;
import com.example.store.domain.entities.Store;
import com.example.store.domain.entities.StoreItem;
import com.example.store.repositories.StoreItemRepository;
import com.example.store.repositories.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class TransferService {
    private final StoreRepository storeRepository;
    private final StoreItemRepository storeItemRepository;

    void transfer(Long sourceShopId, Long targetShopId, Long sku, int quantity){

        StoreItem sourceItem  = storeItemRepository.findByStoreId(sourceShopId, sku)
                .orElseThrow(() -> new IllegalArgumentException("Source item not found"));

        StoreItem targetItem  = storeItemRepository.findByStoreId(targetShopId, sku)
                .orElseThrow(() -> new IllegalArgumentException("Target item not found"));

        sourceItem.decreaseQuantity(quantity);
        targetItem.increaseQuantity(quantity);

        storeItemRepository.saveAll(List.of(sourceItem, targetItem));
    }
}
