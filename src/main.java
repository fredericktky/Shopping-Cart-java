import java.util.Scanner; //input
import java.util.ArrayList; //array


public class main {
    static ArrayList<String> itemsList;
    static ArrayList<Double> itemsPrice;
    static ArrayList<Integer> itemsQuantity;
    static double price;
    public static void main (String[] args) {
        Scanner scanner= new Scanner(System.in);

        double totalCost=0;
        double GST = 3;
        int x = 0;

        String promoCode= "P10";
        double promoDiscount= 10.0;


        //items
        String item1 = "Cake";
        double priceitem1 = 3;
        String item2 = "Bread";
        double priceitem2 = 2;
        String item3 = "Kaya";
        double priceitem3 = 1.5;


        System.out.println("Welcome to Shopping Cart Calculator");
        System.out.println("Item: Cake RM3 , Bread RM2, Kaya RM1.5");

        while( x==0 ){
            System.out.println("New item? (y/n)"); //Check add new/ not
            String Newitem = scanner.next();
            if (Newitem.equals("y")){
                System.out.println("Input name");
                String itemname = scanner.next();

                if (itemname.equals(item1)) {
                    addcart(item1,priceitem1);
                }
                else if (itemname.equals(item2)) {
                    addcart(item2,priceitem2);
                }
                else if (itemname.equals(item3)) {
                    addcart(item3,priceitem3);
                }
                else {
                    System.out.println("Please insert valid selection");
                    break;
                }


                System.out.println("Quantity"); //Get input of item quantity, add to array
                int quantity = scanner.nextInt();
                itemsQuantity.add(quantity);


                double totalItemPrice= price*quantity; //Calculate total item price
                totalCost= totalCost+totalItemPrice;
                System.out.println ("Item: " + itemname
                        + "\nQuantity : "+quantity
                        + "\nTotalPrice:" + totalItemPrice );}


            else if (Newitem.equals("n")){
                Boolean validPromo =validPromo(scanner, promoCode);
                printCart();

                if(validPromo) {
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


    public static void addcart(String itemname, double itemprice){
        itemsList.add(itemname);
        itemsPrice.add(itemprice);
        price = itemprice;
    }


    public static Boolean validPromo(Scanner scanner, String promoCode) {
        System.out.println("Promo code:");
        String inputPromoCode= scanner.next();
        Boolean validPromo;
        if (inputPromoCode.equals(promoCode)){
            validPromo=true;
            System.out.println("Promo code valid");
        }
        else{
            validPromo=false;
        }
        return validPromo;
    }


    public static void printCart(){
        System.out.println("SHOPPING CART SUMMARY"+
                "\nItem bought:" +itemsList+
                "\nItem price:RM"+itemsPrice+
                "\nItem Quantity:"+itemsQuantity);

    }
}