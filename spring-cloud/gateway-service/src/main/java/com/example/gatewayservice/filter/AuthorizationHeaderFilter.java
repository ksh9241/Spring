//package com.example.gatewayservice.filter;
//
//import io.jsonwebtoken.Jwts;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpHeaders;
//import org.springframework.core.env.Environment;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
//@Slf4j
//public class AuthorizationHeaderFilter extends AbstractGatewayFilterFactory<AuthorizationHeaderFilter.Config> {
//
//    Environment env;
//
//    public AuthorizationHeaderFilter(Environment env) {
//        this.env = env;
//    }
//
//    public static class Config {
//
//    }
//
//    // login -> token -> users (with token) -> header(include token)
//    public GatewayFilter apply(Config config) {
//        return ((exchange, chain) -> {
//            ServerHttpRequest req = exchange.getRequest();
//
//            if (!req.getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                return onError(exchange, "No Authorization Header", HttpStatus.UNAUTHORIZED);
//            }
//
//            String authorizationHeader = req.getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//            String jwt = authorizationHeader.replace("Bearer", "");
//
//            if (!isJwtValid(jwt)) {
//                return onError(exchange, "JWT token is not valid", HttpStatus.UNAUTHORIZED);
//            }
//
//
//            return chain.filter(exchange);
//        }) ;
//    }
//
//    private boolean isJwtValid(String jwt) {
//        boolean returnValue = true;
//
//        String subject = null;
//
//        try {
//            subject = Jwts.parser().setSigningKey(env.getProperty("token.secret"))
//                    .parseClaimsJws(jwt).getBody()
//                    .getSubject();
//        }
//        catch (Exception ex) {
//            returnValue = false;
//        }
//
//        if (subject == null || subject.isEmpty()) {
//            returnValue = false;
//        }
//
//        return returnValue;
//    }
//
//    // Mono, Flux -> String WebFlux
//    private Mono<Void> onError(ServerWebExchange exchange, String err, HttpStatus httpStatus) {
//        ServerHttpResponse res = exchange.getResponse();
//        res.setStatusCode(httpStatus);
//
//        return res.setComplete();
//    }
//
//}
