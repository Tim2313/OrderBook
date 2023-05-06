FILE=out

if [ -f "$FILE" ]; then
    echo "$FILE exists."
else 
    mkdir $FILE
fi

javac src/main/java/com/ua/test_task/*.java -d out/


