package yay.apidoc.controller;


import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import yay.apidoc.model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/movie", produces = {"application/json;charset=utf-8"})
@Api(value = "/movie", description="获取电影信息，使用猫眼的api进行开发，这里就做个样子")
public class MovieController {
    @RequestMapping(value = "hotMovies", method = RequestMethod.GET)
    @ApiOperation(notes = "hotMovies", httpMethod = "GET", value = "获取首页热门电影，返回数据跟猫眼API相同")
    @ResponseBody
    public Map<String, String> getHotMovie(@ApiParam(required = true, value = "数据开始位置") Integer offset,
    		@ApiParam(required = true, value = "偏移量") Integer limit ) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "detail/{id}", method = RequestMethod.GET)
    @ApiOperation(notes = "detail/{id}", httpMethod = "GET", value = "获取首页热门电影，返回数据跟猫眼API相同")
    @ResponseBody
    public Map<String, String> getMovieDetail(@ApiParam(required = true, value = "电影的id") @PathVariable("id") String id) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
}

