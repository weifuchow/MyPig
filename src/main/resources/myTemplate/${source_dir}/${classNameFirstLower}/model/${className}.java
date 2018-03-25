<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.model;

import ${basepackage}.utils.DataTypeUtils;
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
 * @表名 ${table.sqlName}的实体类
 * @category ${table.remarks}
 * @author weifuzhou ${now?string("yyyy-MM-dd HH:mm:ss")}
 * 
 */
@Entity
@Table(name = "${table.sqlName}")
@DynamicInsert(true)//动态插入
@DynamicUpdate(true)//动态更新
<#if table.compositeId>
@IdClass(${className}Key.class)
</#if>
public class ${className} implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	public static final String TABLE_NAME = "${table.sqlName}";

	<#list table.columns as column>
	<#if column.pk>
	@Id
	@GeneratedValue
	</#if>
	<#if column.javaType == "Date">
	@Temporal(TemporalType.TIMESTAMP)   //获取数据库时间格式  
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	</#if>
	@Column(name="${column.sqlName}")
	private ${column.javaType} ${column.columnNameLower};

	</#list>

<#list table.columns as column>
    /**
     * ${column.table.sqlName}
     * <p>${column.columnAlias}</p>
     */
    public void set${column.columnName}(${column.javaType} value){
        this.${column.columnNameLower} = value;
    }

    /**
     * <p>${column.columnAlias}</p>
     */
    public ${column.javaType} get${column.columnName}() {
        return this.${column.columnNameLower};
    }

</#list>

    public Map<String, Serializable> convertToMap() {
        HashMap<String, Serializable> map = new HashMap<String, Serializable>();
<#list table.columns as column>
        map.put("${column.columnNameLower}", ${column.columnNameLower});
</#list>
        return map;
    }

    public void updateFromMap(Map<String, Serializable> map) {
<#list table.columns as column>
        if(map.containsKey("${column.columnNameLower}")) this.set${column.columnName}(DataTypeUtils.get${column.javaType}Value(map.get("${column.columnNameLower}")));
</#list>
    }

}
