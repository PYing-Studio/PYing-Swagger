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

import yay.apidoc.model.HotMovie;
import yay.apidoc.utils.BeansUtils;
import yay.apidoc.utils.JsonUtils;

@RestController
@RequestMapping(value = "/movie", produces = {"application/json;charset=utf-8"})
@Api(value = "/movie", description="获取电影信息，数据来自猫眼api")
public class MovieController {
	String[] ignorekey = {"insertTime", "statue", "maoyanjson"};
	
    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    @ApiOperation(notes = "hotMovies", httpMethod = "GET", value = "获取首页热门电影，返回数据中data跟猫眼数据一样，访问时记得在URL最后加上\\，例如http://localhost:8080/api/movie/")
    @ResponseBody
    public Map<String, Object> getHotMovie(
    		@ApiParam(required = true, value = "数据开始位置") Integer offset,
    		@ApiParam(required = true, value = "偏移量") Integer limit ) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	HotMovie order = new HotMovie();
    	List<HotMovie> listOrders = new LinkedList<HotMovie>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;  
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ApiOperation(notes = "/search", httpMethod = "GET", value = "搜索电影，keyWord会搜索数据库中的电影名，导演，演员，简介")
    @ResponseBody
    public Map<String, Object> searchMovie(
    		@ApiParam(required = true, value = "搜索关键词") String keyWord ) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	HotMovie order = new HotMovie();
    	List<HotMovie> listOrders = new LinkedList<HotMovie>();
    	listOrders.add(order);
    	map.put("msg", "");
        map.put("data", JsonUtils.changeListToMap(listOrders, ignorekey));  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(notes = "/{id}", httpMethod = "GET", value = "获取首页热门电影，返回数据跟猫眼API相同")
    @ResponseBody
    public Map<String, Object> getMovieDetail(
    		@ApiParam(required = true, value = "电影的id") @PathVariable("id") String id) {
    	Map<String, Object> map = new HashMap<String, Object>();  
    	HotMovie order = new HotMovie();
        map.put("msg", "");
        map.put("data", BeansUtils.transBean2Map(order));  
        map.put("status", "0");  
        return map;  
    }
}

