@echo off
set PWD=%~dp0

start javaw -jar %~dp0\target\executable-executable-jar-with-dependencies.jar 1%*
pause