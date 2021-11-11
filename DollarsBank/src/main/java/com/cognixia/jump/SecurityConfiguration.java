package com.cognixia.jump;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cognixia.jump.service.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	http.
    	csrf().disable()
    	.authorizeRequests()
    	.antMatchers("/").permitAll()
    	.anyRequest().authenticated()
    	.and()
    	.formLogin()
    	.and().logout().invalidateHttpSession(true).clearAuthentication(true)
    	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
    	.logoutSuccessUrl("/login").permitAll();
    	;
    	
    	
    	//other kind of working 
//    	http.
//    	csrf().disable()
//    	.authorizeRequests()
//    	.antMatchers("/").permitAll()
//    	.anyRequest().authenticated()
//    	.and()
//    	.formLogin();
    	
    	
    	
    	// SEMI WORKING ----------- working FIRST
//        http.authorizeRequests()
//        		.antMatchers("/").permitAll()
//
//                .antMatchers("/customer").hasRole("USER")
//                
//                .and().csrf().disable().formLogin();
//        --------------

    }
    
    
//	http.authorizeRequests()
//	
//    .antMatchers("/customer").hasRole("USER")
//    
//    .and().csrf().disable().formLogin();

    
//	http.authorizeRequests()
//	
//    .antMatchers("/customer").hasRole("USER")
//    .antMatchers("/login").permitAll()
//    .and().csrf().disable().httpBasic();

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
    	DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    	
    	provider.setUserDetailsService(userDetailsService);
    	
    	provider.setPasswordEncoder(getPasswordEncoder());
    	
    	
		return provider;
    	
    }
    	
    
}