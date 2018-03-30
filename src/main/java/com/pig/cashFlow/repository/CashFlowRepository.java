package com.pig.cashFlow.repository;

import com.pig.cashFlow.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface CashFlowRepository extends JpaRepository<CashFlow,Integer>, JpaSpecificationExecutor<CashFlow>{

}
