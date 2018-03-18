package com.pig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.pig.model.Goods;

/**
 * Goods Dao
 * Goods DataBases Access Object
 * Goods 的数据库访问对象
 * @author Administrator
 *
 */
public interface GoodsDao extends JpaRepository<Goods, Long>,JpaSpecificationExecutor<Goods> {

}
