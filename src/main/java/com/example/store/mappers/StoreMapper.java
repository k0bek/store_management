package com.example.store.mappers;

import com.example.store.domain.dtos.CreateStoreRequest;
import com.example.store.domain.dtos.StoreDto;
import com.example.store.domain.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface StoreMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    StoreDto toDto(Store store);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "totalCapacity", target = "totalCapacity")
    @Mapping(source = "storeType", target = "storeType")
    Store toEntity(CreateStoreRequest createStoreRequest);
}