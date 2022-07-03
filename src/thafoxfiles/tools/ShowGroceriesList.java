package src.thafoxfiles.tools;

import src.thafoxfiles.entities.Items;

import java.util.ArrayList;

import static src.thafoxfiles.ConsoleColorInterface.IConsoleColourInterface.YELLOW_BOLD;
import static src.thafoxfiles.ConsoleColorInterface.IPriceFormatter.formatter;
import static src.thafoxfiles.main.ShowConsoleCode;

public class ShowGroceriesList {

     public void ShowGroceryList(ArrayList<Items> itemList, String tableFormat ) {
        //in the format %means the column space, number is the space width,
        // s means string type (best use all s to prevent error)
//        String tableFormat = "%5s %33s %15s"; fix a bit
        if(!itemList.isEmpty()) {

            System.out.format(tableFormat, "No.", "Grocery Name", "Price (RM)", "Quantity");
            System.out.println();
            System.out.println("______________________________________________________");
            for (int i = 0; i < itemList.size(); i++) {

                System.out.format(
                        tableFormat,
                        i,
                        itemList.get(i).getItemName(),
                        formatter.format(itemList.get(i).getItemPrice()),
                        itemList.get(i).getItemQuantity()

                );

                System.out.println();
            }
            System.out.println("______________________________________________________");
        }else{
            ShowConsoleCode(YELLOW_BOLD + "No items in cart");
        }
    }



}


