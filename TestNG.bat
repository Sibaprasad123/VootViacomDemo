set projectLocation=.\..\VootViacomDemo
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\Lib\*
java org.testng.TestNG %projectLocation%\testng.xml
pause