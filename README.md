# Servlet Test

mavenをライブラリ管理に利用  
jettyはサーバークラスを作成  
ビルドは純粋なjavaコンパイラを使用  
(eclipse不使用)  

## set up

```bash
$ mvn  archetype:generate -DarchetypeArtifactId=maven-archetype-webapp # webapp用 コマンド
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
