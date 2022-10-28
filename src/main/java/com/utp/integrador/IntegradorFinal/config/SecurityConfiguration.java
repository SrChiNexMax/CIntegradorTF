package com.utp.integrador.IntegradorFinal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.utp.integrador.IntegradorFinal.services.implementation.EmpleadoDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
    public UserDetailsService userDetailsService() {
        return new EmpleadoDetailsService();     }
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        
        return authProvider;
    }
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/css/**", "/js/**", "/img/**")
					.permitAll() 
				.antMatchers("/**")
					.authenticated()
				.and()
					.formLogin()
						.permitAll()
					.loginPage("/login");
		
        return http.build();
    }
	
/*
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception { auth.userDetailsService(userDetailsService); }
 */
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/editar/**", "/agregar/**", "/eliminar")
//			        .hasRole("ADMIN") 
//			    .antMatchers("/")
//			        .hasAnyRole("USUARIO","ADMIN")
//			    .and()
//			        .formLogin()
//			        .loginPage("/login")
//			    .and()
//			        .exceptionHandling().accessDeniedPage("/errores/403") ;
//		
// 		http.authorizeRequests()
//		.antMatchers().hasAnyRole("ADMIN","USUARIO")
//		.antMatchers("/", "/**").permitAll().and().formLogin().loginPage("/login");
//	}
	

}
