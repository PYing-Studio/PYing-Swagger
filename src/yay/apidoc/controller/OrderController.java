package yay.apidoc.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import yay.apidoc.model.BeansUtils;
import yay.apidoc.model.Order;

@RestController
@RequestMapping(value = "/order", produces = {"application/json;charset=utf-8"})
@Api(value = "/orders", description="提交电影票订单")
public class OrderController {
	private  List<Map<String, Object>> changeListType(List<Order> listOrders) {
		List<Map<String, Object>> ordersList = new LinkedList<Map<String, Object>>();
		for (Order order : listOrders) {
			Map<String, Object> map = BeansUtils.transBean2Map(order);
			ordersList.add(map);
		}
		return ordersList;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取用户所有电影订单信息")
    @ResponseBody
    public Map<String, Object> allOrders(@ApiParam(required = true, value = "用户名") String username) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	Order order = new Order();
    	List<Order> listOrders = new LinkedList<Order>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", changeListType(listOrders));  
        map.put("status", "0");  
        return map;  
    }
	
	@RequestMapping(value = "/{order_id}", method = RequestMethod.GET)
    @ApiOperation(notes = "/{order_id}", httpMethod = "GET", value = "获取订单详细信息")
    @ResponseBody
    public Map<String, Object> detailOrder(@ApiParam(required = true, value = "订单id") @PathVariable("order_id") Integer order_id) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	Order order = new Order();
        map.put("msg", "");
        map.put("data", BeansUtils.transBean2Map(order));  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(notes = "/", httpMethod = "POST", value = "提交订单，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> makeOrder(@ApiParam(required = true, value = "username") String username,
    		@ApiParam(required = true, value = "电影院的id") Integer cinemaId,
    		@ApiParam(required = true, value = "该电影的id") Integer movieId,
    		@ApiParam(required = true, value = "该订单选了多少个座位，也就是买了多少票") Integer seatNum,
    		@ApiParam(required = true, value = "该电影的在该影院的播放时间，yyyy-MM-dd HH:mm:ss") String showTime,
    		@ApiParam(required = true, value = "该电影的在该影院的选位信息，目前可以留空") String seat) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "/{order_id}", method = RequestMethod.DELETE)
    @ApiOperation(notes = "/{order_id}", httpMethod = "DELETE", value = "取消订单，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> deleteOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("order_id") Integer order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
    
    @RequestMapping(value = "pay/{order_id}", method = RequestMethod.POST)
    @ApiOperation(notes = "pay/{order_id}", httpMethod = "POST", value = "对订单付款，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> payOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("order_id") Integer order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
