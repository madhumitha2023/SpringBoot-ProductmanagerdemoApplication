package co.pragra.learning.productmanagerdemo.repo;

import co.pragra.learning.productmanagerdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepo extends JpaRepository<Product, UUID> {
    @Query(value = "SELECT * FROM product WHERE cost < 1000", nativeQuery = true)
    List<Product> findCheaperProduct(double cost);
}
