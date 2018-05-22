package com.bean;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Product {

    private Integer pid;
    private String pname;
    private String description;
    private BigDecimal price;

}
