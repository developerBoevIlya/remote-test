mkdir out
javac -sourcepath src -d out src\remotetest\gui\*.java
copy "src\remotetest\gui\*.fxml" "out\remotetest\gui\"
