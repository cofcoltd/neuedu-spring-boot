package com.service;

import com.bean.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceTest {


    @Autowired
    ProductService productService;

    @Test
    public void saveProduct() {

        Product p = new Product();
        p.setPname("spring ioc5");
        p.setPrice(new BigDecimal("10500"));
        p.setDescription("spring 核心开发技巧");

        productService.saveProduct(p);

    }
}