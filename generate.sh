#!/bin/sh
# This is generator script.
#Creates output directory.
#Compiles Source file,Executes the monitoring_system code  and genrates log1.txt

# Check if the command line is empty or not
if [ ! -z "$1" ]&& [ "$1" != " " ];then

echo "Compiling source code"

#compile the source code
javac GlobalMembers.java
echo "Compilation successful"

#Execute the code and generate the logs 
java GlobalMembers log1.txt
echo "Logs generated"
else
echo "Please Enter Valid Data path.Example. ./generate.sh output_dir"
fi
