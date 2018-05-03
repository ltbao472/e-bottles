package com.lt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.services.UsersService;

@RestController
@RequestMapping("/api")
public class Api {
	@Autowired
	private UsersService service;
	@RequestMapping(value="/greeting", method = RequestMethod.GET)
	public ResponseEntity<String> greeting(){
		return new ResponseEntity<String>("Wellcome", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getuser", method = RequestMethod.GET)
	public ResponseEntity<String> getUser(){
		return new ResponseEntity<String>(service.findById(1).getName(), HttpStatus.OK);
	}
	
	@RequestMapping(value =  "/md5", method = RequestMethod.POST)
	public ResponseEntity<String> md5(@RequestBody String data){
		String md5Text = "";
		if(!"".equalsIgnoreCase(data)){
			md5Text = DigestUtils.md5DigestAsHex(data.trim().getBytes());
		}
		return new ResponseEntity<String>(md5Text, HttpStatus.OK);
	}
}
