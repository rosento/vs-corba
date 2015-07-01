#/bin/sh
omniidl -bcxx Calc.idl 
idlj Calc.idl 
javac CalcImpl.java
