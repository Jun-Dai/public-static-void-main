package com.mycompany.app;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Deals {
    private final List<Map<String, Object>> deals;

    public Deals(List<Map<String, Object>> deals) {
        this.deals = deals;
    }

    public List<SimpleHotel> getHotels() {
        List<SimpleHotel> hotels = new ArrayList<SimpleHotel>();
        for (Map<String, Object> deal : deals) {
            hotels.add(new SimpleHotel(deal));
        }

        return hotels;
    }

    public List<SimpleHotel> getHotelsOrderedByPrice() {
        return getHotels();
    }

    public static Deals parseDeals(String json) {
        return new Deals((List<Map<String, Object>>) new Gson().fromJson(json, List.class));
    }

    public class SimpleHotel {
        public final String name;
        public final Double price;

        public SimpleHotel(Map<String, Object> hotelDeal) {
            name = (String) hotelDeal.get("name");
            price = (Double) hotelDeal.get("totalRate");
        }
    }
}
