#!/bin/sh
ORBInitialPort=1050
ORBInitialHost=localhost

orbd -ORBInitialPort $ORBInitialPort -ORBInitialHost $ORBInitialHost &
java CalcImpl -ORBInitialPort $ORBInitialPort -ORBInitialHost $ORBInitialHost &

echo "run client with: ./calc_client ${IOR}"
