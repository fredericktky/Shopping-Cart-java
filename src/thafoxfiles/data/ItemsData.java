package src.thafoxfiles.data;

import src.thafoxfiles.entities.Items;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsData {

    public ArrayList<Items> getItemsList() {

        return new ArrayList<Items>(
                Arrays.asList(
                        new Items("Ferrari Roma", 1900000.20f),
                        new Items("Lamboghini SVJ", 1200000.90f),
                        new Items("Proton Exora", 69000.20f),
                        new Items("Perodua Axia E", 22000f),
                        new Items("Mercedes Benz e350", 220000.20f),
                        new Items("BMW M5 e36", 858000.20f),
                        new Items("Toyota MK5 GR Supra 2023", 420000.00f),
                        new Items("BMW M2 Competition", 280000f),
                        new Items("Lotus Emira", 2000000f),
                        new Items("Bentely W12 continental GT", 969000f),
                        new Items("Mclaren 720s Spyder", 800000f)
                ));
    }


}
