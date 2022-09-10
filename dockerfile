FROM openjdk:latest

ARG JAR_FILE

# 添加 Spring Boot 包
ADD target/${JAR_FILE} app.jar

# 执行启动命令
ENTRYPOINT ["java","-jar","/app.jar"]
