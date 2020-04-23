
package org.cartwheel.selenium;

import org.cartwheel.selenium.properties.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	ServiceProperties properties;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("user name :"+properties.getUsername());
		System.out.println("pwd :"+properties.getPassword());
		auth.inMemoryAuthentication().withUser("admin").password(passwordencoder().encode("admin")).authorities("ROLE_USER");
	}

	protected void configure(HttpSecurity http) throws Exception { 
		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic();

		http.sessionManagement().sessionFixation().migrateSession();
	}

	@Bean
	public SessionRegistry sessionRegistry() {
		return new SessionRegistryImpl();

	}

	@Bean
	public HttpSessionEventPublisher httpsessioneventpublisher() {
		return new HttpSessionEventPublisher();
	}

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}

}
