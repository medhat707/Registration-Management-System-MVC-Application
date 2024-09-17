package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.entity.Members;
import com.luv2code.springboot.thymeleafdemo.entity.Roles;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import com.luv2code.springboot.thymeleafdemo.service.MembersService;

import jakarta.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	private MembersService membersService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService 
			, MembersService theMembersService) {
		employeeService = theEmployeeService;
		membersService = theMembersService;
	}

	// add mapping for "/list"
	
	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		//get all employees from database
		// findAll() returns all employees -> storing result in a list
		List<Employee> theEmployees = employeeService.findAll();
	
		// add the list to the model 
		theModel.addAttribute("employees", theEmployees);

		return "employees/list-employees";
	}
	
	//MAIN - REGISTRATION FORM
	@GetMapping("/showForm")
	public String showTheForm(Model theModel) {
		
		// create an employee entity object
		Employee employee = new Employee();
		
		//create object from member
		Members member = new Members();
		
		//add the Employee to the Model
		theModel.addAttribute("employee" , employee);
		//add the Member to the Model
		theModel.addAttribute("member" , member);
		
		return "employees/employee-from";
	}
	


	//taking the data sent from the registration form and putting it into Model
	@PostMapping("/save")
	public String saveEmployee(Model model, @ModelAttribute("employee") Employee employee
			, @ModelAttribute("member") Members member) {
		
		// saving theEmployee
		employeeService.save(employee);
		
		//saving role //create role
		Roles role = new Roles("ROLE_EMPLOYEE");
		//associate objects together using the one to one relashionship
		member.add(role);
		

		//saving member
		membersService.save(member);
		
	//Go the the controller with the name TheSystems
		//debug
		System.out.println("print the employee " + employee);
		//redirect to the home page
		return "redirect:/TheSystems";
	//	return "redirect:/hello";
//	    return "/systems";
//	    return "redirect:/employees/list";

	}
	
	//1. FOR Employee
	//NOW i wanna get the employee with the selected id particularly
	//FOR that we take only the id sent after clicking the update button
	//<a th:href="@{/employees/showFormForUpdate(employeeId=${tempEmployee.id})}"
	//this method takes the data/id from the link via @RequestParam
	// then find the employee by it, put it into Model
	
	//2. FOR Member -> create new member , put it in Model, send it over to view
	
	@GetMapping("/showFormForUpdate")
	public String showTheNewForm(@RequestParam("employeeId") int id , Model theModel
	// 
			) {
		// find the employee - get from service
		Employee theEmp = employeeService.findById(id);
		//put it in the model and sent it over to the form
		
		Members theMember = new Members();

		theModel.addAttribute("employee" , theEmp);
		theModel.addAttribute("theMember" , theMember);

		return "employees/employee-from2";

	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the employee
		employeeService.deleteById(theId);
		
		//redirect to the employees/list
	    return "redirect:/employees/list";

	}


}









