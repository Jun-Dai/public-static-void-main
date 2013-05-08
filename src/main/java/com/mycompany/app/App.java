package com.mycompany.app;

public class App
{
    public static void main( String[] args ) throws Exception
    {
        String dealsJson = new DealLoader().loadDealJson();
        Deals deals = Deals.parseDeals(dealsJson);
        DealPrinter printer = new DealPrinter();

        System.out.println("Hotel deals:");
        System.out.println(printer.createHotelPricesString(deals));
    }
}
