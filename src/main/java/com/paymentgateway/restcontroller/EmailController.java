package com.paymentgateway.restcontroller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.paymentgateway.model.User;
import com.paymentgateway.service.TestService;

@RestController
public class EmailController {
	@Autowired
	TestService testService;

	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;

	}
	@RequestMapping(value ="/sendEmail", method = RequestMethod.POST)
	public ResponseEntity<User> sendEmail(@RequestBody User user,UriComponentsBuilder ucBuilder) throws IOException {
        SendEmailMethods.sendCustomEmail(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
	}
}
