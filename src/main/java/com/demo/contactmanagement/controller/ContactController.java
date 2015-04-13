package com.demo.contactmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.contactmanagement.common.ContactHelper;
import com.demo.contactmanagement.persisted.Contact;

@Controller
public class ContactController extends BaseController {
	@RequestMapping(value = "getEmployees", method = RequestMethod.POST)
	public ModelAndView getEmployees(@RequestBody Contact employee) {
		ModelAndView mav = new ModelAndView("employees");
		// mav.addObject("employees", ContactHelper.searchEmployees(employee));
		return mav;
	}

	@RequestMapping(value = "goEmployeeMain", method = RequestMethod.GET)
	public String goEmployeeMain() {
		return "employeeMain";
	}

	@RequestMapping(value = "getEmployeeById", method = RequestMethod.GET)
	public ModelAndView getEmployeeById(Integer id) {
		ModelAndView mav = new ModelAndView("employee");
		Contact employee = new Contact(id);
		mav.addObject("emp", ContactHelper.getPersistantObject(employee));
		return mav;
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
	public @ResponseBody String updateEmployee(@RequestBody Contact contact) {
		// Validate data
		// Save
		if (ContactHelper.saveOrUpdate(contact) > 0) {
			return "Update employee succesful!";
		}
		return "Update employee failed!";
	}

	@RequestMapping(value = "deleteEmployee", method = RequestMethod.POST)
	public @ResponseBody String deleteEmployee(Integer id) {
		Contact employee = new Contact(id);
		ContactHelper.delete(employee);
		return "Delete employee succesful!";
	}
}
