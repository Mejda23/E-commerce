package com.example.ecommerce.enums;

public enum UserRole {
    USER(1),
    ADMIN(2),
    MANAGER(3);

    private final int value;

    UserRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
