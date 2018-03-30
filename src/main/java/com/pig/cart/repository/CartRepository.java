package com.pig.cart.repository;

import com.pig.cart.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>, JpaSpecificationExecutor<Cart>{

}
