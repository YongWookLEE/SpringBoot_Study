package com.test.testproject.controller;

import com.test.testproject.data.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/post")
public class PostController {

    @PostMapping("/default")
    public String postMethod(){
        return "Hello World";
    }

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDTO(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
