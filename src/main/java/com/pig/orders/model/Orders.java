package com.pig.orders.model;

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
 * @表名 orders的实体类
 * @category 
 * @author weifuzhou 2018-03-31 11:57:13
 * 
 */
@Entity
@Table(name = "orders")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class Orders implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "orders";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="user_id")
	private Integer userId;

	@Column(name="goods_id")
	private Integer goodsId;

	@Column(name="address_id")
	private Integer addressId;

	@Temporal(TemporalType.TIMESTAMP)   //获取数据库时间格式  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="create_date")
	private Date createDate;

	@Column(name="goods_nums")
	private Integer goodsNums;

	@Column(name="order_price")
	private Float orderPrice;


    /**
     * orders
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
     * orders
     * <p>用户id</p>
     */
    public void setUserId(Integer value){
        this.userId = value;
    }

    /**
     * <p>用户id</p>
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * orders
     * <p>商品id</p>
     */
    public void setGoodsId(Integer value){
        this.goodsId = value;
    }

    /**
     * <p>商品id</p>
     */
    public Integer getGoodsId() {
        return this.goodsId;
    }

    /**
     * orders
     * <p>地址id</p>
     */
    public void setAddressId(Integer value){
        this.addressId = value;
    }

    /**
     * <p>地址id</p>
     */
    public Integer getAddressId() {
        return this.addressId;
    }

    /**
     * orders
     * <p>创建时间</p>
     */
    public void setCreateDate(Date value){
        this.createDate = value;
    }

    /**
     * <p>创建时间</p>
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * orders
     * <p>商品价格</p>
     */
    public void setGoodsNums(Integer value){
        this.goodsNums = value;
    }

    /**
     * <p>商品价格</p>
     */
    public Integer getGoodsNums() {
        return this.goodsNums;
    }

    /**
     * orders
     * <p>订单价格</p>
     */
    public void setOrderPrice(Float value){
        this.orderPrice = value;
    }

    /**
     * <p>订单价格</p>
     */
    public Float getOrderPrice() {
        return this.orderPrice;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("userId", userId);
        map.put("goodsId", goodsId);
        map.put("addressId", addressId);
        map.put("createDate", createDate);
        map.put("goodsNums", goodsNums);
        map.put("orderPrice", orderPrice);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("userId")) this.setUserId(DataTypeUtils.getIntegerValue(map.get("userId")));
        if(map.containsKey("goodsId")) this.setGoodsId(DataTypeUtils.getIntegerValue(map.get("goodsId")));
        if(map.containsKey("addressId")) this.setAddressId(DataTypeUtils.getIntegerValue(map.get("addressId")));
        if(map.containsKey("createDate")) this.setCreateDate(DataTypeUtils.getDateValue(map.get("createDate")));
        if(map.containsKey("goodsNums")) this.setGoodsNums(DataTypeUtils.getIntegerValue(map.get("goodsNums")));
        if(map.containsKey("orderPrice")) this.setOrderPrice(DataTypeUtils.getFloatValue(map.get("orderPrice")));
    }

}
