package br.iesp.edu.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/*/admin/**").hasRole("ADMIN")
                .antMatchers("/*/user/**").hasAnyRole("USER","ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();

    }
   
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/*/guest/**");
    }

    @Autowired
    public void configureGlobasl(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("igor").password(encoder.encode("123")).roles("USER")
                .and()
                .withUser("fuji").password(encoder.encode("321")).roles("USER", "ADMIN");

    }
}
