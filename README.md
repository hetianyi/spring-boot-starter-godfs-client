# godfs-java-client
java client for godfs!

[![Build Status](https://travis-ci.org/hetianyi/godfs-java-client.svg?branch=master)](https://travis-ci.org/hetianyi/godfs-java-client)


maven dependency:
```javascript
<dependency>
    <groupId>com.github.hetianyi</groupId>
    <artifactId>spring-boot-starter-godfs-client</artifactId>
    <version>1.0.0</version>
</dependency>
```



configuration in application.yml:
```javascript
spring:
  servlet:
    multipart:
      enabled: false
      resolve-lazily: true
godfs:
  secret: xxx
  trackers:
    - host: 127.0.0.1
      port: 1022
      max-connections: 50
    - host: 192.168.1.100
      port: 1022
      max-connections: 50
```

start using:
```javascript
@Autowired
private GodfsApiClient godfsApiClient;
```