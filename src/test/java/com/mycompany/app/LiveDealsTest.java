package com.mycompany.app;

import junit.framework.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LiveDealsTest {

    @Test
    public void testDealsCanBeLoadedAndParsed() throws IOException {
        String dealsJson = new DealLoader().loadDealJson();
        Deals deals = Deals.parseDeals(dealsJson);
        Assert.assertTrue(deals.getHotels().size() > 0);
    }

    @Test
    public void testDealsAreOrderedByPrice() throws IOException {
        String dealsJson = new DealLoader().loadDealJson();
        Deals deals = Deals.parseDeals(dealsJson);
        List<Deals.SimpleHotel> orderedHotels = deals.getHotelsOrderedByPrice();

        // Loop through the orderedHotels and assert that they are in order of price.
    }
}
