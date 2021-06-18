package de.itech.kochbuchmanager.config;

import de.itech.kochbuchmanager.model.User;
import de.itech.kochbuchmanager.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Configuration
@Transactional
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        User user = userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user == null) {
            httpServletResponse.sendRedirect("/anmeldung?error");
        } else {
           // Set<String> roles = AuthorityUtils.authorityListToSet(user.getAuthorities());
           /* if (roles.contains("ROLE_USER")) {
                httpServletResponse.sendRedirect("/uebersicht");
            } else if (roles.contains("ROLE_ADMIN")) {
                httpServletResponse.sendRedirect("/control");
            }*/
            httpServletResponse.sendRedirect("/startseite");
        }
    }
}

