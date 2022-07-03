package src.thafoxfiles.tools;

import src.thafoxfiles.ConsoleColorInterface.ITaxes;
import src.thafoxfiles.entities.Items;

import java.util.ArrayList;

public class CalculateTotalTools implements ITaxes {

    public Double getTotalPrice(ArrayList<Items> itemList){

        Double total = 0d;
        for(Items item: itemList){
            total += (item.getItemPrice() * ITaxes.taxPercentage )* item.getItemQuantity() ;
        }
        return total;

    }

    public Double getPricePerItem(Items item){

        Double total = 0d;

        total += (item.getItemPrice() * ITaxes.taxPercentage )* item.getItemQuantity() ;

        return total;

    }
}
