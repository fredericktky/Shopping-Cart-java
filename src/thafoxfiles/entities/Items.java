package src.thafoxfiles.entities;

public class Items {
    String itemName;
    Float itemPrice;
    Integer itemQuantity;

    //item list that have in the system
    public Items(String itemName, Float itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    //user that selected the list
    public Items(String itemName, Float itemPrice, Integer itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
