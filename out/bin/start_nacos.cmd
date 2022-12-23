
@echo off
cd "%~dp0"
cd ..
cd nacos
cd bin
./startup.cmd -m standalone
"./shutdown.cmd"