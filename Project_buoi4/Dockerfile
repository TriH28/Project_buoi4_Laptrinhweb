FROM tomcat:9.0-jdk11
ENV CATALINA_OPTS="-Dfile.encoding=UTF-8"
RUN rm -rf /usr/local/tomcat/webapps/*
# Đổi tên WAR của bạn cho khớp
COPY Project_buoi4.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
