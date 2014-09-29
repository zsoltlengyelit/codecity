package com.codecity.web;

import io.pallas.core.WebApplication;
import io.pallas.core.annotations.Startup;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.jboss.weld.bean.builtin.ee.ServletContextBean;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */

@Specializes
@Startup
public class Application extends WebApplication {

	@Inject
	private Logger logger;
	

	
	
    @PostConstruct
    private void init() {
    	
    	logger.info("Application started at: ");
    	
    }

    @Override
    public String getName() {

        return "codecity";
    }

}
