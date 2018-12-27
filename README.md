# fast-data-structures
You can use this project to insert integers or check whether an integer is inserted in O(lg n).
## How to use it?
To use this project, you should run "Fast_Data_Structure-1.0-SNAPSHOT-jar-with-dependencies.jar" file (in the root folder of this project). You should have Java 8 on your system for running this jar file.
```
java -jar Fast_Data_Structure-1.0-SNAPSHOT-jar-with-dependencies.jar
```
After running the jar file, it will ask you whether you want to see the logging or not.

In the next step, you can choose whether you want to select specific numbers that should be inserted or insert randomly generated numbers.

If you choose to insert randomly generated numbers, you will have to select the range of random numbers, the number of random numbers that should be generated, and the number of random numbers that will be checked whether they are inserted or not. If you enable logging option, all the inserted and checked numbers will be logged.

If you choose to select specific numbers that should be inserted, you will be able to insert as many numbers as you want and then check whether a number is inserted or not. You can also print all the inserted numbers in each step.

## How to change it?
This project uses MAVEN for building. In order to change the code, you can files in ./src folder and then run the following command in the root folder of the project. As a result, a new "Fast_Data_Structure-1.0-SNAPSHOT-jar-with-dependencies.jar" will be created in the ./target folder.
```
mvn package
```
Please note that you should have MAVEN on your system for running this command.
## Some notes
This project uses AVL_TREE and RED_BLACK_TREE to insert and check numbers.

Every time you print all the inserted numbers or check whether a number is inserted or not, the actual results (calculated by using Set class) and the results calculated by AVL_TREE and RED_BLACK_TREE will be written separately.