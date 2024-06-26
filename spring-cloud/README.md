# Spring Cloud

### Spring Cloud
- Centralized Configuration Management
    - Spring Cloud Config Server
- Location Transparency
    - Naming Server(Eureka)
- Load Distribution (Load Balancing)
    - Ribbon (Client Side)
    - Spring Cloud Gateway
- Easier REST Clients
    - FeignClient
- Visibility and Monitoring
    - Zipkin Distributed Tracing
    - Netflix API Gateway
- Fault Tolerance
    - Hystrix

### CI/CD
- 지속적인 통합
    - Jenkins, Team CI, TravisCI
    - 통합 서버, 소스관리, 빌드도구, 테스트 도구
- 지속적인 배포
    - Continuous Delivery (수동 반영)
    - Continuous Deployment (자동 반영)
- 카나리 배포와 블루그린 배포
    - 카나리 배포
        - 95% 기존버전 사용자
        - 5% 새 버전 사용자
    - 블루그린 배포
        - 100% 사용자가 이전 서비스 -> 새 서비스

### DevOps
- 자주 테스트하고, 자주 통합, 자주 배포

### Container 가상화
- 하드웨어, 서버 가상화보다 적은 비용으로 운영 가능

### 12Factors
1. Base Code
2. Dependency Isolation
3. Configurations
4. Linkable Backing Services
5. Stages Of Creation
6. Stateless Processes
7. Port Binding
8. Concurrency
9. Disposability
10. Development&Production Parity
11. Logs
12. Admin Processes For Eventual Processes


### SOA 와 MSA와 차이점
- 서비스 공유 지향점
    - SOA 
        - 재사용을 통한 비용 절감
        - 공통의 서비스를 ESB에 모아 사업 측면에서 공통 서비스 형식으로 서비스 제공
    - MSA 
        - 서비스 간의 결합도를 낮춰 변화에 능동적으로 대응
        - 각 독립된 서비스가 노출된 REST API를 사용

### Service Discovery (eureka)
    - 서비스 key/value로 등록과 검색을 관리하는 서비스

### API Gateway Service
백엔드 로드밸런싱 역할

Spring Cloud - Gateway Dependency 사용
- 설정 시 주의사항
    - predicates 조건 주소값이 그대로 처리되기 때문에 RequestMapping URL 신경쓰기

- API Gateway Service 기능
    - 인증 및 권한 부여
    - 서비스 검색 통합
    - 응답 캐싱
    - 정책, 회로차단기 및 QoS 다시 시도
    - 속도 제한
    - 부하 분산
    - 로깅, 추적, 상관관계
    - 헤더, 쿼리문자열 및 청구 전환
    - IP 허용 목록에 추가

### Spring Cloud MSA간 통신
Feign Client 를 통한 통신

### Change Configuration 방법
- MS 서버 재기동
- Actuator refresh
- Spring cloud bus 사용

#### SpringBoot Actuator
[https://spring.io/guides/gs/actuator-service]
Config Server의 수정사항을 각 MS의 재기동 없이 적용하는 방법

    - Application 상태,모니터링
    - Metric 수집을 위한 Http End point 제공
    - 단점으로는 각각의 MS가 있을 경우 어플리케이션 마다 리프레시를 해줘야하는 번거로움이 있다.

#### Spring Cloud Bus
    - 분산 시스템의 노드를 경량 메시지 브로커와 연결
    - 상태 및 구성에 대한 변경 사항을 연결된 노드에게 전달 (Broadcast)