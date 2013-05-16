package com.mycompany.app;

import java.util.List;

public class DealPrinter {
    public String createHotelPricesString(Deals deals) {
        StringBuilder sb = new StringBuilder();

        List<Deals.SimpleHotel> hotels = deals.getHotels();
        //List<Deals.SimpleHotel> hotels = deals.getHotelsByCity("Istanbul");
        for (Deals.SimpleHotel hotel : hotels) {
            sb.append(String.format("%30.30s, %20.20s : $%7.2f\n", hotel.name, hotel.city, hotel.price));
        }

        return sb.toString();
    }
}
