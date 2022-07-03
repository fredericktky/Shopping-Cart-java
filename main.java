import java.util.Scanner; //input
import java.util.ArrayList; //array


public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double totalcost = 0; //variable
        double gst = 3;
        int x = 0;
        Boolean promo= false;
        String promocode= "P10";
        Double promoDiscount= 10.0;

        ArrayList<String> Itemslist = new ArrayList<>(); //array
        ArrayList<Double> ItemsPrice = new ArrayList<>();
        ArrayList<Integer> ItemsQuantity = new ArrayList<>();

        System.out.println("Welcome to Shopping Cart Calculator"); //Welcome

        while (x == 0) {
            System.out.println("New item? (y/n)"); //Check add new/ not
            String Newitem = scanner.next();
                if (Newitem.equals("y")){
                    System.out.println("Input name"); //Get input of itemname, add to array
                    String itemname = scanner.next();
                    Itemslist.add(itemname);

                    System.out.println("Input price"); //Get input of itemprice, add to array
                    Double price = scanner.nextDouble();
                    ItemsPrice.add(price);

                    System.out.println("Quantity"); //Get input of item quantity, add to array
                    int quantity = scanner.nextInt();
                    ItemsQuantity.add(quantity);

                    Double totalItemPrice= price*quantity; //Calculate total item price
                    totalcost= totalcost+totalItemPrice;
                    System.out.println (itemname +":"+ totalItemPrice);}

                else if (Newitem.equals("n")){
                    System.out.println("Promo code:");
                    String inputPromocode= scanner.next();
                        if (inputPromocode.equals(promocode)){
                            promo=true;
                            System.out.println("Promo code valid");
                        }
                        else{
                            promo=false;
                        }

                    System.out.println("SHOPPING CART SUMMARY"+
                            "\nItem bought:" +Itemslist+
                            "\nItem price:RM"+ItemsPrice+
                            "\nItem Quantity:"+ItemsQuantity);
                        if(promo) {
                            Double priceDeducted = totalcost * promoDiscount / 100;
                            System.out.println("Discount: RM" + priceDeducted);
                        }
                        else{
                            System.out.println("No Discount");
                    }
                    gst= totalcost*gst/100; //Calculate total cart price and exit
                    System.out.println("GST: RM"+gst);
                    totalcost=totalcost+gst;
                    System.out.println("Total cart: RM"+totalcost);
                    x=+1;}
                else{
                    System.out.println("Please enter valid selection");}

        }

    }
}


//add promocode
//sort up code
//better listing
//Item code