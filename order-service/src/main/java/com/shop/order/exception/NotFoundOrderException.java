package com.shop.order.exception;

public class NotFoundOrderException extends RuntimeException{
    public NotFoundOrderException(String message) {
        super(message);
    }
}
