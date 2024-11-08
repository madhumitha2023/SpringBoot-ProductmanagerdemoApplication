package co.pragra.learning.productmanagerdemo.service;

import co.pragra.learning.productmanagerdemo.entity.Product;
import co.pragra.learning.productmanagerdemo.exception.InvalidProductException;
import co.pragra.learning.productmanagerdemo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo repo;

    public Product createProduct(Product product) {
        if(null == product){
            throw new InvalidProductException("Product cannot be null");
        }
        if(product.getName()==null||product.getName().length()<5){
            throw new InvalidProductException("Product name cannot be empty or less than 5 characters");
        }
        product.setReviews(new ArrayList<>());
        return repo.save(product);
    }

    public Product updateProduct(Product product){
        if(null == product){
            throw new InvalidProductException("Product cannot be null");
        }
        Optional<Product> productOptional = repo.findById(product.getId());
        productOptional.orElseThrow(()-> new InvalidProductException("Product with this ID not found"));
        Product dbProduct = productOptional.get();
//        if(product.getName()!=null){
//            dbProduct.setName(product.getName());
//        }
        if(product.getDescription()!=null){
            dbProduct.setDescription(product.getDescription());
        }
        if(product.getCost()!= dbProduct.getCost() && product.getCost()!=0.0){
            dbProduct.setCost(product.getCost());
        }

        if(product.getReviews()!= null){
            dbProduct.setReviews(product.getReviews());
        }
        return repo.save(dbProduct);
    }

    public List<Product> findAll(){
        return repo.findAll();
    }

    public Optional<Product> findById(UUID id){
        return repo.findById(id);
    }

    public List<Product> getProductLessThanPrice(double cost){
        return repo.findCheaperProduct(cost);
    }

}
