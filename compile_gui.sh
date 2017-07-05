#!/bin/sh
rm -rf out/
mkdir out/
javac -d out/ src/remotetest/gui/*.java
cp src/remotetest/gui/*.fxml out/remotetest/gui/
