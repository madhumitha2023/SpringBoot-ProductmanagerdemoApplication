package co.pragra.learning.productmanagerdemo.exception;

public class InvalidReviewException extends RuntimeException {
    public InvalidReviewException(String reviewNotFound) {
        super(reviewNotFound);
    }
}
