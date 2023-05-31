from maven:latest as build
copy . .
run mvn clean package -Dmaven.test.skip=true


from openjdk:latest
copy --from=build /target/ExemploRest-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","ExemploRest-0.0.1-SNAPSHOT.jar"]

 