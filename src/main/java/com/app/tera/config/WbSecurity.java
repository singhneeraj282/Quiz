package com.app.tera.config;

import com.app.tera.security.service.MyUserDetailsService;
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
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class WbSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("**/login").permitAll()
                .antMatchers("**/user/registration/**").permitAll()
                .antMatchers("**/admin/**", "/swagger-ui.html").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().formLogin()
                /*.and()
                    .formLogin().loginPage("/loginPage")
                    .defaultSuccessUrl("/homePage")
                    .failureUrl("/loginPage?error")
                    .usernameParameter("username").passwordParameter("password")
                .and()
                    .logout().logoutSuccessUrl("/loginPage?logout");*/
                .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                .and().
                     csrf().disable();

    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler();
    }
}
