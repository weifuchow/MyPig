package com.pig.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Goods {

	@Id
	private Long id;
	
	@Column
	private String goodsType;
	
	@Column
	private String goodsName;
	
	@Column
	private String goodsShowImg;
	
	@Column
	private String goodsDetailImgs;
	
	public String getGoodsDetailImgs() {
		return goodsDetailImgs;
	}

	public void setGoodsDetailImgs(String goodsDetailImgs) {
		this.goodsDetailImgs = goodsDetailImgs;
	}

	@Column
	private String goodsCarriage;
	
	@Column
	private String goodsPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsShowImg() {
		return goodsShowImg;
	}

	public void setGoodsShowImg(String goodsShowImg) {
		this.goodsShowImg = goodsShowImg;
	}

	public String getGoodsCarriage() {
		return goodsCarriage;
	}

	public void setGoodsCarriage(String goodsCarriage) {
		this.goodsCarriage = goodsCarriage;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	
	
	
}
