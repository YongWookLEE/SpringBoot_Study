package com.test.testproject.data.service;

import com.test.testproject.data.dto.ProductDTO;

public interface ProductService {
    ProductDTO saveProduct(String productId, String productName, int productPrice, int productStock);

    ProductDTO getProduct(String productId);
}
