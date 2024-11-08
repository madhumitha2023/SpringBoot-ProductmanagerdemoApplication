package co.pragra.learning.productmanagerdemo.service;

import co.pragra.learning.productmanagerdemo.entity.Product;
import co.pragra.learning.productmanagerdemo.entity.Review;
import co.pragra.learning.productmanagerdemo.entity.User;
import co.pragra.learning.productmanagerdemo.exception.InvalidProductException;
import co.pragra.learning.productmanagerdemo.exception.InvalidReviewException;
import co.pragra.learning.productmanagerdemo.exception.InvalidUserDataException;
import co.pragra.learning.productmanagerdemo.repo.ReviewRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepo reviewRepo;
    private final ProductService productService;
    private final UserService userService;

    public Review addReview(Review review, UUID productId) {
        if (null == review) {
            throw new RuntimeException("Review cannot be null");
        }
        if (null != productId) {
            Optional<Product> productOptional = productService.findById(productId);
            if (productOptional.isPresent()) {
                if (review.getUser() != null) {
                    Optional<User> userOptional = userService.findById(review.getUser().getId());
                    User user = userOptional.orElseThrow(() -> new InvalidUserDataException("User not found"));
                    review.setUser(user);
                }
                Review savedReview = reviewRepo.save(review);
                Product dbProduct = productOptional.get();
                List<Review> reviews = dbProduct.getReviews();
                reviews.add(savedReview);
                dbProduct.setReviews(reviews);
                productService.updateProduct(dbProduct);
                return savedReview;
            }
        } else {
            throw new InvalidProductException("Invalid Product ID: " + productId.toString());
        }

        return null;
    }

//    public Review updateReview(@RequestBody Review review) {
//        if (null != review && !review.getReview().isEmpty() && review.getReview().length() >= 20) {
//            Optional<Review> reviewOptional = reviewRepo.findById(review.getId());
//            Review dbReview = reviewOptional.orElseThrow(() -> new InvalidReviewException("Review Not Found"));
//            dbReview.setReview(review.getReview());
//            return reviewRepo.save(dbReview);
//        }
//        return null;
//    }

    public Review updateReview(@RequestBody Review review) {
        if (null == review || review.getReview().isEmpty() || review.getReview().length() <= 20){
            throw new InvalidReviewException("Review cannot be null or empty or less than 20 characters");
        }
        Optional<Review> reviewOptional = reviewRepo.findById(review.getId());
        Review dbReview = reviewOptional.orElseThrow(() -> new InvalidReviewException("Review Not Found"));
        dbReview.setReview(review.getReview());
        return reviewRepo.save(dbReview);
    }
}
