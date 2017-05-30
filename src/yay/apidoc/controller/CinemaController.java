package yay.apidoc.controller;


import io.swagger.annotations.*;

import org.springframework.web.bind.annotation.*;

import yay.apidoc.model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/cinema", produces = {"application/json;charset=utf-8"})
@Api(value = "/cinema", description="获取电影院信息，使用猫眼的api进行开发，这里就做个样子")
public class CinemaController {
    @RequestMapping(value = "getCinemas", method = RequestMethod.GET)
    @ApiOperation(notes = "getCinemas", httpMethod = "GET", value = "获取当地所有电影院信息")
    @ResponseBody
    public Map<String, String> getCinemas(@ApiParam(required = true, value = "城市名，中文拼音") String city_name) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }

    @RequestMapping(value = "detail", method = RequestMethod.GET)
    @ApiOperation(notes = "detail", httpMethod = "GET", value = "查询出电影院详情，如果movieid为空，可以看到该影院所有的演出电影，如果id非空，就可得到对应的电影信息")
    @ResponseBody
    public Map<String, String> getMovieDetail(@ApiParam(required = true, value = "电影院的id") Integer cinemaid,
    		@ApiParam(required = true, value = "该电影院下的电影id") Integer movieid) {
    	Map<String, String> map = new HashMap<String, String>();  
        map.put("control", "{\"expires\": 1800}");
        map.put("data", "...");  
        map.put("status", "0");  
        return map;  
    }
}

