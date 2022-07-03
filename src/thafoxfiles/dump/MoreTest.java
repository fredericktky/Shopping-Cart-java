package src.thafoxfiles.dump;

import java.util.Scanner;

public class MoreTest {
    public static void main(String args[]){
        InputInteger();
    }

    private static void InputInteger() {
        Scanner scanner = new Scanner(System.in);

        Integer converted = null;
        //this to check if your input is wrong then try again!
        while(converted == null) {
            String input =  scanner.next();
            try {
                converted = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("please enter input again");

            }
        }
        System.out.println(converted);
    }
}
