package com.codecity.web.core.routing;

import javax.enterprise.inject.Specializes;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@Specializes
// TODO make it real CDI bean
public class Router extends io.pallas.core.routing.Router {

    @Override
    public void setRules(final ConfigurationBuilder builder, final ServletContext context) {

        //builder.addRule(Join.path("/{action}").to("/index/{action}"));
        builder.addRule(Join.path("/home").to("/index/index"));
        builder.addRule(Join.path("/signin").to("/index/login?user=Anonymus"));
        builder.addRule(Join.path("/signin/{user}").to("/index/login?user={user}"));

        super.setRules(builder, context);

        //configuration.addRule().when(Direction.isInbound().and(Path.matches("/{any}"))).perform(Redirect.temporary(contextPath + "/home?page={any}"));

    }
}
