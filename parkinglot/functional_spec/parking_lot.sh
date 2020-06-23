#!/bin/sh
arg1=$1
##directory where jar file is located    
dir=target
## Please add jar file location instead of target in above line(jar is placed under build_file folder)
##jar file name
jar_name=parkinglot-0.0.1-SNAPSHOT

mvn clean install 

	java -jar $dir/$jar_name $arg1

fi
