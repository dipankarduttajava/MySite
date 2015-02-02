package com.tekdtel.controller;

import java.io.Serializable;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController implements Serializable{
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
}
