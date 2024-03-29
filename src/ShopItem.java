package src;

import java.util.ArrayList;
import java.util.List;

public class ShopItem {
    //think of this as entity
    //what item should have? name? price? quantity? or something?

    private String name;
    private double price;
    private int quantity;

    //this constructor is to set the default value if you want to use this class.
    //means if you use this, u must have name, price and quantity
    public ShopItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //this means that your shop doesnt have anything yet, you need to setup later!
    public ShopItem() {
    }

    //    we setup getter and setter (get data and set data)


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price > 0 ){
            //depends on your reference like u want free gift?
            //my case i dont want free items so i need to set this condition to let people know
            //you cannot set price under 0
            this.price = price;
        }else{
            System.out.println("price cannot be set under 0!!");
        }

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 0){
            //maybe item is expired or broken so 0 is possible
            this.quantity = quantity;
        }else{
            System.out.println("quantity cannot set under 0!");
        }

    }

    public ArrayList<ShopItem> getAllStoreItems(){
        //remember arraylist allows you to edit and delete the items, list cannot but if you
        //have list.of in arraylist, these item can be edited!
        return new ArrayList<ShopItem>( List.of(
                new ShopItem("Kaya", 6.50, 12),
                new ShopItem("Butter", 3.50, 25),
                new ShopItem("Bun", 4.50, 25),
                new ShopItem("Honey", 8.50, 25),
                new ShopItem("Peanut", 13.50, 25)
        ));
    }
}



