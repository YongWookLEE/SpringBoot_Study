package com.test.testproject.data.handler;

import com.test.testproject.data.entity.ProductEntity;

public interface ProductDataHandler {
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);

    ProductEntity getProductEntity(String productId);
}
