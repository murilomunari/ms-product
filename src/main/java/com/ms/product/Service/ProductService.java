package com.ms.product.Service;

import com.ms.product.DTO.ProductDTO;
import com.ms.product.Entity.Category;
import com.ms.product.Entity.Product;
import com.ms.product.Repository.CategoryRepository;
import com.ms.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product create(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setPrice(productDTO.price());

        Optional<Category> categoryOptional = categoryRepository.findById(productDTO.categoryId());

        if (categoryOptional.isEmpty()){
            throw new IllegalArgumentException("Category not found with ID: " + productDTO.categoryId());
        }

        product.setCategory(categoryOptional.get());

        return  productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Optional<Product> findByName (String name){
        return productRepository.findByName(name);
    }
}
