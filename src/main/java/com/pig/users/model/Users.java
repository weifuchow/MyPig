package com.pig.users.model;

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
 * @表名 users的实体类
 * @category 
 * @author weifuzhou 2018-03-29 19:50:13
 * 
 */
@Entity
@Table(name = "users")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
public class Users implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "users";

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;

	@Column(name="user_name")
	private String userName;

	@Column(name="user_img")
	private String userImg;

	@Column(name="balance")
	private Float balance;

	@Column(name="phone")
	private String phone;

	@Temporal(TemporalType.TIMESTAMP)   //获取数据库时间格式  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@Column(name="create_date")
	private Date createDate;

	@Column(name="password")
	private String password;


    /**
     * users
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
     * users
     * <p>用户名</p>
     */
    public void setUserName(String value){
        this.userName = value;
    }

    /**
     * <p>用户名</p>
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * users
     * <p>头像</p>
     */
    public void setUserImg(String value){
        this.userImg = value;
    }

    /**
     * <p>头像</p>
     */
    public String getUserImg() {
        return this.userImg;
    }

    /**
     * users
     * <p>余额</p>
     */
    public void setBalance(Float value){
        this.balance = value;
    }

    /**
     * <p>余额</p>
     */
    public Float getBalance() {
        return this.balance;
    }

    /**
     * users
     * <p>电话</p>
     */
    public void setPhone(String value){
        this.phone = value;
    }

    /**
     * <p>电话</p>
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * users
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
     * users
     * <p>password</p>
     */
    public void setPassword(String value){
        this.password = value;
    }

    /**
     * <p>password</p>
     */
    public String getPassword() {
        return this.password;
    }


    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
        map.put("id", id);
        map.put("userName", userName);
        map.put("userImg", userImg);
        map.put("balance", balance);
        map.put("phone", phone);
        map.put("createDate", createDate);
        map.put("password", password);
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
        if(map.containsKey("id")) this.setId(DataTypeUtils.getIntegerValue(map.get("id")));
        if(map.containsKey("userName")) this.setUserName(DataTypeUtils.getStringValue(map.get("userName")));
        if(map.containsKey("userImg")) this.setUserImg(DataTypeUtils.getStringValue(map.get("userImg")));
        if(map.containsKey("balance")) this.setBalance(DataTypeUtils.getFloatValue(map.get("balance")));
        if(map.containsKey("phone")) this.setPhone(DataTypeUtils.getStringValue(map.get("phone")));
        if(map.containsKey("createDate")) this.setCreateDate(DataTypeUtils.getDateValue(map.get("createDate")));
        if(map.containsKey("password")) this.setPassword(DataTypeUtils.getStringValue(map.get("password")));
    }

}
