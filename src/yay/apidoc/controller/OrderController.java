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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yay.apidoc.model.Order;
import yay.apidoc.utils.BeansUtils;
import yay.apidoc.utils.JsonUtils;

@RestController
@RequestMapping(value = "/order", produces = {"application/json;charset=utf-8"})
@Api(value = "/orders", description="提交电影票订单")
public class OrderController {
	String[] ignorekey = {"maoyanjson"};
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(notes = "/", httpMethod = "GET", value = "获取用户所有电影订单信息，访问时记得在URL最后加上\\，例如http://localhost:8080/api/order/?username=lin")
    @ResponseBody
    public Map<String, Object> allOrders() {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	Order order = new Order();
    	List<Order> listOrders = new LinkedList<Order>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
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
    @ApiOperation(notes = "/", httpMethod = "POST", value = "提交订单，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId，访问时记得在URL最后加上\\，例如http://localhost:8080/api/order/")
    @ResponseBody
    public Map<String, String> makeOrder(
    		@ApiParam(required = true, value = "放映电影场次的id") Integer showTimeId,
    		@ApiParam(required = true, value = "影院名称") String cinemaName,
    		@ApiParam(required = true, value = "电影名称") String movieName,
    		@ApiParam(required = true, value = "该订单选了多少个座位，也就是买了多少票") Integer seatNum,
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
    
    @RequestMapping(value = "/{order_id}/pay", method = RequestMethod.PUT)
    @ApiOperation(notes = "/{order_id}/pay", httpMethod = "POST", value = "put方法 对订单付款，返回结果为json，status：1代表成功，0代表错误，msg为错误信息，orderId")
    @ResponseBody
    public Map<String, String> payOrder(@ApiParam(required = true, value = "订单的id") @PathVariable("order_id") Integer order_id) {
    	Map<String, String> map = new HashMap<String, String>();  
    	map.put("status", "1");
        map.put("msg", "successful");  
        map.put("orderId", "0"); 
        return map;  
    }
}
