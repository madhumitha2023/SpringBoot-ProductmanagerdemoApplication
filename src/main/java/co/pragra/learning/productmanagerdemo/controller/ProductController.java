package co.pragra.learning.productmanagerdemo.controller;

import co.pragra.learning.productmanagerdemo.entity.Product;
import co.pragra.learning.productmanagerdemo.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;

    private final RestTemplate restTemplate;

    @PostMapping("/api/product")
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/api/product")
    public List<Product> findAll(
            @RequestParam(value = "cost", required = false) Optional<Double> cost,
            @RequestHeader(value = "User-Agent") String userAgent,
            @RequestHeader(name = "X_Market", defaultValue = "CANADA") String market) {
        log.info("Following is the User Agent {} from request", userAgent);
        if (cost.isPresent()) {
            return productService.getProductLessThanPrice(cost.get());
        }
        if(market != null && market.equals("INDIA")){
            List<Product> all = productService.findAll();
            return all.stream().map(p-> {p.setCost(p.getCost()*61); return p;}).toList();
        }
        return productService.findAll();
    }

    @PutMapping("/api/product")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @GetMapping("/api/product/{id}")
    public Optional<Product> getById(@PathVariable("id") String uuid) {
        UUID uuidFromString = UUID.fromString(uuid);
        return productService.findById(uuidFromString);
    }

    @GetMapping("/api/product/filter")
    public List<Product> getProductLessThanPrice(@RequestParam(value = "cost", required = true) double cost){
        return productService.getProductLessThanPrice(cost);
    }
}
