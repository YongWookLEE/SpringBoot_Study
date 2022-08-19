package com.test.testproject.data.service.impl;

import com.test.testproject.data.dto.MemberDTO;
import com.test.testproject.data.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getTest() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/")
                .encode() // 기본 UTF-8
                .build()  // return 값 UriComponents
                .toUri(); // URI로 형변환

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }


    @Override
    public String getName() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/")
                .queryParam("name", "Woogie")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/")
                .encode()
                .build()
                .expand("Woogie") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/")
                .queryParam("name", "Woogie")
                .queryParam("email", "test@test.com")
                .queryParam("organization", "testcom")
                .encode()
                .build()
                .toUri();

        // MemberDTO는 RequestBody에 값을 넣기위해 사용됨됨
       MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Woogie!!");
        memberDTO.setEmail("test@aaa.com");
        memberDTO.setOrganization("testcom!!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO,
                MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:9090")
                .path("/")
                .encode()
                .build()
                .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("Woogie");
        memberDTO.setEmail("test@test.com");
        memberDTO.setOrganization("testcom");

        RequestEntity<MemberDTO> requestEntity = RequestEntity
                .post(uri)
                .header("testcom-header", "testcom")
                .body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity,
                MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
