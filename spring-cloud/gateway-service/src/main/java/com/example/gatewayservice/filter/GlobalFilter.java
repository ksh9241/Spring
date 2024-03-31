//package com.example.gatewayservice.filter;
//
//import lombok.Data;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
//@Component
//@Slf4j
///**
// * Global Filter는 application.yml 파일에 default-filter 옵션에 적용해주면 모든 라우터에 동일하게 동작한다.
// * 또한 제일 처음 PreFilter를 호출하고 제일 마지막 PostFilter를 호출한다.
// * */
//public class GlobalFilter extends AbstractGatewayFilterFactory<GlobalFilter.Config> {
//    public GlobalFilter() {
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
//            log.info("Global Filter baseMessage : {}", config.getBaseMessage());
//
//            if (config.isPreLogger()) {
//                log.info("Global Filter start: request id -> {}", req.getId());
//            }
//            // Custom Post Filter
//            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//                if (config.isPostLogger()) {
//                    log.info("Global Filter end: response response -> {}", res.getStatusCode());
//                }
//            }));
//        };
//    }
//
//
//    @Data
//    public static class Config {
//        private String baseMessage;
//        private boolean preLogger;
//        private boolean postLogger;
//    }
//}
