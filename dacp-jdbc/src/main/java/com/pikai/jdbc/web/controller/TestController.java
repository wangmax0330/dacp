package com.pikai.jdbc.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pikai.jdbc.domain.User;
import com.pikai.web.entity.Coffee;
import com.pikai.web.entity.EmployeeServiceResponse;
import com.pikai.web.entity.XmlResponseResult;

@Controller
public class TestController {
	private static final Logger logger = Logger.getLogger(TestController.class);

	@RequestMapping(value = "/testXmlResponse", method = RequestMethod.GET)
	public @ResponseBody XmlResponseResult getXmlResponseResult(HttpServletRequest request, HttpServletResponse response) {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < 3; i++) {
			User user = new User();
			user.setPassword("--------------" + i);
			user.setUsername("用户" + i);
			list.add(user);
		}
		XmlResponseResult result = new XmlResponseResult(false, "200", "成功", "11");
		return result;
	}

	@RequestMapping(value = "/coffee", method = RequestMethod.GET)
	public @ResponseBody Coffee getCoffeeInXML(HttpServletRequest request, HttpServletResponse response) {
		Coffee coffee = new Coffee("wang", 100);
		return coffee;
	}

	@RequestMapping(value = "/testXml", method = RequestMethod.GET)
	public ModelAndView testXml(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setPassword("--------------");
		user.setUsername("用户");
		XmlResponseResult result = new XmlResponseResult(false, "200", "成功", "11");
		modelAndView.setViewName("xml");
		modelAndView.addObject(result);
		modelAndView.addObject("xml", "11");
		return modelAndView;
	}

	@RequestMapping(value = "/testjson", method = RequestMethod.GET)
	public ModelAndView testjson(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setPassword("--------------");
		user.setUsername("用户");
		XmlResponseResult result = new XmlResponseResult(false, "200", "成功", "11");
		modelAndView.setViewName("json");
		modelAndView.addObject(user);
		modelAndView.addObject("json", "11");
		return modelAndView;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public EmployeeServiceResponse createEmployee() {
		logger.info("creating a employee:[{}]");
		return new EmployeeServiceResponse(0, "");
	}

	@RequestMapping(value = "/xml", method = RequestMethod.GET)
	@ResponseBody
	public String xml() {
		String str = "<listBean><account><address>address#0</address><brithday><brithday>2010-11-20</brithday>"
				+ "</brithday><email>email0@120.com</email><id>1</id><name>haha#0</name></account><user>"
				+ "<address>china GuangZhou# 0</address><age>23</age><brithday>2011-04-27T17:02:38.028+08:00</brithday>"
				+ "<name>jack#0</name><sex>false</sex></user><account><address>address#1</address><brithday><brithday>2010-11-21</brithday>"
				+ "</brithday>"
				+ "<email>email1@121.com</email><id>2</id><name>haha#1</name></account>'+'<user><address>china GuangZhou# 1</address><age>24</age>'+'<brithday>2011-04-27T17:02:38.028+08:00</brithday><name>jack#1</name><sex>false</sex></user>'+'<account><address>address#2</address><brithday><brithday>2010-11-22</brithday></brithday>'+'<email>email2@122.com</email><id>3</id><name>haha#2</name></account>'+'<user><address>china GuangZhou# 2</address><age>25</age>'+'<brithday>2011-04-27T17:02:38.028+08:00</brithday><name>jack#2</name><sex>false</sex></user>'+'</listBean>";
		return str;
	}
}
