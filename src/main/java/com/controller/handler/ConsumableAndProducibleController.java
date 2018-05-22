package com.controller.handler;

import com.bean.Emp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("cp")
@MultipartConfig
public class ConsumableAndProducibleController {  //MIME

    @PostMapping(value="/consumes", consumes=MediaType.APPLICATION_JSON_VALUE)
    public Emp byConsumes(@RequestBody Emp emp) {
        System.out.println("application/json");
        return emp;
    }

    @PostMapping(value="/produces",  consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE )
    public  Emp byProducesApplicationFormData( Emp emp) {
        System.out.println("application/x-www-form-urlencoded");
        return emp;
    }


    @PostMapping(value="/produces", consumes=MediaType.MULTIPART_FORM_DATA_VALUE )
    public String byProducesMultiPartData(HttpServletRequest request)  {
        System.out.println("multipart/form-data");
        return "file contentType : "+ request.getContentType()+" ,  size"+ request.getContentLengthLong()/1024+" KB . ";
    }
}
