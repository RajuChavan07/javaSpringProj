package com.npci.springws2war.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestAPI {

	public ResponseEntity<Object> greet(){
		return ResponseEntity.status(200).body("Hello word");
	}

}
