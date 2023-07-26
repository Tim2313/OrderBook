FILE=out
MANIFEST_FILE=src/main/resources/MANIFEST.MF
SOURCE_FILES=src/main/java/*

if [ -e "$FILE" ] 
then
	rm -rf $FILE/*
else 
	mkdir $FILE
fi

find ./src/ -type f -name "*.java" > sources.txt
javac -d ./out/ @sources.txt
rm sources.txt

cd $FILE

jar cfm TestTaskBook.jar ../$MANIFEST_FILE ./*  ../$SOURCE_FILES 

