package com.codecity.web;

import io.pallas.core.WebApplication;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Specializes;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */

@Specializes
public class Application extends WebApplication {

    @PostConstruct
    private void init() {

    }

    @Override
    public String getName() {

        return "codecity";
    }

}
