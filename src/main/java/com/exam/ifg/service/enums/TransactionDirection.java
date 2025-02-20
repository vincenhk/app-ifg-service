package com.exam.ifg.service.enums;

public enum TransactionDirection {
    CREDIT("+"),
    DEBIT("-");

    private final String value;

    TransactionDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
