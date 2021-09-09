package com.example.demo.repository;

import com.example.demo.entity.AddProduct;
import com.example.demo.entity.Seller;
import com.example.demo.entity.Seller_product_Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRep extends JpaRepository<Seller, Long> {
    @Query("Select new " +
            "com.example.demo.entity.Seller_product_Name(s.name, p.name)" +
            "From Seller AS s Join s.products AS p")
    public List<Seller_product_Name> SellerProductName();

    //public List<AddProduct> saveProducts(List<AddProduct> addProduct);
    //@Query("select new com.example.demo.entity.SellerProductNameById(s.name, List<p.name>) From Seller AS s Join s.products AS p"gr)
    //public SellerProductNameById SellerProductNameById(Long id);
    //@Query(value = "Select Seller.name From Seller", nativeQuery = true)
    //public List<SellerNameOnly> getSeller_name();
    //public Seller_product_Name getNameOfSeller_product();
}
