@ECHO OFF
SET A_PORT=8787
SET A_DBG=-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=%A_PORT%,server=y,suspend=y
java.exe %A_DBG% -cp .\bin com.goldenpond.regex.TestHarness
