package com.topcarservice.coreapi.adapters.controllers.mappers;

import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.Usuario;

@Component
public class UsuarioMapper {
	
	/*
	 * public UserDetails convertUsuario(Usuario usuario) { return new
	 * User(usuario.getEmail(), usuario.getSenha(), usuario.getPermissoes()
	 * .stream() .map(permissao -> new SimpleGrantedAuthority(permissao.getNome()))
	 * .collect(Collectors.toList())); }
	 */
	
	public Usuario mapTo(UserDetails userDetails) {
		
		return Usuario.builder()
				.login(userDetails.getUsername())
				.build();	
	}

}
