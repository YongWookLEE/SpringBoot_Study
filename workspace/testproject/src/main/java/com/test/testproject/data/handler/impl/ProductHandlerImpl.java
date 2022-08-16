package com.test.testproject.data.handler.impl;

import com.test.testproject.data.dao.ProductDAO;
import com.test.testproject.data.dto.ProductDTO;
import com.test.testproject.data.entity.ProductEntity;
import com.test.testproject.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductHandlerImpl implements ProductDataHandler {

    public ProductDAO productDAO;

    @Autowired
    public ProductHandlerImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = new ProductEntity(productId,productName,productPrice,productStock);
        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDAO.getProduct(productId);
    }
}
