@echo off
set JAVA_HOME=D:\java17
set PATH=%JAVA_HOME%\bin;%PATH%

rem Path to the TestNG JAR files is in the lib directory
set LIB_DIR=.\lib

rem Directory containing the classes to be tested
set TO_BE_TEST_CLASSPATH=.\betest

rem Directory for test suite (class is in the test directory relative to current directory)
set TEST_SUITE_CLASSPATH=.\test

rem Constructing the CLASSPATH with TestNG JAR files
setlocal EnableDelayedExpansion
set DEP_JAR=""
for /r %LIB_DIR% %%i in (*.jar) do if !DEP_JAR!=="" (set DEP_JAR=%%i) else (set DEP_JAR=!DEP_JAR!;%%i)

set CLASSPATH=%CLASSPATH%;%TO_BE_TEST_CLASSPATH%;%TEST_SUITE_CLASSPATH%;%DEP_JAR%

java --add-opens java.base/java.lang=ALL-UNNAMED --add-opens java.base/java.math=ALL-UNNAMED --add-opens java.base/sun.net.util=ALL-UNNAMED org.testng.TestNG testng.xml -d test-output