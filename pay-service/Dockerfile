FROM openjdk:21-jdk-slim
EXPOSE 8084
COPY build/libs/pay-service-0.0.1-SNAPSHOT.jar .
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ENTRYPOINT ["/wait-for-it.sh", "order-service:8083", "--timeout=90", "--", "java", "-jar", "pay-service-0.0.1-SNAPSHOT.jar"]