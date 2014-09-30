package com.codecity.web.modules.auth;

import io.pallas.core.annotations.Controller;
import io.pallas.core.annotations.DefaultAction;

/**
 *
 * @author lzsolt
 *
 */
@Controller
public class IndexController {

	// auth index

	@DefaultAction
	public String auth(){
		return "Auth module index";
	}

}
