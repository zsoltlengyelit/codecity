package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.codecity.web.core.BaseController;

@Controller
public class IndexController extends BaseController {

    public String index() {
        return render("index/index");
    }

    public String login() {

        final HttpServletRequest request = request().getRequest();
        final Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.toString();

        final String requestURI = request.getRequestURI();
        final StringBuffer requestURL = request.getRequestURL();

        model().set("user", request.getParameter("user"));

        return render("index/login");
    }

}
