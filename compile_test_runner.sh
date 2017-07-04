#!/bin/sh
rm -rf out/
mkdir out/
javac -sourcepath src -d out -classpath "src/remotetest/test_runner/libs/jackson-annotations-2.6.3.jar:src/remotetest/test_runner/libs/jackson-core-2.6.3.jar:src/remotetest/test_runner/libs/jackson-databind-2.6.3.jar:src/remotetest/test_runner/libs/JSTAF.jar" src/remotetest/test_runner/staf_test/ExampleTest.java
