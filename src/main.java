import java.util.ArrayList; //array
import java.util.Scanner;

public class main {

    static ArrayList<String> itemsList = new ArrayList<>();
    static ArrayList<Double> itemsPrice = new ArrayList<>();
    static ArrayList<String> CartList = new ArrayList<>();
    static ArrayList<Double> CartPrice = new ArrayList<>();
    static ArrayList<Integer> CartQuantity = new ArrayList<>();


    public static void main(String[] args) {
        itemsList.add("Cake");
        itemsPrice.add(2.30);
        itemsList.add("Bread");
        itemsPrice.add(2.50);
        itemsList.add("Kaya");
        itemsPrice.add(1.50);
        itemsList.add("Cheese");
        itemsPrice.add(3.50);
        itemsList.add("Yogurt");
        itemsPrice.add(3.10);
        itemsList.add("Grapes");
        itemsPrice.add(10.00);


        Scanner scanner = new Scanner(System.in);

        Welcome();

        boolean newItem = true;
        int itemsListIndex = 0;
        int itemsListMaxIndex = itemsList.size();
        double GST = 3;
        String promoCode= "P10";
        double promoDiscount= 10.0;


        while (newItem) {
            System.out.println("New Item? (y/n)");
            String userReply = scanner.next();
            if (userReply.equals("y")) {
                System.out.println("Choose item number:");
                int userInputNumber = scanner.nextInt();
                addToCart(scanner, userInputNumber);
            }
            else if (userReply.equals("n")) {
                newItem = false;
                printCart();
                double totalPrice = calculateTotalPrice();
                System.out.println("Total Price: RM"+ totalPrice);
                double GSTcost= addGST(GST);
                System.out.println("GST: RM" + GSTcost);
                double totalPriceWithGST= totalPrice+GSTcost;
                System.out.println("Total Price with GST: RM" + totalPriceWithGST);

            } else {
                System.out.println("Please Input Correct Selection");
            }

        }
    }
    public static void Welcome() {
        System.out.println("Welcome to Shopping Mall XX");
        System.out.println("Item sold here:");
        int itemsListIndex = 0;
        int itemsListMaxIndex = itemsList.size();
        while (itemsListIndex < itemsListMaxIndex) {
            System.out.println(itemsListIndex +"  "+ itemsList.get(itemsListIndex) + ":    RM" + itemsPrice.get(itemsListIndex));
            itemsListIndex += 1;
        }
    }
    public static void addToCart(Scanner scanner , int itemsListIndex){
        CartList.add(itemsList.get(itemsListIndex));
        CartPrice.add(itemsPrice.get(itemsListIndex));
        System.out.println("Quantity:");
        CartQuantity.add(scanner.nextInt());
    }
    public static double calculateTotalPrice() {
        double totalPrice = 0.00;
        double itemPrice;
        int cartMaxIndex = CartList.size();
        for (int cartIndex = 0;cartIndex<cartMaxIndex; cartIndex+=1) {
            itemPrice = CartPrice.get(cartIndex) * CartQuantity.get(cartIndex);
            totalPrice = totalPrice+itemPrice;
        }
        return totalPrice;
    }
    public static void printCart() {
        System.out.println("SHOPPING CART SUMMARY" +
                "\nItem bought:" + CartList +
                "\nItem price:RM" + CartPrice +
                "\nItem Quantity:" + CartQuantity);
    }
    public static boolean promotion(Scanner scanner, String promoCode) {
        System.out.println("Promo code:");
        String inputPromoCode= scanner.next();
        boolean validPromo;
        if (inputPromoCode.equals(promoCode)){
            validPromo=true;
            System.out.println("Promo code valid");
        }
        else{
            validPromo=false;
        }
        return validPromo;
    }
    public static double addGST (double GST){
        return calculateTotalPrice()*GST/100;
    }
}
