# ---------- STAGE 1: BUILD WAR with Ant ----------
FROM eclipse-temurin:11-jdk AS build
RUN apt-get update && apt-get install -y ant && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
# NetBeans/Ant projects mặc định tạo WAR trong thư mục dist/
RUN ant clean war

# ---------- STAGE 2: RUN on Tomcat ----------
FROM tomcat:9.0-jdk11
# Đảm bảo UTF-8 cho tiếng Việt
ENV CATALINA_OPTS="-Dfile.encoding=UTF-8"
# Xoá webapps mặc định để dùng ROOT của mình
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy WAR vừa build, đặt tên ROOT.war để truy cập ở "/"
COPY --from=build /app/dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
