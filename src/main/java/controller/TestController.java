package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import redisdao.UserDao;

@Controller
public class TestController {
	@Autowired
	private UserDao userDao;
	@RequestMapping("/test")
	public String test(){
		userDao.test();
		return "index";
	}
}
