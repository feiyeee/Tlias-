package com.feiye;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;

//@SpringBootTest
class SpringbootWebProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"feiye")// 签名算法
                .setClaims(claims)// 自定义内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))// 设置有效期为1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("feiye")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcyMTE0MTUwMH0.pVw9qRaaPu0Z-PiP4jaBkM5vyDSAOmJVPr9gRhRgLR4")
                .getBody();
        System.out.println(claims);
    }

}
