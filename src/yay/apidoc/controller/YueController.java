package yay.apidoc.controller;

import java.util.HashMap;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/yueyin", produces = {"application/json;charset=utf-8"})
@Api(value = "/yueyin", description="约影")
public class YueController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取用户所有约影信息")
    @ResponseBody
    public Map<String, String> allYueyin(@ApiParam(required = true, value = "用户名") String username) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");
        map.put("status", "0");
        return map;  
    }
	
	@RequestMapping(value = "/{YueyinId}", method = RequestMethod.GET)
    @ApiOperation(notes = "/{YueyinId}", httpMethod = "GET", value = "获取订单详细信息")
    @ResponseBody
    public Map<String, String> detailYueyin(@ApiParam(required = true, value = "用户名")  @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(notes = "/", httpMethod = "POST", value = "发出约影，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，YueyinId")
    @ResponseBody
    public Map<String, String> makeYueyin(@ApiParam(required = true, value = "电影院的id") String cinemaid,
    		@ApiParam(required = true, value = "该电影院下的电影id") String movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{YueyinId}", method = RequestMethod.DELETE)
    @ApiOperation(notes = "/{YueyinId}", httpMethod = "DELETE", value = "取消约影，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，YueyinId")
    @ResponseBody
    public Map<String, String> deleteYueyin(@ApiParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "enter/{YueyinId}/{username}", method = RequestMethod.POST)
    @ApiOperation(notes = "enter/{YueyinId}/{username}", httpMethod = "POST", value = "用户加入其他人发起的约影，返回结果为json，status：1代表成功，0代表失败，msg为错误信息，YueyinId")
    @ResponseBody
    public Map<String, String> enterYueyin(@ApiParam(required = true, value = "用户名") @PathVariable("username") String username,
    		@ApiParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "enter/{YueyinId}/{username}", method = RequestMethod.DELETE)
    @ApiOperation(notes = "enter/{YueyinId}/{username}", httpMethod = "DELETE", value = "退出其他人发起的约影，返回结果为json，status：1代表成功，0代表失败，msg为错误信息，YueyinId")
    @ResponseBody
    public Map<String, String> leaveYueyin(@ApiParam(required = true, value = "用户名") @PathVariable("username") String username,
    		@ApiParam(required = true, value = "订单的id") @PathVariable("YueyinId") Integer YueyinId) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
