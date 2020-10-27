package com.ielusc.apisaude.security;

public class SecurityConstants {
    public static final String SECRET = "Palindromo";
    public static final long EXPIRATION_TIME = 43_200_000; // 12 horas
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/user";
}
