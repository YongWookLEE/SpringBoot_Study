package com.test.testproject.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delete")
public class DeleteController {

    @DeleteMapping("/{variable}")
    public String deleteVariable(@PathVariable("variable") String var){
        return var;
    }
}
