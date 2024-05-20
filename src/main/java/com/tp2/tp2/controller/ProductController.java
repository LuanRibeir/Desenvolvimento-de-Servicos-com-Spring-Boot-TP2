package com.tp2.tp2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp2.tp2.model.Product;

import java.util.List;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/product")
public class ProductController {
    List<Product> products = new ArrayList<>(List.of(
            new Product(0, "Cerveja", 5),
            new Product(1, "Cerveja", 5)));

    @GetMapping("/")
    public List<Product> allProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product singleProduct(@RequestParam int id) {
        return products.stream().filter(product -> product.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @PostMapping("/")
    public Product add(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, product);
                return ResponseEntity.ok(product);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
