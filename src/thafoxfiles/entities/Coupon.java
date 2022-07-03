package src.thafoxfiles.entities;

public class Coupon {

    String couponCode;
    Float discountPercentage;

    public Coupon(String couponCode, Float discountPercentage) {
        this.couponCode = couponCode;
        this.discountPercentage = discountPercentage;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
