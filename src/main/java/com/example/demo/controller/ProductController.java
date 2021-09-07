package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> saveProducts(@RequestBody List<Product> product){
        return productService.saveProducts(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
    @GetMapping(path = "/id/{id}")
    //@GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @GetMapping(path = "/name/{name}")
    //@GetMapping("/product/{name}")
    public Product getProductByName(@PathVariable String name){
        return productService.getProductByName(name);
    }
    @DeleteMapping(path = "/delete/{id}")
    //@DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }
    @PutMapping (path = "/update")
    //@PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);

    }
}
