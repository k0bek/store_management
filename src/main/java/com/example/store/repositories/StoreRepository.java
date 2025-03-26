package com.example.store.repositories;

import com.example.store.domain.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
    boolean existsByNameIgnoreCase(String name);
}
