package yay.apidoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yay.apidoc.model.Yueyin;
import yay.apidoc.utils.BeansUtils;
import yay.apidoc.utils.JsonUtils;


@RestController
@RequestMapping(value = "/yueyin", produces = {"application/json;charset=utf-8"})
@Api(value = "/yueyin", description="约影")
public class YueController {
	String[] ignorekey = {"maoyanjson"};
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取当地所有约影信息")
    @ResponseBody
    public Map<String, Object> allYueyin() {
		Map<String, Object> map = new HashMap<String, Object>();  
		Yueyin yueyin = new Yueyin();
    	List<Yueyin> listOrders = new LinkedList<Yueyin>();
    	listOrders.add(yueyin);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;  
    }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取用户所有约影信息")
    @ResponseBody
    public Map<String, Object> userYueyins() {
		Map<String, Object> map = new HashMap<String, Object>();  
		Yueyin yueyin = new Yueyin();
    	List<Yueyin> listOrders = new LinkedList<Yueyin>();
    	listOrders.add(yueyin);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;  
    }
	
	@RequestMapping(value = "/{yueyin_id}", method = RequestMethod.GET)
    @ApiOperation(notes = "/{yueyin_id}", httpMethod = "GET", value = "获取订单详细信息")
    @ResponseBody
    public Map<String, Object> detailYueyin(@ApiParam(required = true, value = "用户名")  @PathVariable("yueyin_id") Integer yueyin_id) {
		Map<String, Object> map = new HashMap<String, Object>();  
		Yueyin yueyin = new Yueyin();
        map.put("msg", "");
        map.put("data", BeansUtils.transBean2Map(yueyin));  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(notes = "/", httpMethod = "POST", value = "发出约影，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，yueyin_id，访问时记得在URL最后加上\\，http://localhost:8080/api/yueyin/")
    @ResponseBody
    public Map<String, String> makeYueyin(
    		@ApiParam(required = true, value = "发出约影信息的订单id") Integer order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("yueyin_id", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{yueyin_id}", method = RequestMethod.DELETE)
    @ApiOperation(notes = "/{yueyin_id}", httpMethod = "DELETE", value = "取消约影，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，yueyin_id")
    @ResponseBody
    public Map<String, String> deleteYueyin(@ApiParam(required = true, value = "约影单的id") @PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{yueyin_id}/enter", method = RequestMethod.POST)
    @ApiOperation(notes = "/{yueyin_id}/enter", httpMethod = "POST", value = "用户加入其他人发起的约影，返回结果为json，status：1代表成功，0代表失败，msg为错误信息，yueyin_id")
    @ResponseBody
    public Map<String, String> enterYueyin(
    		@ApiParam(required = true, value = "约影订单的id") @PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{yueyin_id}/enter", method = RequestMethod.DELETE)
    @ApiOperation(notes = "/{yueyin_id}/enter", httpMethod = "DELETE", value = "退出其他人发起的约影，返回结果为json，status：1代表成功，0代表失败，msg为错误信息，yueyin_id")
    @ResponseBody
    public Map<String, String> leaveYueyin(
    		@ApiParam(required = true, value = "约影订单的id") @PathVariable("yueyin_id") Integer yueyin_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
