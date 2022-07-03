package src.thafoxfiles.tools;

import src.thafoxfiles.ConsoleColorInterface.IConsoleColourInterface;

import java.util.Scanner;

public class InputType implements IConsoleColourInterface {

    public int GetInputInteger() {
        Scanner scanner = new Scanner(System.in);

        Integer converted = null;
        //this to check if your input is wrong then try again!
        while(converted == null) {
            String input =  scanner.next();
            try {
                converted = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                ErrorCode();

            }
        }
        return converted;
    }

    private void ErrorCode() {
        System.out.println(RED + "please enter input again");
        System.out.println(RESET);
    }

    public Float GetInputFloat() {
        Scanner scanner = new Scanner(System.in);

        Float converted = null;
        //this to check if your input is wrong then try again!
        while(converted == null) {
            String input =  scanner.next();
            try {
                converted = Float.parseFloat(input);
            } catch (NumberFormatException e) {
               ErrorCode();

            }
        }
        return converted;
    }
    public Double GetInputDouble() {
        Scanner scanner = new Scanner(System.in);

        Double converted = null;
        //this to check if your input is wrong then try again!
        while(converted == null) {
            String input =  scanner.next();
            try {
                converted = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                ErrorCode();

            }
        }
        return converted;
    }

}
