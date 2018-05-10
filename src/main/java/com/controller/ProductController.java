package com.controller;

import com.bean.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {


    //   localhost:8088/sd/product/10
    // @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getProduct(@PathVariable("id") Integer id) {
        return "获取到了 id 为 : "+id + " 的产品信息";
    }

    @GetMapping
    public String getProduct() {
        return "获取到了所有s产品信息";
    }

    @PostMapping
    public Product saveProduct(Product product) {
        return product;
    }

    @PutMapping
    public Product updateProduct(Product product) {
        System.out.println("修改信息");
        return product;
    }

    @DeleteMapping("/{id}")
    public String removeProduct(@PathVariable("id") Integer id) {

        return "删除了 id 为 : "+id+ " 的产品";
    }





}
