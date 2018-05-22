package com.controller.handler;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/matrix")
public class MatrixController {

    ///http://localhost:8088/sd/matrix/matrixvars;foo=bar/simple
    //      matrixvars;foo=bar    ---> path
    @RequestMapping(value = "{path}/simple", method = RequestMethod.GET)
    public  String withMatrixVariable(@PathVariable String path, @MatrixVariable(value = "foo", pathVar = "path") String foo
           ) {
            return "'foo=" + foo + "' from  '" + path + "'";
    }

    //matrixvars;foo=bar1/multiple;foo=bar2
    @GetMapping("{path1}/{path2}")
    public String withMatrixVariablesMultiple(
            @PathVariable String path1,
            @MatrixVariable(value = "foo", pathVar = "path1") String foo1,
            @PathVariable String path2,
            @MatrixVariable(value = "foo", pathVar = "path2") String foo2) {

        return "foo=" + foo1 + " from path segment '" + path1 + "'" + "foo=" + foo2 + " from path segment '" + path2 + "'";
    }

    // account;ids=12,45,9
    @RequestMapping(value = "/account;{ids}", method = RequestMethod.GET)
    public @ResponseBody String withMatrixVariablesAndAssembleToMap(
            @MatrixVariable(pathVar = "ids") MultiValueMap paths) {

        return "Obtained matrix variable (map) : " + paths;  //结果只能拿到12
    }

    //http://localhost:8088/mvc01/matrix/owners/40;q=1;o=2;w=3/pets/20;q=4
    //40;q=1;o=2;w=3
    @GetMapping("/owners/{ownerId}/pets/{petId}")
    public  String withMatrixVariablesMultiple2(
            @PathVariable("ownerId") int ownerId,  //-->40
            @PathVariable("petId") int petId,              //-->20
            @MatrixVariable(value = "q", pathVar = "ownerId") int q1,    //-->q=1
            @MatrixVariable(value = "o", pathVar = "ownerId") int o,        //-->o=2
            @MatrixVariable(value = "q", pathVar = "petId") int q2) {       //-->q=4

        return "ownerId : " + ownerId + " , q1 =" + q1 + ",  o ="+ o + " ; petId : " + petId + " , q2 =" + q2;
                //ownerId : 40 , q1 =1 , o =2 ; petId : 20 , q2 =4
    }

    //http://localhost:8088/mvc01/matrix/owners/42;q=11;r=12/pets/21;q=22;s=23
    @GetMapping("/find/owners/{ownerId}/pets/{petId}")
    public  String withMatrixVariablesMultiple3(
            @PathVariable("ownerId") int ownerId,
            @PathVariable("petId") int petId,
            @MatrixVariable Map<String, String> matrixVars,
            @MatrixVariable(pathVar = "ownerId") Map<String, String> ownerMatrixVars,
            @MatrixVariable(pathVar = "petId") Map<String, String> petMatrixVars) {

        StringBuilder msg = new StringBuilder();
        msg.append("ownerId : ").append(ownerId).append(" . ");
        msg.append("petId : ").append(petId).append(" . ").append("<br>");
        msg.append("matrixVars : ").append(matrixVars).append(" . ").append("<br>");
        msg.append("ownerMatrixVars : ").append(ownerMatrixVars).append(" . ").append("<br>");
        msg.append("petMatrixVars : ").append(petMatrixVars).append(" . ").append("<br>");

        return msg.toString();
    }


}
