package com.bean;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Product {

    private Integer id;
    private String name;
    private String desc;
    private BigDecimal price;

}
