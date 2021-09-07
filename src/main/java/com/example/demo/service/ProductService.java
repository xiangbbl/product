package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRep productRep;

    public Product saveProduct(Product product){
        return productRep.save(product);
    }

    public List<Product> saveProducts(List<Product> product){
        return productRep.saveAll(product);
    }

    public Product getProductById(Long id){
        return productRep.findById(id).orElse(null);
    }

    public List<Product> getProducts(){
        return productRep.findAll();
    }

    public Product getProductByName(String name){
        return productRep.findByName(name);
    }

    public void deleteProduct(Long id){
        productRep.deleteById(id);
    }

    public Product updateProduct(Product product){
        Product old_product = productRep.findById(product.getId()).orElse(null);
        old_product.setName(product.getName());
        old_product.setQuantity(product.getQuantity());
        old_product.setPrice(product.getPrice());
        return productRep.save(old_product);

    }
}
