package de.itech.kochbuchmanager.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    public SecurityConfig(AuthSuccessHandler authenticationSuccessHandler,
                          AuthFailureHandler authenticationFailureHandler) {
        this.authSuccessHandler = authenticationSuccessHandler;
        this.authFailureHandler = authenticationFailureHandler;
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        //  security.httpBasic().disable().formLogin().disable(); //disable spring security und auto login screen

        security.authorizeRequests()
                .antMatchers("/", "/anmeldung", "/js/**", "/css/**", "/image/**").permitAll()
                //   .antMatchers("/bestellen", "/bestellung", "/bestellungStornieren", "/uebersicht").hasRole("USER")
                //   .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/anmeldung").successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler).permitAll().usernameParameter("username")
                .passwordParameter("passwordlogin").and().logout().logoutSuccessUrl("/").permitAll();
        security.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password, FROM manager.users WHERE lower(username) = lower(?)")
                .authoritiesByUsernameQuery("SELECT username, 'ROLE_' || role FROM manager.users WHERE lower(username) = lower(?)")
                .dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}