package com.example.store.controllers;

import com.example.store.domain.dtos.CreateStoreRequest;
import com.example.store.domain.dtos.StoreDto;
import com.example.store.domain.entities.Store;
import com.example.store.mappers.StoreMapper;
import com.example.store.services.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api/v1/stores")
@RequiredArgsConstructor
public class StoreController {
    private final StoreService storeService;
    private final StoreMapper storeMapper;

    @PostMapping
    public ResponseEntity<StoreDto> createStore(@RequestBody CreateStoreRequest store) {
        Store storeToCreate = storeMapper.toEntity(store);
        Store createdStore = storeService.createStore(storeToCreate);
        return new ResponseEntity<>(storeMapper.toDto(createdStore), HttpStatus.CREATED);
    }
}
