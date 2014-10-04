package com.codecity.web.modules.auth.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Zsolt Lengyel (zsolt.lengyel.it@gmail.com)
 */
public class LoginForm {

    @NotNull
    @Size(min = 2, max = 10, message = "Username kötelező")
    private String username;

    @NotNull
    @Size(min = 2, max = 10, message = "Pass req")
    private String password;

    private boolean rememberMe = true;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return the rememberMe
     */
    public boolean isRememberMe() {
        return rememberMe;
    }

    /**
     * @param rememberMe
     *            the rememberMe to set
     */
    public void setRememberMe(final boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

}
