package com.qubb.lilbus.enumeration;

public enum PaymentMethod {
    BY_CARD("BY_CARD"), BY_CASH("BY_CASH");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    String getPaymentMethod() {
        return this.paymentMethod;
    }


}
