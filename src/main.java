package src;

import java.util.Scanner; //input
import java.util.ArrayList; //array


public class main {
    public main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalCost=0;
        double GST = 3;
        int x = 0;

        boolean promo;
        String promoCode= "P10";
        double promoDiscount= 10.0;

        ArrayList<String> itemsList = new ArrayList<>();
        ArrayList<Double> itemsPrice = new ArrayList<>();
        ArrayList<Integer> itemsQuantity = new ArrayList<>();

        System.out.println("Welcome to Shopping Cart Calculator"); //Welcome

        while (x == 0) {
            System.out.println("New item? (y/n)"); //Check add new/ not
            String Newitem = scanner.next();
                if (Newitem.equals("y")){
                    System.out.println("Input name"); //Get input of itemname, add to array
                    String itemname = scanner.next();
                    itemsList.add(itemname);

                    System.out.println("Input price"); //Get input of itemprice, add to array
                    double price = scanner.nextDouble();
                    itemsPrice.add(price);

                    System.out.println("Quantity"); //Get input of item quantity, add to array
                    int quantity = scanner.nextInt();
                    itemsQuantity.add(quantity);

                    double totalItemPrice= price*quantity; //Calculate total item price
                    totalCost= totalCost+totalItemPrice;
                    System.out.println (itemname +":"+ totalItemPrice);}

                else if (Newitem.equals("n")){
                    System.out.println("Promo code:");
                    String inputPromocode= scanner.next();
                        if (inputPromocode.equals(promoCode)){
                            promo=true;
                            System.out.println("Promo code valid");
                        }
                        else{
                            promo=false;
                        }

                    System.out.println("SHOPPING CART SUMMARY"+
                            "\nItem bought:" +itemsList+
                            "\nItem price:RM"+itemsPrice+
                            "\nItem Quantity:"+itemsQuantity);
                        if(promo) {
                            double priceDeducted = totalCost * promoDiscount / 100;
                            System.out.println("Discount: RM" + priceDeducted);
                        }
                        else{
                            System.out.println("No Discount");
                    }
                    double gstCost= totalCost*GST/100; //Calculate total cart price and exit
                    System.out.println("GST: RM"+gstCost);
                    totalCost=totalCost+gstCost;
                    System.out.println("Total cart: RM"+totalCost);
                    x=1;}
                else{
                    System.out.println("Please enter valid selection");}

        }

    }
}


//add promocode
//sort up code
//better listing
//Item code