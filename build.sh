#/bin/sh
omniidl -bcxx Calc.idl 
idlj Calc.idl 
javac CalcImpl.java
g++ -L/opt/omniORB/lib -lomniORB4 -lomnithread CalcSK.cc CalcClient.cpp -o calc_client
