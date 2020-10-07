package com.example.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Address;
import com.example.entity.Email;
import com.example.entity.User;
import com.example.repository.AddressRepository;
import com.example.repository.EmailRepository;
import com.example.repository.UserRepository;

@Controller
public class BaseController {
	@Autowired
	EmailRepository emailRepository;
	@Autowired
	AddressRepository addressRepository;
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value =  "/",  method = RequestMethod.GET )
	public String welcome(Model model) {
	    String message = "Hello Spring Boot + JSP";
        model.addAttribute("message", message);
		return "index";
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		Email email = new Email("abc@.gmail.com");	
		emailRepository.save(email);
		return "success";

	}
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
	Address address = new Address("TP.HCM");
	Set<User> users = new HashSet<>();
	users.add(new User(new Email("a@gmail.com")));
	users.add(new User(new Email("b@gmail.com")));
	address.setUsers(users);
	addressRepository.save(address);
		return "success";

	}
	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public String test2() {
		User user = new User(new Email("sa@gmail.com"));
		Set<Address> address = new HashSet<>();
		address.add(new Address("DN"));
		address.add(new Address("HN"));
		user.setAddress(address);
		userRepository.save(user);
		return "success";
		
	}
	@RequestMapping(value = "/test3", method = RequestMethod.GET)
	public String test3() {
	emailRepository.findAll();
		return "success";
		
	}
}
