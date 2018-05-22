package com.bean;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
public class Emp {

    private int eid;
    private String name;
    private BigDecimal salary;

}
