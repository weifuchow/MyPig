package com.pig.cashFlow.model;

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
 * @表名 cash_flow的实体类
 * @category 
 * @author weifuzhou 2018-03-30 17:57:38
 * 
 */
@Entity
@Table(name = "cash_flow")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class CashFlow implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "cash_flow";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="order_id")
	private Integer orderId;

	@Column(name="account_type")
	private Integer accountType;

	@Column(name="goods_monetary")
	private Float goodsMonetary;

	@Column(name="actual_monetary")
	private Float actualMonetary;

	@Temporal(TemporalType.TIMESTAMP)   //获取数据库时间格式  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="create_date")
	private Date createDate;

	@Column(name="before_balance")
	private Float beforeBalance;

	@Column(name="after_balance")
	private Float afterBalance;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_num")
	private Integer goodsNum;

	@Column(name="user_id")
	private Integer userId;


    /**
     * cash_flow
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
     * cash_flow
     * <p>订单id</p>
     */
    public void setOrderId(Integer value){
        this.orderId = value;
    }

    /**
     * <p>订单id</p>
     */
    public Integer getOrderId() {
        return this.orderId;
    }

    /**
     * cash_flow
     * <p>付款方式 0：消费 1：充值</p>
     */
    public void setAccountType(Integer value){
        this.accountType = value;
    }

    /**
     * <p>付款方式 0：消费 1：充值</p>
     */
    public Integer getAccountType() {
        return this.accountType;
    }

    /**
     * cash_flow
     * <p>消费金额</p>
     */
    public void setGoodsMonetary(Float value){
        this.goodsMonetary = value;
    }

    /**
     * <p>消费金额</p>
     */
    public Float getGoodsMonetary() {
        return this.goodsMonetary;
    }

    /**
     * cash_flow
     * <p>实际消费</p>
     */
    public void setActualMonetary(Float value){
        this.actualMonetary = value;
    }

    /**
     * <p>实际消费</p>
     */
    public Float getActualMonetary() {
        return this.actualMonetary;
    }

    /**
     * cash_flow
     * <p>生成时间</p>
     */
    public void setCreateDate(Date value){
        this.createDate = value;
    }

    /**
     * <p>生成时间</p>
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * cash_flow
     * <p>消费前金额</p>
     */
    public void setBeforeBalance(Float value){
        this.beforeBalance = value;
    }

    /**
     * <p>消费前金额</p>
     */
    public Float getBeforeBalance() {
        return this.beforeBalance;
    }

    /**
     * cash_flow
     * <p>消费后金额</p>
     */
    public void setAfterBalance(Float value){
        this.afterBalance = value;
    }

    /**
     * <p>消费后金额</p>
     */
    public Float getAfterBalance() {
        return this.afterBalance;
    }

    /**
     * cash_flow
     * <p>商品名称 </p>
     */
    public void setGoodsName(String value){
        this.goodsName = value;
    }

    /**
     * <p>商品名称 </p>
     */
    public String getGoodsName() {
        return this.goodsName;
    }

    /**
     * cash_flow
     * <p>商品数</p>
     */
    public void setGoodsNum(Integer value){
        this.goodsNum = value;
    }

    /**
     * <p>商品数</p>
     */
    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    /**
     * cash_flow
     * <p>user_id</p>
     */
    public void setUserId(Integer value){
        this.userId = value;
    }

    /**
     * <p>user_id</p>
     */
    public Integer getUserId() {
        return this.userId;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("orderId", orderId);
        map.put("accountType", accountType);
        map.put("goodsMonetary", goodsMonetary);
        map.put("actualMonetary", actualMonetary);
        map.put("createDate", createDate);
        map.put("beforeBalance", beforeBalance);
        map.put("afterBalance", afterBalance);
        map.put("goodsName", goodsName);
        map.put("goodsNum", goodsNum);
        map.put("userId", userId);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("orderId")) this.setOrderId(DataTypeUtils.getIntegerValue(map.get("orderId")));
        if(map.containsKey("accountType")) this.setAccountType(DataTypeUtils.getIntegerValue(map.get("accountType")));
        if(map.containsKey("goodsMonetary")) this.setGoodsMonetary(DataTypeUtils.getFloatValue(map.get("goodsMonetary")));
        if(map.containsKey("actualMonetary")) this.setActualMonetary(DataTypeUtils.getFloatValue(map.get("actualMonetary")));
        if(map.containsKey("createDate")) this.setCreateDate(DataTypeUtils.getDateValue(map.get("createDate")));
        if(map.containsKey("beforeBalance")) this.setBeforeBalance(DataTypeUtils.getFloatValue(map.get("beforeBalance")));
        if(map.containsKey("afterBalance")) this.setAfterBalance(DataTypeUtils.getFloatValue(map.get("afterBalance")));
        if(map.containsKey("goodsName")) this.setGoodsName(DataTypeUtils.getStringValue(map.get("goodsName")));
        if(map.containsKey("goodsNum")) this.setGoodsNum(DataTypeUtils.getIntegerValue(map.get("goodsNum")));
        if(map.containsKey("userId")) this.setUserId(DataTypeUtils.getIntegerValue(map.get("userId")));
    }

}
