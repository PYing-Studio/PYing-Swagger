package yay.apidoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import yay.apidoc.model.User;

@RestController
@RequestMapping(value = "/user", produces = { "application/json;charset=utf-8" })
@Api(value = "/user", description = "用户登录注册")
public class UserController {
	@RequestMapping(value = "register", method = RequestMethod.POST)
	@ApiOperation(notes = "register", httpMethod = "POST", value = "注册新用户，返回结果为json，status：1代表成功，0代表错误，msg为错误信息")
	@ResponseBody
	public Map<String, String> register(
			@ApiParam(required = true, value = "用户名") String username,
			@ApiParam(required = true, value = "用户密码") String password,
			@ApiParam(required = true, value = "用户邮箱") String email,
			@ApiParam(required = true, value = "用户手机号码") String phone,
			@ApiParam(required = true, value = "用户昵称，可以为空") String nickname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "1");
		map.put("msg", "successful");
		return map;
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ApiOperation(notes = "login", httpMethod = "POST", value = "用户登录，返回结果为json，status：1代表成功，0代表错误，msg为错误信息 ")
	@ResponseBody
	public Map<String, String> login(
			@ApiParam(required = true, value = "username") String username,
			@ApiParam(required = true, value = "password") String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "0");
		map.put("msg", "error msg");
		return map;
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	@ApiOperation(notes = "logout", httpMethod = "POST", value = "用户退出登录，不需要传数据，返回结果为json，status：1代表成功，0代表错误，msg为错误信息 ")
	@ResponseBody
	public Map<String, String> logout() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", "1");
		map.put("msg", "");
		return map;

	}

	@RequestMapping(value = "collection", method = RequestMethod.GET)
	@ApiOperation(notes = "collection", httpMethod = "GET", value = "获取用户收藏")
	@ResponseBody
	public Map<String, String> myCollection(
			@ApiParam(required = true, value = "用户名") String username) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("control", "{\"expires\": 1800}");
		map.put("data", "...");
		map.put("status", "0");
		return map;
	}
}
