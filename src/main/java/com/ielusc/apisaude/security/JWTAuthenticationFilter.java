package com.ielusc.apisaude.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ielusc.apisaude.models.UserModel;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.ielusc.apisaude.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
												HttpServletResponse res) throws AuthenticationException {
		try {
			UserModel creds = new ObjectMapper()
					.readValue(req.getInputStream(), UserModel.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getUserName(),
							creds.getPassword(),
							new ArrayList<>())
			);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException, ServletException {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(((User) auth.getPrincipal()).getUsername());
		builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME));
		builder.signWith(SignatureAlgorithm.HS512, SECRET);
		String token = builder
				.compact();
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}

}