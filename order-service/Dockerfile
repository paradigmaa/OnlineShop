FROM openjdk:21-jdk-slim
EXPOSE 8083
COPY build/libs/order-service-0.0.1-SNAPSHOT.jar .
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ENTRYPOINT ["/wait-for-it.sh", "item-service:8082", "--timeout=90", "--", "java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]