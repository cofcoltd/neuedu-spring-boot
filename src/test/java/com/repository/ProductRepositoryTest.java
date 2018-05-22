package com.repository;

import com.bean.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void getProducts() {

        List<Product> products = productRepository.getProducts();

        for (Product p : products) {
            System.out.println(p);
        }

    }

    @Test
    public void saveProduct() {

        Product p = new Product();
        p.setPname("spring ioc");
        p.setPrice(new BigDecimal("50"));
        p.setDescription("spring 核心开发技巧");


        int row = productRepository.saveProduct(p);

        System.out.println("行 : " + row );

    }

    @Test
    public void saveProductAndReturnKeys() {

        Product p = new Product();
        p.setPname("spring ioc2");
        p.setPrice(new BigDecimal("500"));
        p.setDescription("spring 核心开发技巧");

        p = productRepository.saveProductAndReturnKeys(p);

        System.out.println("保存的内容是 : " + p);
    }
}