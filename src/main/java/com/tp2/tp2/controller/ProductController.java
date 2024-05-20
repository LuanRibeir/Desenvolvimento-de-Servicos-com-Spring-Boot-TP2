package com.tp2.tp2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tp2.tp2.model.Product;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/product")
public class ProductController {
    List<Product> products = new ArrayList<>(List.of(
            new Product(0, "Cerveja", 5),
            new Product(1, "Cerveja", 5)));


}
