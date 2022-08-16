package com.test.testproject.data.service.impl;

import com.test.testproject.data.dto.ProductDTO;
import com.test.testproject.data.entity.ProductEntity;
import com.test.testproject.data.handler.ProductDataHandler;
import com.test.testproject.data.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl (ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDTO;
    }

    @Override
    public ProductDTO getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDTO productDTO = new ProductDTO(productEntity.getProductId(),
                productEntity.getProductName(), productEntity.getProductPrice(), productEntity.getProductStock());

        return productDTO;
    }
}
