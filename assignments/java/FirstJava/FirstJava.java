import java.io.*;

public class FirstJava{
    public static void main(String[] args){
        System.out.println("My name is Dana.");
        System.out.println("I am 100 years old! Ha ha!");
        System.out.println("My hometown is Aubrey, TX.");

        //call the fizz buzz method
        fizzBuzz();

        //call the arrayPlay method
        arrayPlay();
    }
    public static void fizzBuzz(){

        for(int i = 1; i <= 100; i++){
            // divisible by BOTH print fizz buzz
            if(i % 3 == 0 && i % 5 == 0){
                System.out.print("FizzBuzz ");
            }
            // divisible by 3 print fizz
            else if(i % 3 == 0){
                System.out.print("Fizz ");
            }
            // divisible by 5 print buzz
            else if (i % 5 == 0){
                System.out.print("Buzz ");
            }//end of else if (i % 5 == 0)

            // else just print the number
            else{
                System.out.print(i + " ");
            }
        }  
        System.out.println();
    }

    public static void arrayPlay(){
        // declare and initialize an array
        int[] myArray = {4, 8, 8, 5, 9};
        //print an array
        for(int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }

        for(int element : myArray){
            System.out.print(element + " ");
        }
        System.out.println();


    }
}

