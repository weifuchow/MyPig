<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.controller;

import ${basepackage}.utils.entity.WeifuResult;
import ${basepackage}.${classNameLower}.model.*;
import ${basepackage}.${classNameLower}.service.${className}Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/${classNameLower}/api")
@RestController
public class ${className}Controller{

    @Autowired
    ${className}Service ${classNameLower}Service;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public WeifuResult ${classNameLower}(${className}Query query) {
        return ${classNameLower}Service.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    public WeifuResult add${className}(${className} ${classNameLower}) {
    	return WeifuResult.getIsOkResult(
    			${classNameLower}Service.saveAndFlush(${classNameLower}));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public WeifuResult UpdateSysUser(${className} ${classNameLower}) {
    	return WeifuResult.getIsOkResult(
    			${classNameLower}Service.modify(${classNameLower},${classNameLower}.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public WeifuResult UpdateSysUser(@RequestParam(value = "id" ,required = true) Long id) {
    	${classNameLower}Service.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
