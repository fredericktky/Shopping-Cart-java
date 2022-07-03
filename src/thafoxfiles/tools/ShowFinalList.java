package src.thafoxfiles.tools;

import src.thafoxfiles.ConsoleColorInterface.ITaxes;
import src.thafoxfiles.entities.Items;

import java.util.ArrayList;

import static src.thafoxfiles.ConsoleColorInterface.IConsoleColourInterface.YELLOW_BOLD;
import static src.thafoxfiles.ConsoleColorInterface.IPriceFormatter.formatter;
import static src.thafoxfiles.main.ShowConsoleCode;

public class ShowFinalList extends ShowGroceriesList {

    @Override
    public void ShowGroceryList(ArrayList<Items> itemList, String tableFormat ) {
        //in the format %means the column space, number is the space width,
        // s means string type (best use all s to prevent error)
//        String tableFormat = "%5s %33s %15s"; fix a bit
        if(!itemList.isEmpty()) {

            System.out.format(tableFormat, "No.", "Grocery Name", "Price (RM)", "Quantity", "Total Price Per Quantity");
            System.out.println();
            System.out.println("______________________________________________________");
            for (int i = 0; i < itemList.size(); i++) {
                //this is a bad pratice and a better solution can be solve by shifting into another class with extend
                String pricePerItem = "";
                if(itemList.get(i).getItemQuantity() != null) {
                    pricePerItem = formatter.format(new CalculateTotalTools().getPricePerItem(itemList.get(i)));
                }
                System.out.format(
                        tableFormat,
                        i,
                        itemList.get(i).getItemName(),
                        formatter.format(itemList.get(i).getItemPrice()),
                        itemList.get(i).getItemQuantity(),
                        pricePerItem
                );

                System.out.println();
            }
            System.out.println("______________________________________________________");
            System.out.println("Tax percentage: " + ITaxes.taxPercentage);
            System.out.println("______________________________________________________");
            System.out.format("%15s", "Total Price: ");
            System.out.format("%15s", formatter.format(new CalculateTotalTools().getTotalPrice(itemList)));
            System.out.println();

        }else{
            ShowConsoleCode(YELLOW_BOLD + "No items in cart");
        }
    }

}
