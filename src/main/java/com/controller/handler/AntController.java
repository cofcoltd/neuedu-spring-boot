package com.controller.handler;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
public class AntController {

    //http://localhost:8088/sd/ant/emp/1/user/2
    //http://localhost:8088/sd/ant/asdasdasd
//    @RequestMapping("/ant/**")
//    public String ant01( HttpServletRequest request ) {
//
//        return "result : " + request.getRequestURI();
//    }

    //http://localhost:8088/mvc01/anta
    @RequestMapping("/ant?")
    public String ant02( HttpServletRequest request ) {
        return " uri : "+request.getRequestURI() ;
    }

    @RequestMapping("/ants/**/{id}")
    public  String ant03(@PathVariable("id") Integer id) {
        return " id : "+id  ;
    }


}
