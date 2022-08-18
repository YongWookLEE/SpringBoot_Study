package com.test.testproject.data.service.impl;

import com.test.testproject.data.dto.MemberDTO;
import com.test.testproject.data.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        //20 7:58##################################################
        return responseEntity.getBody();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getName2() {
        return null;
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        return null;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        return null;
    }
}
