package com.codecity.web.modules.auth.controllers;

import io.pallas.core.annotations.Controller;

@Controller("auth")
public class AuthController {

	public String index(){
		return "auth mod index";
	}

}
