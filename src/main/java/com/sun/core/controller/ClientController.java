package com.sun.core.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.core.base4static.MainClient;


@RestController
public class ClientController {
	@RequestMapping("/c4tstatic")
	public void client4Static() {
		System.out.println("in..........");
		
		MainClient client = new MainClient();
		String path = client.getPath();
		
		System.out.println(path);
		
	}
}
