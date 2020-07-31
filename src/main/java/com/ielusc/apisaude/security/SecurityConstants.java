package com.ielusc.apisaude.security;

public class SecurityConstants {
    public static final String SECRET = "Palindromo";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/api-saude/user";
}
