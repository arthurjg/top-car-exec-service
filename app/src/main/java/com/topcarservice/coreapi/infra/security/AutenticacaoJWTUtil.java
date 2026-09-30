package com.topcarservice.coreapi.infra.security;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.topcarservice.coreapi.domain.Usuario;
import com.topcarservice.coreapi.infra.utils.DateTimeUtil;

public class AutenticacaoJWTUtil {
	
	public static final String TOKEN_KEY = "access_token";
	public static final String API_ISSUER = "Top Car Service Core API";
	public static final String TOKEN_SECRET = "s3cre7";
	
	public static Map<String, String> createToken(Usuario usuario) {
		Map<String, Object> payload = createTokenPayload(usuario);		
		
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		String jwtToken = JWT.create()
				.withIssuer(API_ISSUER)
				.withPayload(payload)
				.withExpiresAt(getExpirationDate())
				.sign(algorithm);
		
		Map<String, String> response = new HashMap<>();
		response.put(TOKEN_KEY, jwtToken);
		
		return response;
	}
	
	public static void validateToken(String token) {
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		JWT.require(algorithm)
				.withIssuer(API_ISSUER)
				.build()
				.verify(token);
	}
	
	private static Map<String, Object> createTokenPayload(Usuario usuario) {
		Map<String, Object> payload = new HashMap<>();
		payload.put("codigo", usuario.getCodigo());
		payload.put("nome", usuario.getNome());
		payload.put("login", usuario.getLogin());
		
		return payload;
	}
	
	private static Date getExpirationDate() {
		return DateTimeUtil.getByLocalDateTime(LocalDateTime.now().plusHours(1));
	}

}
