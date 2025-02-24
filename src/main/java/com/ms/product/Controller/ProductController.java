package com.ms.product.Controller;

import com.ms.product.DTO.ProductDTO;
import com.ms.product.Entity.Product;
import com.ms.product.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody ProductDTO productDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(productDTO));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name){
        return productService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
