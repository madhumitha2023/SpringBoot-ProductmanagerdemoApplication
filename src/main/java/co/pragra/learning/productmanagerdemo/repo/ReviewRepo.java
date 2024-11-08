package co.pragra.learning.productmanagerdemo.repo;

import co.pragra.learning.productmanagerdemo.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
