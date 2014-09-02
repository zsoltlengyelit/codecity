package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;

import com.codecity.web.core.BaseController;

@Controller
public class IndexController extends BaseController {

    public String index() {
        return render("index/index");
    }

}
