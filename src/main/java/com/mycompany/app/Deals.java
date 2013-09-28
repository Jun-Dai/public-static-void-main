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

    public List<SimpleHotel> getHotelsByCity(String cityFilter) {

        List<SimpleHotel> hotels = new ArrayList<SimpleHotel>();
        //loop runs for as long as there are deals
        for (Map<String, Object> deal : deals) {

            SimpleHotel hotel = new SimpleHotel(deal);
            //if it finds a deal with a city matching the value in city filter, the deal is added to the array
            if(hotel.city.toLowerCase().equals(cityFilter.toLowerCase()))
            {
                hotels.add(new SimpleHotel(deal));
            }
        }

        return hotels;
    }

    public static Deals parseDeals(String json) {
        return new Deals((List<Map<String, Object>>) new Gson().fromJson(json, List.class));
    }

    public class SimpleHotel {
        public final String name;
        public final Double price;
        public final String city;

        public SimpleHotel(Map<String, Object> hotelDeal) {
            name = (String) hotelDeal.get("name");
            price = (Double) hotelDeal.get("totalRate");
            city = (String) hotelDeal.get("city");
        }
    }
}
