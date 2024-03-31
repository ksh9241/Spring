//package com.example.gatewayservice.filter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//@Slf4j
///**
// * Custom Filter는 application.yml 파일에 라우터 별 Filter를 적용해줘야 한다.
// * */
//public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
//    public CustomFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        // Custom Pre Filter
//        return (exchange, chain) -> {
//            ServerHttpRequest req = exchange.getRequest();
//            ServerHttpResponse res = exchange.getResponse();
//
//            log.info("Custom PRE filter : request id -> {}", req.getId());
//
//            // Custom Post Filter
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                log.info("Custom POST filter : response code -> {}", res.getStatusCode());
//            }));
//        };
//    }
//
//
//    public static class Config {
//        // Put the Configuration properties
//    }
//}
