@echo off
::set Path=lib;%Path%
set startTime=%1
if {%1}=={} ( set startTime="test")
set runCycles=%2
set runDuration=%3
set currentTime=%time:~0,2%
if {%1}=={} (if {%2}=={} (if {%3}=={} java -cp lib\activation.jar;lib\mail.jar;lib\selenium-java-2.42.2-srcs.jar;lib\selenium-java-2.42.2.jar;lib\selenium-server-standalone-2.42.2.jar;lib\dom4j-1.6.1.jar;lib\jaxen-1.1.1.jar;lib\log4j-1.2.17.jar;lib\wtd.jar com.pub.WTD.common.Main
)

) else ( if not {%1}=={} (if not {%2}=={} (if not {%3}=={} (
::start to launch the schedule 
:mark
set currentTime=%time:~0,2%
if %startTime% equ %currentTime% (
for /L %%i in (1,1,%2) do (
echo ********************start the new  cycle test********************
java -cp lib\activation.jar;lib\mail.jar;lib\selenium-server-standalone-2.43.0.jar;lib\dom4j-1.6.1.jar;lib\jaxen-1.1.1.jar;lib\log4j-1.2.17.jar;lib\wtd.jar com.pub.WTD.common.Main
ping 127.0.0.1 -n %3 >null
)
echo *******************finish one cycle test*************************
)
echo ***********sleep 60 seconds for the next cycle test**************
ping 127.0.0.1 -n 60 >null

goto mark

)
)
) 
) 
