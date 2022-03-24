package org.sid.wedding.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	 @Autowired
	  private DataSource dataSource ;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		  PasswordEncoder passwordEncoder=passwordEncoder();
		  
		  auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.
		  encode("1234")).roles("USER");
		  auth.inMemoryAuthentication().withUser("nouha").password(passwordEncoder.
		  encode("1234")).roles("ADMIN");
		  
		  auth.jdbcAuthentication().dataSource(dataSource)
		  .usersByUsernameQuery("select email as principal,password as credentials,active from users where email=?")
		 .authoritiesByUsernameQuery("select email as principal,role as role,password from users where email=?")
		 .rolePrefix("ROLE_")
		.passwordEncoder(passwordEncoder);
		  
		 
		 
     }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.formLogin().loginPage("/login").defaultSuccessUrl("/profil", true)
;//indiquer ce qui va etre ecrit dans
	                                           
			    //le controleur pour diriger le use rvers la apge de login;
		  http.authorizeRequests().antMatchers("/services","/about","/index").permitAll();
		 http.authorizeRequests().antMatchers("/profilClient").hasRole("CLIENT");
		 //http.authorizeRequests().antMatchers("/profilClient").hasRole("ADMIN");
		 
		  //http.csrf();//la gestion des sessions                       
		  http.exceptionHandling().accessDeniedPage("/403");//controlleur des paggges
		 	
	}  
	 @Bean
	public PasswordEncoder passwordEncoder() {
		  return new BCryptPasswordEncoder();
	}
	
}
