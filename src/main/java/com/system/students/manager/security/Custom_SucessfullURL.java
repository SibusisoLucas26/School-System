package com.system.students.manager.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;

import java.io.IOException;
import java.util.Collection;

public class Custom_SucessfullURL implements AuthenticationSuccessHandler {

    
    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request,
            jakarta.servlet.http.HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
                 // Retrieve the authorities granted to the user
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Determine the redirect URL based on the user's roles
        if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
            response.sendRedirect("/admin/dashboard"); // Redirect for ADMIN users
        } else if (authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_USER"))) {
            response.sendRedirect("/user/dashboard"); // Redirect for USER users
        } else {
            response.sendRedirect("/home"); // Default redirect if no specific role is found
        }
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'onAuthenticationSuccess'");
    }
}

