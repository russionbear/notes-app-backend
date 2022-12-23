

set "force_start=0"
set "java_exe=E:/Program Files (x86)/openjdk-19.0.1/bin/java.exe"
set "need_nacos=1"
@REM 要跟配置文件里的相同
set "nacos_port=8848" 

@REM 这个端口暂时不能变
set "gateway_port=20010"
set "user_info_port=18081"
set "resource_port=18082"
set "article_port=18083"



start /b "%java_exe%" -jar "jar/notes-app.backend.article-0.0.1-SNAPSHOT.jar" --server.port=%article_port% --spring.cloud.server-addr=localhost:%nacos_port%
start /b "%java_exe%" -jar "jar/notes-app.backend.resource-0.0.1-SNAPSHOT.jar" --server.port=%resource_port% --spring.cloud.server-addr=localhost:%nacos_port%
start /b "%java_exe%" -jar "jar/notes-app.backend.userinfo-0.0.1-SNAPSHOT.jar" --server.port=%user_info_port% --spring.cloud.server-addr=localhost:%nacos_port%
start /b "%java_exe%" -jar "jar/notes-app.backend.gateway-0.0.1-SNAPSHOT.jar" --server.port=%gateway_port% --spring.cloud.server-addr=localhost:%nacos_port%


