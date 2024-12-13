package com.shop.order.exception;

public class NotFoundAccountOrItem extends RuntimeException{
    public NotFoundAccountOrItem(String message) {
        super(message);
    }
}
