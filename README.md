# Multi-Container Infrastructure using Docker Compose

Containers: app-db (PostgreSQL) -> app-service (Spring Boot) -> api-gateway (Spring Cloud Gateway) + eureka-server (discovery).
Build tool: Gradle (no pom.xml). Config: application.properties.

## Step 1 - Define docker-compose.yml
Already provided in the project root (app-db, app-service, eureka-server, api-gateway + environment variables).

## Step 2 - Deploy
    docker-compose up -d --build
(or `docker compose up -d --build`). First build takes a few minutes. Check: `docker ps`

## Step 3 - Test
    curl http://localhost:8080/api/data        # via API gateway
    curl http://localhost:8081/api/data        # directly to app-service
    curl -X POST http://localhost:8080/api/data -H "Content-Type: application/json" \
         -d '{"name":"Item 4","description":"added via gateway"}'
Eureka dashboard: http://localhost:8761

## Stop
    docker-compose down        (add -v to delete DB volume)

Note: wait ~30-60 seconds after `up` so services register in Eureka before calling the gateway.
