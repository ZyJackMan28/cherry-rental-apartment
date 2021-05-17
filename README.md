# Cherry Rent Apartment

## **How to play**

1. git clone `https://github.com/ZyJackMan28/cherry-rental-apartment.git`
2. open IDEA -->  File  -->  New  --> Open 
3. choose the tpom.xml under the project，open it
4. you must update your all application.properties files (jdbc,redis.mongoDB,ElasticSearch)
5. import emp.sql (you can use local or remote database)
6. before you setup the project, you must have Zookeeper3.3.x+ Dubbo2.7 and you need run mvn --projects dubbo-admin-server spring-boot:run
7. you can just run the project only with Insomnia  or Postman RESTful tools at your disposal.
8. enjoy it

## Develop Environment

IDEA + MAVEN + SpringBoot + Dubbo(Distributed Base) 

## 1.项目涉及的技术介绍

**Pecona:**本项目涉及到的建表SQL已经添加到项目文件夹文件名 cherryrental.sql，myhome.sql主要针对查询语句

**MyBatisPlus:** DOA层的开发，MyBatis配合Mapper动态代理的方式访问数据库

**SpringBoot:** 主要还是Spring IOC和AOP的核心，自动装配省去我们以前Spring配置的繁琐

**SpringMVC:** RESTful接口设计和使用，应用于Web Controller接口的开发

**前端:**  1交互设计 2.ReactJs,3.JQuery

## Note

本项目的后端运行环境在CentOS7.2下完成的，并且数据库等都在Docker容器中。



