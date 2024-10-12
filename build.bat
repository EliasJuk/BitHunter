@echo off
cd /d "%~dp0"  // Muda para o diretório onde o arquivo .bat está localizado

:: Verifica se a pasta src existe
if not exist src (
    echo A pasta src nao foi encontrada!
    pause
    exit /b
)

:: Cria a pasta bin se não existir
if not exist bin (
    mkdir bin
)

cd src\main
:: Verifica se o arquivo main.java existe
if not exist main.java (
    echo main.java nao encontrado!
    pause
    exit /b
)

:: Compila o arquivo main.java e as classes na pasta utils, colocando os .class em bin
javac -d ../../bin main.java ..\utils\*.java
if %errorlevel% neq 0 (
    echo Compilacao falhou!
    pause
    exit /b
)

:: Executa o arquivo main
echo Compilacao bem-sucedida!
cd ../../bin/
java main.main
pause