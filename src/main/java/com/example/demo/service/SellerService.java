package com.example.demo.service;

import com.example.demo.entity.AddProduct;
import com.example.demo.entity.Product;
import com.example.demo.entity.Seller;
import com.example.demo.entity.Seller_product_Name;
import com.example.demo.repository.ProductRep;
import com.example.demo.repository.SaveProductTest;
import com.example.demo.repository.SellerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SellerService {

    private final SellerRep sellerRep;

    private final ProductRep productRep;
    private final ProductService productService;

    @Autowired
    private SaveProductTest saveProductTest;

    @Autowired
    public SellerService(SellerRep sellerRep, ProductRep productRep, ProductService productService) {
        this.sellerRep = sellerRep;
        this.productRep = productRep;
        this.productService = productService;
    }

    /*public Seller saveSeller(SellRequest request){
        return sellerRep.save(request.getSeller());
    }*/
    public Seller saveSeller(Seller seller) {
        seller.getProducts().forEach(d->d.setSeller(seller));
        return sellerRep.save(seller);
    }
    public Seller getSellerById(Long id){
        return sellerRep.findById(id).orElse(null);
    }
    public List<Seller> getSellers(){
        return sellerRep.findAll();
    }

    //Save product by knowing seller id
    public List<AddProduct> saveProducts(Long SellerId, List<AddProduct> addProduct){
        int length = addProduct.size();
        for(int i = 0; i < length; i++){
            addProduct.get(i).setSeller_id(SellerId);
        }
        return saveProductTest.saveAll(addProduct);
        //return sellerRep.saveProducts(addProduct);
    }

    public List<Product> saveProductsToSeller(Long SellerId, List<Product> products){
        int length = products.size();
        Seller seller = sellerRep.findById(SellerId).orElse(null);
        for(int i = 0; i < length; i++){
            products.get(i).setSeller(seller);
        }
        return productRep.saveAll(products);
    }

    public List<Seller_product_Name> SellerProductName(){
        return sellerRep.SellerProductName();
    }

}
