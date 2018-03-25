${gg.setIgnoreOutput(table.pkCount <= 1)}

<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.${classNameLower}.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.io.Serializable;

public class ${className}Key  implements Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
<#list table.columns as column>
	<#if column.pk>
	private ${column.javaType} ${column.columnNameLower};
	</#if>
</#list>

<@generateConstructor className+"Key"/>
	
<#list table.columns as column>
	<#if column.pk>
	
	public void set${column.columnName}(${column.javaType} value) {
		this.${column.columnNameLower} = value;
	}
	
	<#if column.isDateTimeColumn>
	@Temporal(TemporalType.DATE)
	</#if>
	@Column(name = "${column.sqlName}", unique = ${column.unique?string}, nullable = ${column.nullable?string}, insertable = true, updatable = true, length = ${column.size})	
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	</#if>
</#list>
}