<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.service;

import ${basepackage}.utils.service.BaseService;
import ${basepackage}.${classNameLower}.model.*;
import ${basepackage}.${classNameLower}.repository.${className}Repository;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class ${className}Service extends BaseService<${className}Repository,${className}Query>{


}
