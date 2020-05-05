package io.dowlath.product.service;

import io.dowlath.product.entity.Product;
import io.dowlath.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    //http://localhost:8081/product/1
    @RequestMapping("/product/{id}")
    Optional<Product> getProduct(@PathVariable("id") int id){
        return productRepository.findById(id);
    }

    //http://localhost:8081/products?id=1
    @RequestMapping("/products")
    List<Product> getProductsForCategory(@RequestParam("id") int id)
    {
        return productRepository.findByCatId(id);
    }
}
