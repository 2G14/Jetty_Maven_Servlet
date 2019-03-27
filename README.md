# Servlet Test

mavenをライブラリ管理に利用  
jettyはサーバークラスを作成  
ビルドは純粋なjavaコンパイラを使用  
(eclipse不使用)  

## set up

```bash
$ mvn archetype:generate -DarchetypeArtifactId=maven-archetype-webapp # webapp用 コマンド
$ cd [アーティファクトID]
$ vim pom.xml # ライブラリを記述
$ mvn dependency:copy-dependencies -DoutputDirectory=lib # ライブラリをlibディレクトリにダウンロード
```

## compile & run

```bash
# javac -d [output_directory] -cp [class_path] [src]
$ javac -d WebContent/WEB-INF/classes -cp "lib/*" src/**/*java
# java -cp [class_path] [server_class]
$ java -cp "lib/*:WebContent/WEB-INF/classes" server.AppServer
```
access localhost:8080/main on your browser.

## src tree

```none
.
├── README.md
├── WebContent
│   └── WEB-INF
│       └── classes
│           ├── server
│           │   └── AppServer.class
│           └── servlet
│               └── MainServlet.class
├── pom.xml
├── server.properties
└── src
    ├── server
    │   └── AppServer.java
    └── servlet
        └── MainServlet.java
```

### lib directory(make this using maven)

```none
.
└── lib
    ├── asm-7.0.jar
    ├── asm-analysis-7.0.jar
    ├── asm-commons-7.0.jar
    ├── asm-tree-7.0.jar
    ├── javax.annotation-api-1.3.jar
    ├── javax.servlet-api-4.0.1.jar
    ├── jetty-annotations-9.4.15.v20190215.jar
    ├── jetty-http-9.4.15.v20190215.jar
    ├── jetty-io-9.4.15.v20190215.jar
    ├── jetty-jndi-9.4.15.v20190215.jar
    ├── jetty-plus-9.4.15.v20190215.jar
    ├── jetty-security-9.4.15.v20190215.jar
    ├── jetty-server-9.4.15.v20190215.jar
    ├── jetty-servlet-9.4.15.v20190215.jar
    ├── jetty-util-9.4.15.v20190215.jar
    ├── jetty-webapp-9.4.15.v20190215.jar
    ├── jetty-xml-9.4.15.v20190215.jar
    └── junit-3.8.1.jar

```
