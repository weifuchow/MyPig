package com.pig.cart.model;

import com.pig.goods.model.Goods;
import com.pig.utils.DataTypeUtils;
import javax.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

/**
 * @表名 cart的实体类
 * @category 
 * @author weifuzhou 2018-03-31 11:57:13
 * 
 */
@Entity
@Table(name = "cart")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class Cart implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "cart";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="goods_id")
	private Integer goodsId;

	@Column(name="goods_num")
	private Integer goodsNum;

	@Column(name="status")
	private Integer status;

	@Transient
	private Goods goods;
	
	
    public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	/**
     * cart
     * <p>id</p>
     */
    public void setId(Integer value){
        this.id = value;
    }

    /**
     * <p>id</p>
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * cart
     * <p>用户ID</p>
     */
    public void setUserId(Integer value){
        this.userId = value;
    }

    /**
     * <p>用户ID</p>
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * cart
     * <p>商品Id</p>
     */
    public void setGoodsId(Integer value){
        this.goodsId = value;
    }

    /**
     * <p>商品Id</p>
     */
    public Integer getGoodsId() {
        return this.goodsId;
    }

    /**
     * cart
     * <p>商品数量</p>
     */
    public void setGoodsNum(Integer value){
        this.goodsNum = value;
    }

    /**
     * <p>商品数量</p>
     */
    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    /**
     * cart
     * <p>状态 0：加入购物车、未付款 1：已付款</p>
     */
    public void setStatus(Integer value){
        this.status = value;
    }

    /**
     * <p>状态 0：加入购物车、未付款 1：已付款</p>
     */
    public Integer getStatus() {
        return this.status;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        map.put("goodsNum", goodsNum);
        map.put("status", status);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("userId")) this.setUserId(DataTypeUtils.getIntegerValue(map.get("userId")));
        if(map.containsKey("goodsId")) this.setGoodsId(DataTypeUtils.getIntegerValue(map.get("goodsId")));
        if(map.containsKey("goodsNum")) this.setGoodsNum(DataTypeUtils.getIntegerValue(map.get("goodsNum")));
        if(map.containsKey("status")) this.setStatus(DataTypeUtils.getIntegerValue(map.get("status")));
    }

}
