package com.lt.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.model.Md5RequestModel;
import com.lt.model.Md5ResponseModel;
import com.lt.services.UsersService;

@RestController
@RequestMapping("/api")
public class Api {
	private static final Logger log = LoggerFactory.getLogger(Api.class);
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
	public ResponseEntity<?> md5(@RequestBody Md5RequestModel data){
		log.info("Request data: {}", data);
		String md5Text = "";
		if(!"".equalsIgnoreCase(data.getData())){
			md5Text = DigestUtils.md5DigestAsHex(data.getData().trim().getBytes());
		}
		Md5ResponseModel re = new Md5ResponseModel();
		re.setData(md5Text);
		log.info("Response data: {}", re);
		return ResponseEntity.ok(re);
	}
}
