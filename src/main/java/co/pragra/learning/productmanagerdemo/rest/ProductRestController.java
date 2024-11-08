//package co.pragra.learning.productmanagerdemo.rest;
//
//import co.pragra.learning.productmanagerdemo.entity.Product;
//import co.pragra.learning.productmanagerdemo.repo.ProductRepo;
//import co.pragra.learning.productmanagerdemo.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductRestController {
//    private final ProductService productService;
//
//    @PostMapping("/api/product")
//    public Product createProduct(@RequestBody Product product) {
//        return this.productService.createProduct(product);
//    }
//}
