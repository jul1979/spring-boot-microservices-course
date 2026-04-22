package com.sivalabs.bookstore.catalog.web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sivalabs.bookstore.catalog.domain.PagedResult;
import com.sivalabs.bookstore.catalog.domain.Product;
import com.sivalabs.bookstore.catalog.domain.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    PagedResult<Product> getMethodName(@RequestParam(name = "page", defaultValue = "1") String page) {
        int pageNo = Integer.parseInt(page);
        return productService.getProducts(pageNo);
    }

}
