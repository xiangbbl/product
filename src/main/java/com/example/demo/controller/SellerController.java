package com.example.demo.controller;

import com.example.demo.entity.AddProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.Seller;
import com.example.demo.entity.Seller_product_Name;
import com.example.demo.repository.SellerRep;
import com.example.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    private SellerRep sellerRep;
    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/addSeller")
    public Seller saveSeller(@RequestBody Seller seller) {
        return sellerService.saveSeller(seller);
    }
    /*@PostMapping("/addProducts/{id}")
    public List<AddProduct> saveProducts(@PathVariable Long id, @RequestBody List<AddProduct> product){
        return sellerService.saveProducts(id, product);
        //return sellerService.saveProductsToSeller(id, product);
    }*/

    @PostMapping("/addProductsToSeller/{id}")
    public List<Product> saveProducts(@PathVariable Long id, @RequestBody List<Product> product){
        return sellerService.saveProductsToSeller(id, product);
        //return sellerService.saveProductsToSeller(id, product);
    }
    /*public Object saveSellers(@RequestBody SellRequest request) {
    }*/
    @GetMapping(path = "/id/{id}")
    public Seller getSellerById(@PathVariable Long id){
        return sellerService.getSellerById(id);
    }
    @GetMapping("getSellers")
    public List<Seller> getSellers(){
        return sellerService.getSellers();
    }

    @GetMapping("getSellerProductName")
    public List<Seller_product_Name> getSeller_name(){
        return sellerService.SellerProductName();
    }

}
