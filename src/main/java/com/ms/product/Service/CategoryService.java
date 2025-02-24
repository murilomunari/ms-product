package com.ms.product.Service;

import com.ms.product.Entity.Category;
import com.ms.product.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Category> findByName(String name){
        return categoryRepository.findByName(name);
    }

}
