package com.codecity.web.modules.auth.controllers;

import io.pallas.core.annotations.Controller;
import io.pallas.core.controller.BaseController;
import io.pallas.core.execution.Result;
import io.pallas.core.http.HttpRequest;
import io.pallas.core.view.Model;
import io.pallas.core.view.Template;
import io.pallas.core.view.form.Form;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.codecity.web.controller.IndexController;
import com.codecity.web.modules.auth.form.LoginForm;

@Controller
public class LoginController extends BaseController {

	@Inject
	private Template template;

	@Inject
	private HttpRequest request;

	@PostConstruct
	private void init() {
		template.setPath("layout/login");
	}

	/**
	 * @return view
	 */
	public Result index() {

		final Model viewModel = new Model();
		Form<LoginForm> form = Form.from(new LoginForm());

		if (request.isPostMethod()) {
			form = form.bindFromRequest();

			String welcomeMessage = form.get().getDetails().getWelcomeMessage();

			if (!form.hasErrors()) {
				return redirect(IndexController.class); // login is successful
			}
		}

		return view("modules/auth/index/index").set("form", form).set(viewModel);
	}
}
