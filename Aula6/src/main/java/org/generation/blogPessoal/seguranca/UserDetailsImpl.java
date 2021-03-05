package org.generation.blogPessoal.seguranca;

import java.util.Collection;
import java.util.List;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long SerialVersionUID = 1L; //classe para controle interno
	
	private String userName;  //atributos privados
	private String password; //atributos privados
	private List<GrantedAuthority> authorities;
	
	public UserDetailsImpl(Usuario user) {
		this.userName = user.getUsuario();//construtor de classe populado com user
		this.password = user.getSenha(); //construtor de classe populado com senha
	}
	
	public UserDetailsImpl() {}//construtor vazio
	
	//1-Métodos da implementação
	//2-Implementar métodos de acordo com politicas do user detail
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password; //2-alterar de null para password
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName; //2-alterar de null para userName
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true; //2-alterar de false para true (boa prática)
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true; //2-alterar de false para true (boa prática)
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true; //2-alterar de false para true (boa prática)
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true; //2-alterar de false para true (boa prática)
	}

}
