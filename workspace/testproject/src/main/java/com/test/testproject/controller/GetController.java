package com.test.testproject.controller;

import com.test.testproject.data.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/get")
public class GetController {

    @GetMapping("/name")
    public String getName(){
        return "Woogie";
    }

    @GetMapping("/variable/{variable}")
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    @GetMapping("/request1")
    public String getRequestParam1(@RequestParam String name,@RequestParam String email,@RequestParam String organization){
        return name + " " + email + " " +organization;
    }

    @GetMapping("/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        StringBuilder sb = new StringBuilder();

        // Map에 값을 전체 출력하기 위해서는 entrySet(), keySet() 메소드를 사용
        // entrySet() 메서드는 key와 value의 값이 모두 필요한 경우 사용하고, keySet() 메서드는 key의 값만 필요한 경우 사용
        // Map.Entry는 Map 형태의 인터페이스를 만드는데 사용, 실제 사용은 Map을 For문에서 돌려줄 경우 인터페이스 용도로 사용
        // 또는 스트림(Stream) 사용 시 Map 형식의 데이터에서 처리가 필요할 때 Map.Entry를 사용하여 처리
        param.entrySet().forEach(map ->{
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }




}
