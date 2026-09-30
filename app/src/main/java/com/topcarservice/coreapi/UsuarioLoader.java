package com.topcarservice.coreapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.Usuario;
import com.topcarservice.coreapi.infra.db.repositories.UsuarioRepository;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UsuarioLoader {

	@Autowired
	private UsuarioRepository repository;
	
	@PostConstruct
	public void load() {
		
		log.info("Carregando usuário padrão...");
		
		String username = "fgarage";
		
		Usuario usuario = repository.findByLogin(username);
		
		if (usuario != null) {
			log.info("usuário padrão existente...");
			return;
		}
		
		String senha = "123456";
		
		var encriptador = new BCryptPasswordEncoder();
		
		String senhaCriptografada = encriptador.encode(senha);
		
		usuario = Usuario.builder()
				.nome("Flavio")
				.login(username)
				.senha(senhaCriptografada)
				.build();		
		
		repository.save(usuario);
		
		log.info("usuário padrão criado...");
		
	}

}
