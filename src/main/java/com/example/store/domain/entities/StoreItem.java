package com.example.store.domain.entities;

import com.example.store.domain.StoreItemStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "storeItems")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StoreItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer maxCapacity;

    @ManyToOne()
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private String rowNumber;

    @Column(nullable = false)
    private String columnNumber;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreItemStatus storeItemStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void createdAt() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;

    }

    @PreUpdate
    public void updatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StoreItem storeItem = (StoreItem) o;
        return Objects.equals(id, storeItem.id) && Objects.equals(name, storeItem.name) && Objects.equals(code, storeItem.code) && Objects.equals(quantity, storeItem.quantity) && Objects.equals(maxCapacity, storeItem.maxCapacity) && Objects.equals(store, storeItem.store) && Objects.equals(rowNumber, storeItem.rowNumber) && Objects.equals(columnNumber, storeItem.columnNumber) && storeItemStatus == storeItem.storeItemStatus && Objects.equals(createdAt, storeItem.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, quantity, maxCapacity, store, rowNumber, columnNumber, storeItemStatus, createdAt);
    }
}
