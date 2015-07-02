#!/bin/sh
ORBInitialPort=1050
ORBInitialHost=localhost

orbd -ORBInitialPort $ORBInitialPort -ORBInitialHost $ORBInitialHost localhost &
java CalcImpl -ORBInitialPort $ORBInitialPort -ORBInitialHost ORBInitialHost localhost&

echo "run client with: ./calc_client ${IOR}"
