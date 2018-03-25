<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.repository;

import ${basepackage}.${classNameLower}.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


@Repository
public interface ${className}Repository extends JpaRepository<${className},<#if table.compositeId>${className}Key<#else>${table.idColumn.javaType}</#if>>, JpaSpecificationExecutor<${className}>{

}
