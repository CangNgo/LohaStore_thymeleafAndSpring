package com.cangngo.lohastore_java5_spring.controller.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@AllArgsConstructor
public enum Validation {
    INVALID_NAME("Tên không hợp lệ."),
    NOTNULL("Không được để trống"),
    INVALID_PRICE("Giá sản phẩm không hợp lệ.");

    private final String message;

    public String getMessage() {
        return message;
    }
}
