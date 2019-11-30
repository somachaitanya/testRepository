set projectLocation=D:\java workspace\MOD_framework2
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\lib\*
java org.testng.TestNG %projectLocation%\testngSuit.xml
