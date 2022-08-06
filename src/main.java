import java.lang.reflect.Array;
import java.util.Scanner; //input
import java.util.ArrayList; //array


public class main {
    static ArrayList<String> itemsList = new ArrayList<>();
    static ArrayList<Double> itemsPrice = new ArrayList<>();
    static ArrayList<Integer> itemsQuantity = new ArrayList<>();
    static double price;
    public static void main (String[] args) {
        Scanner scanner= new Scanner(System.in);

        double totalCost=0;
        double GST = 3;
        int x = 0;

        boolean promo;
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
    public static void addcart(String itemname, double itemprice){
        itemsList.add(itemname);
        itemsPrice.add(itemprice);
        price = itemprice;
    }
}
