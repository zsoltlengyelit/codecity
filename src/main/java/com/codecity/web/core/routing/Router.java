package com.codecity.web.core.routing;

import io.pallas.core.url.routing.RoutingProvider;

import javax.enterprise.inject.Specializes;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.config.Direction;
import org.ocpsoft.rewrite.servlet.config.Path;
import org.ocpsoft.rewrite.servlet.config.Redirect;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@Specializes
@RewriteConfiguration
// TODO make it real CDI bean
public class Router extends RoutingProvider {

    @Override
    public Configuration getConfiguration(final ServletContext context) {

        final String contextPath = context.getContextPath();

        // TODO
        // final List<?> routes = appConfig.getValue("routes");

        final ConfigurationBuilder configuration = ConfigurationBuilder.begin();

        configuration.addRule(Join.path("/home").to("/index/index"));
        configuration.addRule(Join.path("/signin").to("/index/login?user=Anonymus"));
        configuration.addRule(Join.path("/signin/{user}").to("/index/login?user={user}"));

        configuration.addRule().when(Direction.isInbound().and(Path.matches("/{any}"))).perform(Redirect.temporary(contextPath + "/home?page={any}"));

        return configuration;
    }

}
