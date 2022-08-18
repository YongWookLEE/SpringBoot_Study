package com.test.testproject.controller;

import com.test.testproject.common.Constants;
import com.test.testproject.common.exception.TestException;
import com.test.testproject.data.dto.ProductDTO;
import com.test.testproject.data.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[getProduct] perform {} of Around Hub API.", "getProduct");

        ProductDTO productDto = productService.getProduct(productId);

        LOGGER.info(
                "[getProduct] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(),
                productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(),
                (System.currentTimeMillis() - startTime));
        return productDto;
    }

    @PostMapping("/product")                        // DTO에 달아놓은 제약조건을 실행시키려면 Valid 어노테이션을 달아야한다
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO){

        LOGGER.info("[createProduct] perform {} of Test API.", "createProduct");

        // Validation Code Example 어노테이션 없을때 제약조건 세우던 코드
        if (productDTO.getProductId().equals("") || productDTO.getProductId().isEmpty()) {
            LOGGER.error("[createProduct] failed Response :: productId is Empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDTO);
        }

        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        ProductDTO response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info(
                "[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(),
                response.getProductStock());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{productId}")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }

    @PostMapping("/exception")
    public void exceptionTest() throws TestException{
        throw new TestException(Constants.ExceptionClass.PRODUCT,HttpStatus.NOT_FOUND,"의도한 에러가 발생");
    }
}
