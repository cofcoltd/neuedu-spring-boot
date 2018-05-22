package com.service;

import com.bean.Product;
import com.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public void saveProduct(Product product) {

        productRepository.saveProductAndReturnKeys(product);

//        System.out.println(1/0);

    }




}
