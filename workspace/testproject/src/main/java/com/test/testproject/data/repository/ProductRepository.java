package com.test.testproject.data.repository;

import com.test.testproject.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
                                                 // 사용할 Entity, 해당 Entity 아이디값의 데이터 타입
public interface ProductRepository extends JpaRepository<ProductEntity,String> {

}
