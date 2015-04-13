package com.demo.contactmanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.contactmanagement.common.Constant;
import com.demo.contactmanagement.common.UserHelper;
import com.demo.contactmanagement.persisted.User;

@Controller
public class UserController extends BaseController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String rootPath() {
		return "index";
	}

	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(User user, HttpServletRequest request) {
		user = UserHelper.doLogin(user);
		if (user != null) {
			request.getSession().setAttribute(Constant.ADMIN_SESSION, user);
			return "redirect:contactMain";
		}
		return "index";
	}

	@RequestMapping(value = "doLogout", method = RequestMethod.GET)
	public String doLogout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constant.ADMIN_SESSION);
		return "index";
	}
}
