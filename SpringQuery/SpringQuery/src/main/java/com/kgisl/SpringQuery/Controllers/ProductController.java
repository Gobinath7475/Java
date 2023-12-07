package com.kgisl.SpringQuery.Controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kgisl.SpringQuery.Repository.ProductRepository;
import com.kgisl.SpringQuery.entity.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/findByName")
    public ResponseEntity<Product> findByNameMethod() {
        Product product = productRepository.findByName("Product 1");

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Product> findByIdMethod(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNameOrDescription")
    public ResponseEntity<List<Product>> findByNameOrDescriptionMethod() {
        List<Product> products = productRepository.findByNameOrDescription("Product 1", "Description for Product 1");

        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findDistinctByName")
    public ResponseEntity<Product> findDistinctByNameMethod() {
        Product product = productRepository.findDistinctByName("Product 3");
        return ResponseEntity.ok(product);
    }

    @GetMapping("/findByPriceGreaterThan")
    public ResponseEntity<List<Product>> findByPriceGreaterThanMethod() {
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(10));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByPriceLessThan")
    public ResponseEntity<List<Product>> findByPriceLessThanMethod() {
        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByNameContaining")
    public ResponseEntity<List<Product>> findByNameContainingMethod() {
        List<Product> products = productRepository.findByNameContaining("Product 1");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByNameLike")
    public ResponseEntity<List<Product>> findByNameLikeMethod() {
        List<Product> products = productRepository.findByNameLike("Product 1");
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByPriceBetween")
    public ResponseEntity<List<Product>> findByPriceBetweenMethod() {
        List<Product> products = productRepository.findByPriceBetween(new BigDecimal(10), new BigDecimal(20));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/findByDateCreatedBetween")
    public ResponseEntity<List<Product>> findByDateCreatedBetweenMethod() {
        LocalDateTime startDate = LocalDateTime.of(2022, 02, 13, 17, 48, 33);
        LocalDateTime endDate = LocalDateTime.of(2022, 02, 13, 18, 15, 21);
        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);
        return ResponseEntity.ok(products);
    }
}
