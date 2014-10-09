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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

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
		Form<LoginForm> form = Form.from(LoginForm.class);

		if (request.isPostMethod()) {
			form = form.bindFromRequest();

			if (!form.hasErrors()) {

				final LoginForm loginForm = form.get();
				final UsernamePasswordToken token = loginForm.asToken();
				if (authentiacte(token)) {

					return redirect(IndexController.class); // login is successful
				}
			}
		}

		return view("modules/auth/index/index").set("form", form).set(viewModel);
	}

	/**
	 * Tries authenticate with token.
	 *
	 * @param token
	 * @return
	 */
	private boolean authentiacte(final UsernamePasswordToken token) {

		//1.
		final Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

		//2.
		final org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();

		//3.
		SecurityUtils.setSecurityManager(securityManager);

		final Subject currentUser = SecurityUtils.getSubject();

		try {
			currentUser.login(token);

			return true;
		} catch (final UnknownAccountException uae) {
			System.out.println(uae);
		} catch (final IncorrectCredentialsException ice) {
			System.out.println(ice);
		} catch (final LockedAccountException lae) {
			System.out.println(lae);
		} catch (final ExcessiveAttemptsException eae) {
			System.out.println(eae);
		} catch (final AuthenticationException ae) {
			System.out.println(ae);
		}
		return false;
	}
}
