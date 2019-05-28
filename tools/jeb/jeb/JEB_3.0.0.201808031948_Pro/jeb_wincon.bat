@echo off

rem Start-up script for JEB (Windows Console)
rem Used to circumvent the double-quote in var issue with Batch scripts
set argCount=0
for %%x in (%*) do set /A argCount+=1

rem Prefer local JRE
set JAVA=bin\runtime\bin\java.exe
if exist %JAVA% goto :checkdep

rem Prefer a JDK over a JRE
if defined JAVA_HOME (set base="%JAVA_HOME%\bin") else (set base="%SystemRoot%\System32")
set JAVA=%base%\java.exe

rem Note: If the Java path generation does not yield a correct result, manually set
rem the JAVA variable (defined above) to a correct value
if exist %JAVA% goto :checkdep
for /F "delims=" %%i in ('where java') do set JAVA="%%i"
if exist %JAVA% goto :checkdep
echo JEB requires a Java runtime environment, please install one.
exit /b -1

:checkdep
set INSTALLER="%~dp0bin\app\jebi.jar"
%JAVA% -jar %INSTALLER% --di -- %*
if errorlevel 0 goto :checkupdate
exit /b -1

:checkupdate
%JAVA% -jar %INSTALLER% --up -- %*
if errorlevel 0 goto :runjeb
exit /b -1

:runjeb
if "%argCount%" == "0" goto :startjeb
if %1 == -c goto :startraw

:startjeb
set JEB="%~dp0bin\jeb1.exe"
if exist %JEB% goto :runlauncher
%JAVA% -jar "%~dp0bin\app\jebc.jar" %*
exit 0
:runlauncher
%JEB% %*
exit 0

:startraw
%JAVA% -jar "%~dp0bin\app\jeb.jar" %*
