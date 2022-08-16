package com.test.testproject.data.dao;

import com.test.testproject.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);

}
