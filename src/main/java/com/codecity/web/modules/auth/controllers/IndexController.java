package com.codecity.web.modules.auth.controllers;

import io.pallas.core.annotations.Controller;
import io.pallas.core.controller.BaseController;
import io.pallas.core.view.Template;
import io.pallas.core.view.View;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.codecity.web.modules.auth.AuthModule;

@Controller
public class IndexController extends BaseController {

	@Inject
	private Template template;

	@Inject
	private AuthModule module;

	@PostConstruct
	private void init() {
		template.setPath("layout/login");
	}

	/**
	 * @return view
	 */
	public View index() {

		return view("modules/auth/index/index")
				.set("basicAuth", module.getBasic());
	}

}
