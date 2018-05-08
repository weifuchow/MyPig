<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.${classNameLower}.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ${basepackage}.utils.entity.*;
import ${basepackage}.${classNameLower}.model.*;
import ${basepackage}.${classNameLower}.service.${className}Service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/${classNameLower}/api")
@RestController
@Api(value = "${className}Contrller相关",tags = "Api文档")
public class ${className}Controller{

    @Autowired
    ${className}Service ${classNameLower}Service;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询${className}的信息",notes = "无条件，简单查询所有学生")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult ${classNameLower}(${className}Query query) {
        return ${classNameLower}Service.getPage(query);
    }

    @RequestMapping(value = "/add" , method = RequestMethod.POST)
    @ApiOperation(value = "添加${className}的信息",notes = "参数不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult add${className}(${className} ${classNameLower}) {
    	return WeifuResult.getIsOkResult(
    			${classNameLower}Service.saveAndFlush(${classNameLower}));
    }
    
    @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    @ApiOperation(value = "修改${className}的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult update${className}(${className} ${classNameLower}) {
    	return WeifuResult.getIsOkResult(
    			${classNameLower}Service.modify(${classNameLower},${classNameLower}.getId()));
    }
    
    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    @ApiOperation(value = "删除${className}的信息",notes = "id不能为空")
    @ApiResponses({
            @ApiResponse(code = 400,message = "请求参数没填好"),
            @ApiResponse(code = 401,message = "未认证"),
            @ApiResponse(code = 403,message = "请求非法，请求方式错误"),
            @ApiResponse(code = 404,message = "页面不存在")
    })
    public WeifuResult delate${className}(@RequestParam(value = "id" ,required = true) Integer id) {
    	${classNameLower}Service.deleteById(id);	
    	return WeifuResult.getIsOkResult(null);
    }
    
}
