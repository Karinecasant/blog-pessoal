package org.generation.blogPessoal.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //Habilita configuração de web security
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
private UserDetailsService userDetailsService; //Injetar de uma clase que ja existe da WebSecurityConfigurerAdapter

@Override //Sobre escrita de método
protected void configure (AuthenticationManagerBuilder auth)throws Exception {
	auth.userDetailsService(userDetailsService); //método protegido que vai sobre escrever o método que tem dentro do userDetailService
}

@Bean
public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
}

@Override
protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests()/*método configure + trativa de erro.Quando método for iniciado, inicia Http Security.Serve p/ liberar 
 endpoints (alguns caminhos) dentro do controller para que o cliente tenha acesso ao controller sem ter que fornecer uma chave em token*/

.antMatchers("/usuarios/logar").permitAll() //caminho endpoint para que o cliente consiga fazer requisições dentro na nossa API
.antMatchers("/usuarios/cadastrar").permitAll() //caminho endpoint para que o cliente consiga fazer requisições dentro na nossa API
.anyRequest().authenticated() //as demais requisições deverão ser autenticadas. No Header, precisarão passar a chave
.and().httpBasic() //padrão basic para gerar chave token
.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) /*Indica qual o tipo de sessão que vamos utilizar. 
Criação de politica, nesse caso STATELESS (não vai guardar sessão)*/
.and().cors() // habilita o cors dentro da camada de security
.and().csrf().disable(); // desabilitar disable. Não será uma arquitetura personalizada

/*método configure + trativa de erro. Assim que metodo for inciado, vai iniciar o Http Security.
 *serve para liberar endpoints (alguns caminhos) dentro do controller para que o cliente tenha acesso 
 *sem ter que fornecer uma chave em token. 
 */
 } 
}




