package com.ms.product.Controller;

import com.ms.product.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

}
