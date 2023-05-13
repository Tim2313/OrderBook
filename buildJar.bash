FILE=out
MANIFEST_FILE=src/main/resources/MANIFEST.MF 

if [ -e "$FILE" ] 
then
	rm -rf $FILE/*
else 
	mkdir $FILE
fi

javac src/main/java/com/ua/test_task/*.java -d $FILE

cd $FILE

jar cfm TestTaskBook.jar ../$MANIFEST_FILE ./* 

mv TestTaskBook.jar ../

