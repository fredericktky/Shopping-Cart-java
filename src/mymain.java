package src;

import java.util.ArrayList;
import java.util.Scanner;

public class mymain {


    static Boolean isDone = false;
    public static void main(String[] args) {
        //using class to pull the data from the shop
        ArrayList<ShopItem>shopItems = new ShopItem().getAllStoreItems();
        //for customer to use it, to check all the properties click the customerPortal
        CustomerPortal customerItems = new CustomerPortal();
        Scanner scanner = new Scanner(System.in);


        displayMenu();
        while(!isDone){
            //will crash if you enter string yeah
            System.out.println("Welcome to mart \n" +
                    "<==============================>");
            System.out.println("Enter your service: ");
            int selection = scanner.nextInt();
            switch (selection) {
                case 0 -> displayMenu();
                case 1 -> showItems(shopItems);
                case 2 -> //select item in cart
                        SelectItem(shopItems, customerItems, scanner);
                case 3 -> {
                    //show cart
                    ArrayList<ShopItem> cart = customerItems.showShoppingCart();
                    if (!cart.isEmpty()) {
                        showItems(cart);
                    } else {
                        System.out.println("you havent add anything in yet!");
                    }

                    break;
                }
                case 4 -> {
                    //buy items
                    if (customerItems.showShoppingCart().isEmpty()) {
                        System.out.println("there is no item in cart!");
                        break;
                    }
                    if (customerItems.isPaid()) {
                        System.out.println("You have paid the items! Restart program to buy again!");
                        break;
                    }
                    //ask coupon
                    System.out.println("do you have coupon? 1/0");
                    int Input = scanner.nextInt();
                    //there is a problem on my side
//                     where the Y/N input is in other character so i need to use 1/0
//                    turns out you neeed to use the .equals() to not get logic error
                    if (Input == 1) {
                        System.out.println("enter your coupon code");
                        String couponCode = scanner.next();
                        customerItems.setCoupon(couponCode);
                        if (customerItems.getCoupon() == null) {
                            System.out.println("no coupon found, returning back to main menu");
                            break;
                        }
                        Checkout(customerItems, scanner);

                    } else if (Input == 0) {
                        Checkout(customerItems, scanner);

                    } else {
                        System.out.println("Please try again!");
                    }
                    break;
                }
                case 5 -> {
                    System.out.println("Goodbye!");
                    isDone = true;
                    break;
                }
                default -> {
                    System.out.println("Invalid service, please type again!");
                    break;
                }
            }
        }


    }

    private static void Checkout(CustomerPortal customerItems, Scanner scanner) {
        System.out.println("Total amount is: " + customerItems.getPayment());
        System.out.println("Please enter the amount to pay");
        double payment = scanner.nextDouble();
        customerItems.setPayment(payment);
        if(customerItems.isPaid()) {
            System.out.println("Thank you for purchasing");
            isDone = true;
        }else{
            System.out.println("Error on purchase! rejecting...");
        }


    }

    private static void SelectItem(ArrayList<ShopItem> shopItems, CustomerPortal customerItems, Scanner scanner) {
        showItems(shopItems);
        System.out.println("select the number");

        Integer index, quantity;
        do{
            index = scanner.nextInt();
            if(index >= shopItems.size() || index < 0){
                System.out.println("invalid option!");
            }
        }while(index >= shopItems.size() || index < 0);

        showItem(shopItems.get(index));
        System.out.println("select quantity");
        do{
          quantity = scanner.nextInt();
          if(quantity > shopItems.get(index).getQuantity()){
              System.out.println("Item cannot be set more than the quantity shop have!");
          }
        }while(quantity < 0 || quantity > shopItems.get(index).getQuantity());

        //shop quantity reduce
        shopItems.get(index).setQuantity(shopItems.get(index).getQuantity() - quantity);
        //add to customer cart
        customerItems.itemsCustomerSelect(
                new ShopItem(
                        shopItems.get(index).getName(),
                        shopItems.get(index).getPrice(),
                        quantity
        ));
        System.out.println( customerItems.showShoppingCart().get(customerItems.showShoppingCart().size()-1).getName()
                + " successfully added into cart!");
        return;
    }

    private static void displayMenu() {
        System.out.print(
                """
                        0. display menu\s
                        1. display mart items\s
                        2. buy items\s
                        3. check cart\s
                        4. buy items\s
                        5. exit\s
                        """);
    }

    private static void Testing(ArrayList<ShopItem> shopItems) {
        showItems(shopItems);
        shopItems.add(new ShopItem("Honey", 25.00, 5));
        shopItems.get(1).setPrice(99.0);
        showItems(shopItems);
    }

    private static void showItems(ArrayList<ShopItem> shopItems) {
        System.out.printf("%-5s %-25s %15s %15s\n", "No.", "name" ,  "price" , "quantity" );
        System.out.println("__________________________________________________________");
        //now i test can i add something or change in the shopItems
//        for loop 1.Type of object, 2. variable, 3.the variable to refer to
        int index = 0; //i lazy to do the inti i = 0 after reedit stuff
        for(ShopItem item: shopItems){
            System.out.printf("%-5s %-25s %15.2f %15s\n", index, item.getName() ,  item.getPrice() , item.getQuantity());
            index++;
        }
    }

    private static void showItem(ShopItem item) {
        System.out.printf("%-25s %15s %15s\n", "name" ,  "price" , "quantity" );
        System.out.println("__________________________________________________________");
        //now i test can i add something or change in the shopItems
//        for loop 1.Type of object, 2. variable, 3.the variable to refer to

        System.out.printf("%-25s %15.2f %15s\n", item.getName() ,  item.getPrice() , item.getQuantity());

    }



}

