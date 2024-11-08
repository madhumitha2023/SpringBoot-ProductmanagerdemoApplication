package co.pragra.learning.productmanagerdemo.controller;

import co.pragra.learning.productmanagerdemo.dto.ErrorDto;
import co.pragra.learning.productmanagerdemo.entity.Review;
import co.pragra.learning.productmanagerdemo.exception.InvalidReviewException;
import co.pragra.learning.productmanagerdemo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/api/product/{id}/review")
    public Review createReview(@RequestBody Review review, @PathVariable("id") UUID productId){
        return reviewService.addReview(review, productId);
    }

//    @PutMapping("/api/review")
//    public ResponseEntity<?> updateReview(@RequestBody Review review){
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(reviewService.updateReview(review));
//        }
//        catch(InvalidReviewException e){
//           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ErrorDto.builder().errorCode(404).errorMessage(e.getMessage()).timestamp(new Date()).build());
//        }
//    }

    @PutMapping("/api/review")
    public ResponseEntity<?> updateReview(@RequestBody Review review){
//        log.info("HttpRequest -> {}", request.getMethod());
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.updateReview(review));
    }
}
