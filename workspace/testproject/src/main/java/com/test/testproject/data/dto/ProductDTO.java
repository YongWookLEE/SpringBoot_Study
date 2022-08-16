package com.test.testproject.data.dto;

import com.test.testproject.data.entity.ProductEntity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductDTO {

    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;

    public ProductEntity toEntity(){
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }


}
