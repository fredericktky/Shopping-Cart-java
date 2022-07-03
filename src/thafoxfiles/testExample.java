package src.thafoxfiles;

import java.util.ArrayList;
import java.util.Scanner;

public class testExample {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalCost = 0;
        double GST = 3;
        boolean isSubmit = false;
        boolean promo = false;
        String promoCode = "P10";


        //this can be simplifed but will teach you some time
        ArrayList<String> itemsList = new ArrayList<>();
        ArrayList<Double> itemsPrice = new ArrayList<>();
        ArrayList<Integer> itemsQuantity = new ArrayList<>();

        System.out.println("Welcome to Shopping Cart Calculator"); //Welcome
        System.out.println("Please add your item here"); //Welcome

        //insert new stuff here first
        totalCost = getGroceryItems(scanner, totalCost, itemsList, itemsPrice, itemsQuantity);
        while (!isSubmit) {
            String newItem = getInput("New item? (y/n)", scanner);
            if (newItem.equals("y")) {

                totalCost = getGroceryItems(scanner, totalCost, itemsList, itemsPrice, itemsQuantity);
            } else if (newItem.equals("n")) {

                String inputPromocode = getInput("Promo code:", scanner);

                if (inputPromocode.equals(promoCode)) {

                    promo = true;
                    System.out.println("Promo code valid");
                } else {
                    promo = false;
                }

                System.out.println("SHOPPING CART SUMMARY" +
                        "\nItem bought:" + itemsList +
                        "\nItem price:RM" + itemsPrice +
                        "\nItem Quantity:" + itemsQuantity);
                if (promo) {
                    double priceDeducted = totalCost * 30 / 100;
                    System.out.println("Discount: RM" + priceDeducted);
                } else {
                    System.out.println("No Discount");
                }
                double gstCost = totalCost * GST / 100; //Calculate total cart price and exit
                System.out.println("GST: RM" + gstCost);
                totalCost = totalCost + gstCost;
                System.out.println("Total cart: RM" + totalCost);
                isSubmit = true;
            } else {
                System.out.println("Please enter valid selection");
            }

        }

    }

    private static String getInput(String x, Scanner scanner) {
        System.out.println(x); //Check add new/ not
        String newItem = scanner.next();
        return newItem;
    }

    private static double getGroceryItems(Scanner scanner, double totalCost, ArrayList<String> itemsList, ArrayList<Double> itemsPrice, ArrayList<Integer> itemsQuantity) {
        //i have simplified using direct ask input to the arraylist, but
//        this method will cause error if you enter the data type wrong!
//        better if you use try method

        itemsList.add(getInput("Input grocery", scanner));

        System.out.println("Input price"); //Get input of itemprice, add to array
        itemsPrice.add(scanner.nextDouble());

        System.out.println("Quantity"); //Get input of item quantity, add to array
        itemsQuantity.add(scanner.nextInt());

        double totalItemPrice;
        if(itemsList.size() != 0) {
            //arraylist.get() means get the index , size - 1 means get the last element
            totalItemPrice = itemsPrice.get(itemsPrice.size() -1) * itemsQuantity.get(itemsQuantity.size() -1); //Calculate total item price

        }else{
            totalItemPrice = itemsPrice.get(0) * itemsQuantity.get(0); //Calculate total item price
        }
        totalCost = totalCost + totalItemPrice;
        System.out.println(itemsList.get(itemsPrice.size() -1) + " : " + totalItemPrice);
        return totalCost;
    }
}
