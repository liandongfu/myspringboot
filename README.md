# My Spring Boot Application

这是一个使用 Spring Boot 2.2.7 构建的应用程序，支持 Maven 和 Gradle 两种构建方式。

## 技术栈

- Spring Boot 2.2.7
- Java 8
- Spring Web
- Spring Actuator
- Spring Data Redis
- Lombok
- Spock Framework (Groovy 测试)

## 构建方式

### 使用 Maven 构建

#### 编译项目
```bash
mvn clean compile
```

#### 运行测试
```bash
mvn test
```

#### 打包应用
```bash
mvn clean package
```

#### 运行应用
```bash
mvn spring-boot:run
```

或者运行打包后的 jar：
```bash
java -jar target/myspringboot-1.0.0-SNAPSHOT.jar
```

### 使用 Gradle 构建

#### 编译项目
```bash
./gradlew compileJava
```

#### 运行测试
```bash
./gradlew test
```

#### 打包应用
```bash
./gradlew build
```

#### 运行应用
```bash
./gradlew bootRun
```

或者运行打包后的 jar：
```bash
java -jar build/libs/myspringboot-1.0.0-SNAPSHOT.jar
```

## Docker 部署

### 构建 Docker 镜像
```bash
docker build -t myspringboot:1.0 .
```

### 运行容器
```bash
docker run -d --name myspringboot -p 9090:9090 myspringboot:1.0
```

## 访问应用

应用启动后，可以通过以下 URL 访问：

- Hello 接口: http://localhost:9090/hello
- Actuator Health: http://localhost:9090/actuator/health

## Jenkins CI/CD

本项目包含 Jenkinsfile，支持通过 Jenkins 进行持续集成和部署。

### Jenkins 配置要求

- **Maven**: 名称为 `Maven 3.9.0`
- **JDK**: 名称为 `JDK 8`
- **Docker**: 需要在 Jenkins 节点上安装 Docker

### 构建参数

- **BUILD_TOOL**: 选择构建工具 (maven 或 gradle)，默认为 maven

### Pipeline 流程

1. **Source** - 从 Git 仓库检出代码
2. **Build & Test** - 使用选定的构建工具编译和测试
3. **Package** - 打包应用
4. **Docker Build** - 构建 Docker 镜像
5. **Deploy** - 部署容器

### 在 Jenkins 中创建任务

1. 创建新的 Pipeline 任务
2. 在 Pipeline 配置中选择 "Pipeline script from SCM"
3. 选择 Git 作为 SCM
4. 填写仓库 URL: https://github.com/liandongfu/myspringboot.git
5. Script Path 填写: `Jenkinsfile`
6. 选择构建工具参数（Maven 或 Gradle）
7. 保存并运行构建

## Maven 项目结构

```
myspringboot/
├── pom.xml                 # Maven 配置文件
├── build.gradle            # Gradle 配置文件
├── Dockerfile              # Docker 镜像构建文件
├── Jenkinsfile             # Jenkins Pipeline 配置
└── src/
    ├── main/
    │   ├── java/
    │   │   └── jp/co/test/
    │   │       ├── Application.java
    │   │       └── controller/
    │   │           └── HelloController.java
    │   └── resources/
    │       └── application.yml
    └── test/
        ├── groovy/         # Spock 测试（Groovy）
        └── resources/

```

## 依赖说明

### 主要依赖

- **spring-boot-starter-web**: Web 应用支持
- **spring-boot-starter-actuator**: 应用监控和管理
- **spring-boot-starter-data-redis**: Redis 数据访问
- **lombok**: 简化 Java 代码

### 测试依赖

- **spring-boot-starter-test**: Spring Boot 测试支持
- **spock-core**: Spock 测试框架核心
- **spock-spring**: Spock 与 Spring 集成

## 注意事项

1. Maven 和 Gradle 可以并存，互不影响
2. 两种构建方式生成的 jar 文件位置不同：
   - Maven: `target/myspringboot-1.0.0-SNAPSHOT.jar`
   - Gradle: `build/libs/myspringboot-1.0.0-SNAPSHOT.jar`
3. Jenkinsfile 支持跨平台（Unix/Windows）
4. 确保 Jenkins 中正确配置了 Maven 和 JDK 工具
