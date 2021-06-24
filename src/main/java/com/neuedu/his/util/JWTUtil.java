package com.neuedu.his.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.neuedu.his.entity.User;

public class JWTUtil {
    public static final String KEY = "user";
    public static String create(User login) {
        return JWT.create()
                .withClaim("username",login.getUsername())
//                .withClaim("id",login.getUserId())
                .sign(Algorithm.HMAC256(KEY));
    }
}
