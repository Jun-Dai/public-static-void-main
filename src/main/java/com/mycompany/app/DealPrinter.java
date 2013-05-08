package com.mycompany.app;

import java.util.List;

public class DealPrinter {
    public String createHotelPricesString(Deals deals) {
        StringBuilder sb = new StringBuilder();

        List<Deals.SimpleHotel> hotels = deals.getHotels();
        for (Deals.SimpleHotel hotel : hotels) {
            sb.append(String.format("%30.30s : $%s\n", hotel.name, hotel.price));
        }

        return sb.toString();
    }
}
