package com.topcarservice.coreapi.infra.db;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.topcarservice.coreapi.domain.Usuario;
import com.topcarservice.coreapi.infra.db.mappers.UsuarioDetailsMapper;
import com.topcarservice.coreapi.infra.db.repositories.UsuarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {
	
	private final UsuarioRepository usuarioRepo;
	
	private final UsuarioDetailsMapper usuarioMapper;	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {	
		
		Usuario usuario = usuarioRepo.findByLogin(username);
		return usuarioMapper.convertUsuario(usuario);		 
	}	

}
