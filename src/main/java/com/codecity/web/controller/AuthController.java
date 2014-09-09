package com.codecity.web.controller;

import io.pallas.core.annotations.Controller;

import javax.inject.Inject;

import org.brickred.socialauth.cdi.SocialAuth;

@Controller("auth")
public class AuthController {

    @Inject
    private SocialAuth auth;

    public void login() {
        auth.setId("google");
        try {
            auth.login();
        } catch (final Exception e) {

            e.printStackTrace();
        }
    }

    public void logout() {
        auth.logout();
    }
}
