package com.topcarservice.coreapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsuarioServiceTest {
	
	@Test
	public void testEncriptarSenha() {
		
		String senha = "123456";
		
		var encriptador = new BCryptPasswordEncoder();
		
		String senhaCriptografada = encriptador.encode(senha);
		
		System.out.println("senhaCriptografada: " + senhaCriptografada);
		
	}

}
