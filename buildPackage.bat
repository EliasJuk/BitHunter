:: =============================
:: Gera o arquivo MANIFEST.MF
:: =============================

echo Manifest-Version: 1.0 > MANIFEST.MF
echo Main-Class: main.main >> MANIFEST.MF

echo Arquivo MANIFEST.MF criado com sucesso!

:: ==================================
:: Script para compilar e empacotar em .jar
:: ==================================

:: Compila os arquivos .java na pasta bin
javac -d bin src/main/*.java src/modules/*.java src/utils/*.java
if %errorlevel% neq 0 (
    echo Compilação falhou!
    pause
    exit /b
)

:: Cria o arquivo JAR, usando o MANIFEST.MF e o conteúdo da pasta bin
jar cfm BitHunter.jar MANIFEST.MF -C bin .
if %errorlevel% neq 0 (
    echo Falha ao criar o JAR!
    pause
    exit /b
)

echo JAR criado com sucesso!

:: ==================================
:: Remove o arquivo MANIFEST.MF e a pasta bin
:: ==================================

del MANIFEST.MF
if exist bin (
    rmdir /s /q bin
)


echo Arquivo MANIFEST.MF e pasta bin removidos com sucesso!
pause