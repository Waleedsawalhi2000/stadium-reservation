package org.stadium.dto;

import java.util.Arrays;

public enum PaymentMethod {
    VISA("visa"), CASH("cash");

    private final String method;

    PaymentMethod(String method) {
        this.method = method;
    }

    public static String getPaymentMethod(final PaymentMethod paymentMethod) {
        return Arrays.stream(values()).filter((i) -> i.method.equals(valueOf(paymentMethod.name()).method)).findFirst().get().method;
    }
}
