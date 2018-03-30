package com.pig.address.model;

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
 * @表名 address的实体类
 * @category 
 * @author weifuzhou 2018-03-30 17:57:38
 * 
 */
@Entity
@Table(name = "address")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class Address implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "address";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="address_user_id")
	private Integer addressUserId;

	@Column(name="address_user_name")
	private String addressUserName;

	@Column(name="address_user_phone")
	private String addressUserPhone;

	@Column(name="address_province")
	private String addressProvince;

	@Column(name="address_detail")
	private String addressDetail;

	@Column(name="status")
	private Integer status;


    /**
     * address
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
     * address
     * <p>收件人id</p>
     */
    public void setAddressUserId(Integer value){
        this.addressUserId = value;
    }

    /**
     * <p>收件人id</p>
     */
    public Integer getAddressUserId() {
        return this.addressUserId;
    }

    /**
     * address
     * <p>收件人名字</p>
     */
    public void setAddressUserName(String value){
        this.addressUserName = value;
    }

    /**
     * <p>收件人名字</p>
     */
    public String getAddressUserName() {
        return this.addressUserName;
    }

    /**
     * address
     * <p>收件人电话</p>
     */
    public void setAddressUserPhone(String value){
        this.addressUserPhone = value;
    }

    /**
     * <p>收件人电话</p>
     */
    public String getAddressUserPhone() {
        return this.addressUserPhone;
    }

    /**
     * address
     * <p>所在省份</p>
     */
    public void setAddressProvince(String value){
        this.addressProvince = value;
    }

    /**
     * <p>所在省份</p>
     */
    public String getAddressProvince() {
        return this.addressProvince;
    }

    /**
     * address
     * <p>详细地址</p>
     */
    public void setAddressDetail(String value){
        this.addressDetail = value;
    }

    /**
     * <p>详细地址</p>
     */
    public String getAddressDetail() {
        return this.addressDetail;
    }

    /**
     * address
     * <p>状态 0：启用 1：不启用</p>
     */
    public void setStatus(Integer value){
        this.status = value;
    }

    /**
     * <p>状态 0：启用 1：不启用</p>
     */
    public Integer getStatus() {
        return this.status;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("addressUserId", addressUserId);
        map.put("addressUserName", addressUserName);
        map.put("addressUserPhone", addressUserPhone);
        map.put("addressProvince", addressProvince);
        map.put("addressDetail", addressDetail);
        map.put("status", status);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("addressUserId")) this.setAddressUserId(DataTypeUtils.getIntegerValue(map.get("addressUserId")));
        if(map.containsKey("addressUserName")) this.setAddressUserName(DataTypeUtils.getStringValue(map.get("addressUserName")));
        if(map.containsKey("addressUserPhone")) this.setAddressUserPhone(DataTypeUtils.getStringValue(map.get("addressUserPhone")));
        if(map.containsKey("addressProvince")) this.setAddressProvince(DataTypeUtils.getStringValue(map.get("addressProvince")));
        if(map.containsKey("addressDetail")) this.setAddressDetail(DataTypeUtils.getStringValue(map.get("addressDetail")));
        if(map.containsKey("status")) this.setStatus(DataTypeUtils.getIntegerValue(map.get("status")));
    }

}
