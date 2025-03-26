package com.example.store.domain.entities;

import com.example.store.domain.StoreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "stores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer totalCapacity;

    @Column(nullable = false)
    private Integer currentOccupancy = 0;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StoreType storeType;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<StoreItem> storeItems;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column (nullable = false)
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
        Store store = (Store) o;
        return Objects.equals(id, store.id) && Objects.equals(name, store.name) && Objects.equals(address, store.address) && Objects.equals(totalCapacity, store.totalCapacity) && Objects.equals(currentOccupancy, store.currentOccupancy) && storeType == store.storeType && Objects.equals(storeItems, store.storeItems) && Objects.equals(createdAt, store.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, totalCapacity, currentOccupancy, storeType, storeItems, createdAt);
    }
}
