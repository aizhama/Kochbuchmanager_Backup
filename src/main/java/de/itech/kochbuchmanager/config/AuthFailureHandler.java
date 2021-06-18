package de.itech.kochbuchmanager.config;

import de.itech.kochbuchmanager.model.User;
import de.itech.kochbuchmanager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
public class AuthFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException e)
            throws IOException {

        User user = userRepo.findByUsername(req.getParameter("username"));

        if (user != null) {
            resp.sendRedirect("/anmeldung?error");
        }
    }
}
