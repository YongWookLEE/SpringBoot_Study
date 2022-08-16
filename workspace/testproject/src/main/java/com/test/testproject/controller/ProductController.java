package com.test.testproject.controller;

import com.test.testproject.data.dto.ProductDTO;
import com.test.testproject.data.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        String productId = productDTO.getProductId();
        String productName = productDTO.getProductName();
        int productPrice = productDTO.getProductPrice();
        int productStock = productDTO.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }
}
