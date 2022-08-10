package src;

import java.util.ArrayList;
import java.util.Locale;

public class CustomerPortal implements ICoupon {

    /*
    * again think of what customer option have?
    * select item?
    * show item?
    *add to cart?
    * pay ?
    * coupon apply?
    * */

    //hence we initialise the varaible that customer might use first
    private ArrayList<ShopItem> customerItems = new ArrayList<ShopItem>();
    private double payment = 0;
    private boolean isPaid = false;

    private String coupon = null;
    //why private? in some cases, if you have the data is very sensitive you dont want people to
    //edit or sabotage your variable, we use getter & setter to prevent data being abuse
    //private variable only can be accessible to the class itself

    //to allow customer to put in their items
    void itemsCustomerSelect(ShopItem shopItem){
        //might have some logic error so we can do some error handling here
        customerItems.add(shopItem);
    }

    void itemCustomerDelete(String itemName){
        //to remove the index in the customerItems
        for(int i = 0; i < customerItems.size(); i++){
            if(itemName == customerItems.get(i).getName()){
                customerItems.remove(i);
            }
        }
    }

    ArrayList<ShopItem> showShoppingCart(){
        return customerItems;
    }

    //get the total price
    public double getPayment() {
        double payment = 0.00;
        for(ShopItem item: customerItems){
            payment += (item.getPrice() * item.getQuantity());
        }
        System.out.println("Original price: " + payment);
        if(coupon == null) {
            //get the total price
            this.payment = payment;
        }else{
            //40% off! you can change it if you want idc
            System.out.println("Coupon is used! Reduced to " + payment * ICoupon.offerDiscount);
            this.payment = payment * ICoupon.offerDiscount;
        }

        return this.payment;
    }

    //pay the price
    public void setPayment(double payment) {

        if(payment > 0 && payment > this.payment){
            //ensure the payment is equal and bigger than 0
            this.payment -= payment;
            this.isPaid = true;
            System.out.println("change: " + String.format("%,.2f", this.payment));
        }else{
            System.out.println("payment failed!");
            this.isPaid = false;
        }
    }

    public String getCoupon() {
        return coupon;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public void setCoupon(String coupon) {
        //set to all lowercase and no space (strip)
        coupon = coupon.toLowerCase().strip();

        for(int i = 0; i < ICoupon.COUPON_REDEEM.length; i++){

            if(coupon.equals(ICoupon.COUPON_REDEEM[i].toLowerCase())){
                this.coupon = coupon;
                System.out.println("Coupon Applied!");
                return;

            }
        }


    }
}
