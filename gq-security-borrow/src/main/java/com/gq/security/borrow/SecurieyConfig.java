package com.gq.security.borrow;

import com.gq.security.core.validate.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gq.security.borrow.authentication.MyAuthencatitionFailureHandler;
import com.gq.security.borrow.authentication.MyAuthenticationSuccessHandler;
import com.gq.security.core.properties.SecurityProperties;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurieyConfig extends WebSecurityConfigurerAdapter	{

	@Autowired private SecurityProperties securityProperties;
	@Autowired private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	@Autowired private MyAuthencatitionFailureHandler myAuthencatitionFailureHandler;
	
	//密码加密配置
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
 		ValidateCodeFilter filter = new ValidateCodeFilter();
 		filter.setAuthenticationFailureHandler(myAuthencatitionFailureHandler);

		http
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
		.formLogin()
 		.loginPage("/authentication/require")
 		.loginProcessingUrl("/authentication/form")
 		.successHandler(myAuthenticationSuccessHandler)
 		.failureHandler(myAuthencatitionFailureHandler)
		.and()
		.authorizeRequests()
		.antMatchers("/authentication/require",
				securityProperties.getBorrow().getLoginPage(),
				"/image/code").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable();
	}
	
}
