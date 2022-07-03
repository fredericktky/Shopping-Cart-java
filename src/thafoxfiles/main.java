package src.thafoxfiles;

import src.thafoxfiles.ConsoleColorInterface.IConsoleColourInterface;
import src.thafoxfiles.ConsoleColorInterface.ITaxes;
import src.thafoxfiles.data.ItemsData;
import src.thafoxfiles.entities.Items;
import src.thafoxfiles.tools.CalculateTotalTools;
import src.thafoxfiles.tools.InputType;
import src.thafoxfiles.tools.ShowFinalList;
import src.thafoxfiles.tools.ShowGroceriesList;

import java.util.ArrayList;
import java.util.Scanner;

import static src.thafoxfiles.ConsoleColorInterface.IPriceFormatter.formatter;

public class main implements IConsoleColourInterface {


    public static void main (String args[]){

        Scanner scanner = new Scanner(System.in);
        Integer selection, indexGroceries, quantity  = null;
        Boolean isPurchase = false;
        ArrayList<Items> itemList = new ItemsData().getItemsList();
        ArrayList<Items> purchaseList = new ArrayList<Items>();




        while(isPurchase == false){

            System.out.println("Please select your option: \n" +
                    "1: show groceries list \n" +
                    "2: Show total\n" +
                    "3: show your cart \n" +
                    "4: purchase \n");
            System.out.println("Your option");
            selection = new InputType().GetInputInteger();

            switch (selection){
                case 1:
                    ShowGroceryList(itemList, "%5s %33s %15s");
                    System.out.println("Please select the item you want to purchase");
                    System.out.print("Selection here: ");

                    do {
                        indexGroceries = new InputType().GetInputInteger();
                        //if the list is not exist show error and retype it
                        if(indexGroceries > itemList.size() - 1){

                            ShowConsoleCode(RED + "ITEM DOES NOT EXIST, PLEASE CHOOSE AGAIN.");

                        }
                    }while(indexGroceries > itemList.size() - 1);
//                    if the index is bigger than the arraylist size then repeat cause is not in the
//                    list already
                    ShowConsoleCode(GREEN + " Selected " + itemList.get(indexGroceries).getItemName());
                    System.out.println("Quantity for the grocery");
                    do {
                        quantity = new InputType().GetInputInteger();
                        if(quantity < 0){
                            ShowConsoleCode(RED + "UNABLE TO HAVE QUANTITY LESS THAN 0");
                        }
                    }while(quantity < 0 );
//                    quantity cannot be lower than 0
                    purchaseList.add(new Items(itemList.get(indexGroceries).getItemName(), itemList.get(indexGroceries).getItemPrice(), quantity));
                    ShowConsoleCode(GREEN + itemList.get(indexGroceries).getItemName() + " GROCERY ADDED SUCCEFFULLY!");


                    break;
                case 2:
                    System.out.println("this is just a test, you can change if you want the behaviour");

                    if(!purchaseList.isEmpty()){
                        CalculateTotalTools calculateTotalTools = new CalculateTotalTools();
                        ShowConsoleCode("RM " + formatter.format(calculateTotalTools.getTotalPrice(purchaseList)));

                    }else{
                        ShowConsoleCode(YELLOW_BOLD + "No items in cart");
                    }

                    break;
                case 3:
                    if(!purchaseList.isEmpty()) {
                        ShowGroceryList(purchaseList, "%5s %33s %15s %15s");
                        ShowConsoleCode(YELLOW + "TAX PERCENTAGE: " + ITaxes.taxPercentage);
                        CalculateTotalTools calculateTotalTools = new CalculateTotalTools();
                        ShowConsoleCode("RM " + formatter.format(calculateTotalTools.getTotalPrice(purchaseList)));
                    }else{
                        ShowConsoleCode(YELLOW_BOLD + "No items in cart");
                    }

                    break;
                case 4:
                    if(!purchaseList.isEmpty()) {
                        ShowFinalList(purchaseList, "%5s %33s %15s %15s %25s");

                    }else{
                        ShowConsoleCode(YELLOW_BOLD + "No items in cart");
                    }

                    break;

                default:
                    ShowConsoleCode(YELLOW_BOLD + "No such selection, please select again");

                    break;

            }
        }



    }

    public static void ShowConsoleCode(String RED) {
        System.out.println("________________________________");
        System.out.println(RED);
        System.out.print(RESET);
        System.out.println("________________________________");
    }

    private static void ShowGroceryList(ArrayList<Items> itemList,String tableFormat ) {
        ShowGroceriesList showGroceryList = new ShowGroceriesList();
        showGroceryList.ShowGroceryList(itemList, tableFormat);
    }

    private static void ShowFinalList(ArrayList<Items> itemList,String tableFormat ) {
        ShowFinalList showFinalList = new ShowFinalList();
        showFinalList.ShowGroceryList(itemList, tableFormat);
    }

}
