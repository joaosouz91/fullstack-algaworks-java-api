package com.algaworks.algamoney.api.config;


/**
 * 
 * @author joaosouz91
 * 
 * @implNote Implementacao do Basic Auth com Spring
 * Remover comentarios para ativar a classe
 *
 */

//@Configuration
//@EnableWebSecurity
public class SecurityConfig_old {
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("admin").roles("ROLE");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/categorias").permitAll()
				.anyRequest().authenticated()
				.and()
			.httpBasic().and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.csrf().disable();
	}*/

}