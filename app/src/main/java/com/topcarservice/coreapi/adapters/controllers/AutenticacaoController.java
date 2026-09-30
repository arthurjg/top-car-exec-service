package com.topcarservice.coreapi.adapters.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.AutorizacaoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.UsuarioMapper;
import com.topcarservice.coreapi.domain.Usuario;
import com.topcarservice.coreapi.infra.security.AutenticacaoJWTUtil;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Autenticação", description = "Gerenciamento de autenticação")
@Slf4j
@RestController
@RequestMapping("/admin/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoController { 

	private final AuthenticationManager manager;

	private final UsuarioMapper usuarioMapper;

	@PostMapping
	public ResponseEntity<Object> login(@RequestBody @Validated AutorizacaoDTO autorizacao) {
		
		log.info("Autenticando usuário: {}", autorizacao.getLogin());

		var tokenParam = new UsernamePasswordAuthenticationToken(autorizacao.getLogin(), autorizacao.getSenha());
		var authentication = manager.authenticate(tokenParam);

		Usuario usarioLogin = usuarioMapper.mapTo((User) authentication.getPrincipal());
		Map<String, String> token = AutenticacaoJWTUtil.createToken(usarioLogin);

		return ResponseEntity.ok(token);
	}

}
