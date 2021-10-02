javac -cp junit-4.13.2.jar;hamcrest-core-1.3.jar;. NotationQueue.java NotationQueueTest.java QueueInterface.java QueueOverFlowException.java QueueUnderFlowException.java
java -cp junit-4.13.2.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore NotationQueueTest
timeout /t -1