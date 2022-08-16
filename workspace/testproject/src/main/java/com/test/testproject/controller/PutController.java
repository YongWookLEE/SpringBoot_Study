package com.test.testproject.controller;

import com.test.testproject.data.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/put")
public class PutController {

    @PutMapping("/default")
    public String putMethod(){
        return "Hello World!";
    }

    @PutMapping("/member")
    public String postMember(@RequestBody Map<String, Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map ->{
            sb.append(map.getKey() + " " + map.getValue());
        });

        return sb.toString();
    }

    @PutMapping("/member1")
    public String postMemberDTO1(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

    @PutMapping("/member2")
    public MemberDTO postMemberDTO2(@RequestBody MemberDTO memberDTO){
        return memberDTO;
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDTO> postMemberDTO3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }


}
