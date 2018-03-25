package com.pig.goods.repository;

import com.pig.goods.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface GoodsRepository extends JpaRepository<Goods,Integer>, JpaSpecificationExecutor<Goods>{

}
