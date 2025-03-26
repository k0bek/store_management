package com.example.store.domain.dtos;

import com.example.store.domain.StoreType;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStoreRequest {

    @NotBlank(message = "Store name is required")
    @Size(min = 2, max = 50, message = "Store name must be between {min} and {max} letters.")
    private String name;

    @NotBlank(message = "Address is required")
    @Size(min = 2, max = 50, message = "Address must be between {min} and {max} letters.")
    private String address;

    @NotNull(message = "Capacity is required")
    @Min(value = 100, message = "Total capacity must be at least {value}.")
    @Max(value = 1000, message = "Total capacity must not exceed {value}.")
    private Integer totalCapacity;

    @NotNull(message = "Store type is required")
    private StoreType storeType;
}
