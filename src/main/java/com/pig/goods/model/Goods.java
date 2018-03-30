package com.pig.goods.model;

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
 * @表名 goods的实体类
 * @category 
 * @author weifuzhou 2018-03-30 17:57:38
 * 
 */
@Entity
@Table(name = "goods")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class Goods implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "goods";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="goods_type")
	private String goodsType;

	@Column(name="goods_name")
	private String goodsName;

	@Column(name="goods_show_img")
	private String goodsShowImg;

	@Column(name="goods_detail_imgs")
	private String goodsDetailImgs;

	@Column(name="goods_carriage")
	private Integer goodsCarriage;

	@Column(name="goods_price")
	private Float goodsPrice;

	@Column(name="user_id")
	private Integer userId;

	@Temporal(TemporalType.TIMESTAMP)   //获取数据库时间格式  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="create_date")
	private Date createDate;


    /**
     * goods
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
     * goods
     * <p>商品类型：  1:每日精选，2：新品首发，3：女神专属，4：手机配件</p>
     */
    public void setGoodsType(String value){
        this.goodsType = value;
    }

    /**
     * <p>商品类型：  1:每日精选，2：新品首发，3：女神专属，4：手机配件</p>
     */
    public String getGoodsType() {
        return this.goodsType;
    }

    /**
     * goods
     * <p>商品名</p>
     */
    public void setGoodsName(String value){
        this.goodsName = value;
    }

    /**
     * <p>商品名</p>
     */
    public String getGoodsName() {
        return this.goodsName;
    }

    /**
     * goods
     * <p>商品展示</p>
     */
    public void setGoodsShowImg(String value){
        this.goodsShowImg = value;
    }

    /**
     * <p>商品展示</p>
     */
    public String getGoodsShowImg() {
        return this.goodsShowImg;
    }

    /**
     * goods
     * <p>商品详情图</p>
     */
    public void setGoodsDetailImgs(String value){
        this.goodsDetailImgs = value;
    }

    /**
     * <p>商品详情图</p>
     */
    public String getGoodsDetailImgs() {
        return this.goodsDetailImgs;
    }

    /**
     * goods
     * <p>goodsCarriage</p>
     */
    public void setGoodsCarriage(Integer value){
        this.goodsCarriage = value;
    }

    /**
     * <p>goodsCarriage</p>
     */
    public Integer getGoodsCarriage() {
        return this.goodsCarriage;
    }

    /**
     * goods
     * <p>商品价格</p>
     */
    public void setGoodsPrice(Float value){
        this.goodsPrice = value;
    }

    /**
     * <p>商品价格</p>
     */
    public Float getGoodsPrice() {
        return this.goodsPrice;
    }

    /**
     * goods
     * <p>发布人id</p>
     */
    public void setUserId(Integer value){
        this.userId = value;
    }

    /**
     * <p>发布人id</p>
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * goods
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


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("goodsType", goodsType);
        map.put("goodsName", goodsName);
        map.put("goodsShowImg", goodsShowImg);
        map.put("goodsDetailImgs", goodsDetailImgs);
        map.put("goodsCarriage", goodsCarriage);
        map.put("goodsPrice", goodsPrice);
        map.put("userId", userId);
        map.put("createDate", createDate);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("goodsType")) this.setGoodsType(DataTypeUtils.getStringValue(map.get("goodsType")));
        if(map.containsKey("goodsName")) this.setGoodsName(DataTypeUtils.getStringValue(map.get("goodsName")));
        if(map.containsKey("goodsShowImg")) this.setGoodsShowImg(DataTypeUtils.getStringValue(map.get("goodsShowImg")));
        if(map.containsKey("goodsDetailImgs")) this.setGoodsDetailImgs(DataTypeUtils.getStringValue(map.get("goodsDetailImgs")));
        if(map.containsKey("goodsCarriage")) this.setGoodsCarriage(DataTypeUtils.getIntegerValue(map.get("goodsCarriage")));
        if(map.containsKey("goodsPrice")) this.setGoodsPrice(DataTypeUtils.getFloatValue(map.get("goodsPrice")));
        if(map.containsKey("userId")) this.setUserId(DataTypeUtils.getIntegerValue(map.get("userId")));
        if(map.containsKey("createDate")) this.setCreateDate(DataTypeUtils.getDateValue(map.get("createDate")));
    }

}
