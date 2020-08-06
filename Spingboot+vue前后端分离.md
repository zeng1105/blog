# Spingboot+vue前后端分离

1. ### 项目创建

![image-20200806170628759](C:\Users\zeng\AppData\Roaming\Typora\typora-user-images\image-20200806170628759.png)

- 导入jar包

  ```xml
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
  	<groupId>org.springframework.boot</groupId>
  	<artifactId>spring-boot-devtools</artifactId>
  	<scope>runtime</scope>
  	<optional>true</optional>
  </dependency>
  <dependency>
  	<groupId>org.projectlombok</groupId>
  	<artifactId>lombok</artifactId>
  	<optional>true</optional>
  </dependency>
  <!--mybatisplus-->
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-boot-starter</artifactId>
      <version>3.2.0</version>
  </dependency>
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-freemarker</artifactId>
  </dependency>
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <scope>runtime</scope>
  </dependency>
  <!--mp代码生成器-->
  <dependency>
      <groupId>com.baomidou</groupId>
      <artifactId>mybatis-plus-generator</artifactId>
      <version>3.2.0</version>
  </dependency>
  ```

- 编写配置文件

  即在application.properties

  ```txt
  spring:
    datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/blog?useUnicode=true&useSSL=false&characterEncoding=utf8
    username: root
    password: root
  mybatis-plus:
    mapper-locations: classpath*:/mapper/**Mapper.xml
  server:
    port: 8887
  ```

- 配置好数据库

  ```sql
  CREATE TABLE `m_user` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `username` varchar(64) DEFAULT NULL,
    `avatar` varchar(255) DEFAULT NULL,
    `email` varchar(64) DEFAULT NULL,
    `password` varchar(64) DEFAULT NULL,
    `status` int(5) NOT NULL,
    `created` datetime DEFAULT NULL,
    `last_login` datetime DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `UK_USERNAME` (`username`) USING BTREE
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
  
  CREATE TABLE `m_blog` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `user_id` bigint(20) NOT NULL,
    `title` varchar(255) NOT NULL,
    `description` varchar(255) NOT NULL,
    `content` longtext,
    `created` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
    `status` tinyint(4) DEFAULT NULL,
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
  
  INSERT INTO `blog`.`m_user` (`id`, `username`, `avatar`, `email`, `password`, `status`, `created`, `last_login`) VALUES ('1', 'markerhub', 'https://image-1300566513.cos.ap-guangzhou.myqcloud.com/upload/images/5a9f48118166308daba8b6da7e466aab.jpg', NULL, '96e79218965eb72c92a549dd5a330112', '0', '2020-04-20 10:44:01', NULL);
  ```

- 开启mapper接口扫描，添加分页插件

  创建com.myhub.config.MybatisPlusConfig类

  ```java
  @Configuration
  @EnableTransactionManagement
  @MapperScan("com.markerhub.mapper")
  public class MybatisPlusConfig {
      @Bean
      public PaginationInterceptor paginationInterceptor() {
          PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
          return paginationInterceptor;
      }
  }
  ```

- 代码生成工具CodeGenerator，该类可以直接复制粘贴使用，只是注意配置信息要与项目匹配

  ![image-20200806182840947](C:\Users\zeng\AppData\Roaming\Typora\typora-user-images\image-20200806182840947.png)

  - 其次执行代码生成器

    ![image-20200806183230723](C:\Users\zeng\AppData\Roaming\Typora\typora-user-images\image-20200806183230723.png)

- 