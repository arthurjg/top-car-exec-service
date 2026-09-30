package com.topcarservice.coreapi.infra.db.mappers;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.Usuario;

@Component
public class UsuarioDetailsMapper {
	
	public UserDetails convertUsuario(Usuario usuario) {
		return new User(usuario.getLogin(), usuario.getSenha(), List.of(new SimpleGrantedAuthority("ROLE_USER")) );	
	}
	
	public Usuario mapTo(UserDetails userDetails) {
		
		return Usuario.builder()
				.login(userDetails.getUsername())
				.build();	
	}

}
