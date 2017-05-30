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
@RequestMapping(value = "/order", produces = {"application/json;charset=utf-8"})
@Api(value = "/orders", description="提交电影票订单")
public class OrderController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取用户所有电影订单信息")
    @ResponseBody
    public Map<String, String> allOrders(@ApiParam(required = true, value = "用户名") String username) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
	
	@RequestMapping(value = "/{Order_id}", method = RequestMethod.GET)
    @ApiOperation(notes = "/{Order_id}", httpMethod = "GET", value = "获取订单详细信息")
    @ResponseBody
    public Map<String, String> detailOrder(@ApiParam(required = true, value = "订单id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(notes = "/", httpMethod = "POST", value = "提交订单，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> makeOrder(@ApiParam(required = true, value = "username") String username,
    		@ApiParam(required = true, value = "电影院的id") String cinemaid,
    		@ApiParam(required = true, value = "该电影院下的电影id") String movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{Order_id}", method = RequestMethod.DELETE)
    @ApiOperation(notes = "/{Order_id}", httpMethod = "DELETE", value = "取消订单，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> deleteOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "statue/{Order_id}", method = RequestMethod.POST)
    @ApiOperation(notes = "statue/{Order_id}", httpMethod = "POST", value = "查看订单状态，是否超过支付时间，是否完成支付，返回结果为json，status：1代表支付成功，0代表超过支付时间，2等待支付，3订单已经取消，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> statueOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "pay/{Order_id}", method = RequestMethod.POST)
    @ApiOperation(notes = "pay/{Order_id}", httpMethod = "POST", value = "对订单付款，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> payOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("Order_id") Integer Order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
