#!/bin/sh

CP="junit.jar:hamcrest-core.jar:."

javac -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:.  --module-path . --add-modules javafx.controls  -Xlint NotationQueueTest.java NotationQueue.java 

java  -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore NotationQueueTest


#javac -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:.  --module-path . --add-modules javafx.controls  -Xlint NotationTest.java NotationQueue.java


#java  -cp junit-4.13.2.jar:hamcrest-core-1.3.jar:. org.junit.runner.JUnitCore NotationQueueTest

# when it is run under Windows
# timeout /t -1