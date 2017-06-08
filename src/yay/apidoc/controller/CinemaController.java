package yay.apidoc.controller;


import io.swagger.annotations.*;

import org.springframework.web.bind.annotation.*;

import yay.apidoc.model.Cinema;
import yay.apidoc.model.HotMovie;
import yay.apidoc.model.IntheaterMovie;
import yay.apidoc.model.User;
import yay.apidoc.utils.JsonUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cinema", produces = {"application/json;charset=utf-8"})
@Api(value = "/cinema", description="获取电影院信息，数据来自猫眼api")
public class CinemaController {
	private String[] ignorekey = {"insertTime", "statue", "maoyanjson"};
	
	
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ApiOperation(notes = "getCinemas", httpMethod = "GET", value = "获取当地所有电影院信息，当area为空时，会返回整个城市的影院数据")
    @ResponseBody
    public Map<String, Object> getCinemas(@ApiParam(required = true, value = "中文城市名") String city,
    		@ApiParam(required = true, value = "城市的区名") String area) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	Cinema order = new Cinema();
    	List<Cinema> listOrders = new LinkedList<Cinema>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "inTheater", method = RequestMethod.GET)
    @ApiOperation(notes = "inTheater", httpMethod = "GET", value = "查询出电影院详情，如果movieid为空，可以看到该影院所有的演出电影，如果cinema_id为空，可以获取该movie_id电影在所有影院的上映信息，但是两者不能同时为空")
    @ResponseBody
    public Map<String, Object> getMovieDetail(@ApiParam(required = true, value = "电影院的id") Integer cinema_id,
    		@ApiParam(required = true, value = "该电影院下的电影id") Integer movie_id) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	IntheaterMovie order = new IntheaterMovie();
    	List<IntheaterMovie> listOrders = new LinkedList<IntheaterMovie>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;   
    }
}

