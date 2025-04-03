package com.example.store.repositories;

import com.example.store.domain.entities.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreItemRepository extends JpaRepository<StoreItem, Long> {
}
