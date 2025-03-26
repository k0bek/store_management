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

    StoreDto toDto(Store store);

    Store toEntity(CreateStoreRequest createStoreRequest);
}
