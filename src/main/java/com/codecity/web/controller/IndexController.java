package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;
import io.pallas.core.controller.BaseController;
import io.pallas.core.view.Model;
import io.pallas.core.view.View;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController extends BaseController {

    public View index() {
        return view();
    }

    public View login() {

        final HttpServletRequest request = request();

        request.getRequestURI();

        final Model model = model().set("user", request.getParameter("user"));

        return view(model);
    }

}
