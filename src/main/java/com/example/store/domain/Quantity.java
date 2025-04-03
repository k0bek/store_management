package com.example.store.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@EqualsAndHashCode
public class Quantity {

    public static Quantity INFINITE = new Quantity(-1);
    public static Quantity BLOCKED = new Quantity(0);

    @Column(name = "quantity", nullable = false)
    private Integer value;

    public Quantity(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }

        this.value = value;
    }

    public Quantity decreased(int quantity) {
        if (this.value == -1 || this.value == 0) {
            return this;
        }

        return new Quantity(this.value - quantity);
    }

    public Quantity increased(int quantity) {
        if (this.value == -1) {
            return this;
        }

        return new Quantity(this.value + quantity);
    }

}

