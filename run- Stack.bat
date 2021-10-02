javac -cp junit-4.13.2.jar;hamcrest-core-1.3.jar;. NotationStack.java NotationStackTest.java StackInterface.java StackOverflowException.java StackUnderflowException.java NotationQueue.java
java -cp junit-4.13.2.jar;hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore NotationStackTest
timeout /t -1