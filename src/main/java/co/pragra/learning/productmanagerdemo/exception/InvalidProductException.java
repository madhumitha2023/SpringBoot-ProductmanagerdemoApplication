package co.pragra.learning.productmanagerdemo.exception;

import co.pragra.learning.productmanagerdemo.entity.Product;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException(String productCannotBeNull) {
    }
}
