package com.example.store.domain.entities;

import com.example.store.domain.StoreType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Store {
    @EqualsAndHashCode.Include
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


}
