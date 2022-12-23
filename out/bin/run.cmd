@REM @echo off
@REM echo "%cd%../nacos"


set "force_start=1"
set "java_exe=E:/Program Files (x86)/openjdk-19.0.1/bin/javaw.exe"
set "need_nacos=1"
@REM 要跟配置文件里的相同
set "nacos_port=8848" 

@REM 这个端口暂时不能变
set "gateway_port=20010"
set "user_info_port=18081"
set "resource_port=18082"
set "article_port=18083"


cd "%~dp0"
cd ..
cd nacos


@REM if "%need_nacos%" == "1" (

@REM "./bin/shutdown.cmd"
@REM start /b "./bin/startup.cmd -m standalone"
@REM @REM timeout 3
@REM )

cd ..

if "%force_start%" == "1" (
echo "hi"
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%gateway_port%"') do (
        echo "kill %%m"
        taskkill /F /PID %%m
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%user_info_port%"') do (
        echo "kill %%m"
        taskkill /F /PID %%m
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%resource_port%"') do (
        echo "kill %%m"
        taskkill /F /PID %%m
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%article_port%"') do (
        echo "kill %%m"
        taskkill /F /PID %%m
    )

) else (

echo "hi"
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%gateway_port%"') do (
        echo "port %gateway_port% is occupied" >> "%cd%/log/log.txt"
        exit
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%user_info_port%"') do (
        echo "port %user_info_port% is occupied" >> "%cd%/log/log.txt"
        exit
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%resource_port%"') do (
        echo "port %resource_port% is occupied" >> "%cd%/log/log.txt"
        exit
    )
    for /f "tokens=5" %%m in ('netstat -aon ^| findstr ":%article_port%"') do (
        echo "port %article_port% is occupied" >> "%cd%/log/log.txt"
        exit
    )

)


"%java_exe%" -jar "jar/notes-app.backend.article-0.0.1-SNAPSHOT.jar" --server.port=%article_port% --spring.cloud.server-addr=localhost:%nacos_port%
"%java_exe%" -jar "jar/notesapp.backend.resource-0.0.1-SNAPSHOT.jar" --server.port=%resource_port% --spring.cloud.server-addr=localhost:%nacos_port%
"%java_exe%" -jar "jar/notesapp-backend.userinfo-0.0.1-SNAPSHOT.jar" --server.port=%user_info_port% --spring.cloud.server-addr=localhost:%nacos_port%
"%java_exe%" -jar "jar/notesapp-backend.gateway-0.0.1-SNAPSHOT.jar" --server.port=%gateway_port% --spring.cloud.server-addr=localhost:%nacos_port%


