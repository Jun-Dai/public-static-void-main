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
        Double oldPrice = 0.00;
        String sortDirection = "none";
        String prevSortDirection =  "none";

        for (int i = 0; i < orderedHotels.size(); i++)
        {

            if(i > 0)
            {
                prevSortDirection = sortDirection;

                if(orderedHotels.get(i).price > oldPrice)
                {
                    sortDirection = "ascending";
                }
                else if(orderedHotels.get(i).price < oldPrice)
                {
                    sortDirection = "descending";
                }
                else
                {
                    sortDirection = "none";
                }
                //assign the current item on the list to string variable for comparison with next item in next loop
                oldPrice = orderedHotels.get(i).price;

                //if there are 3 or more items in the list then compare the previous comparisons i.e. is the list still ascending or descending
                if(i > 1)
                {
                    //we have more than 3 items in the list so we can test for sorting
                    if(!prevSortDirection.equals(sortDirection))
                    {
                        //will be false because list has been confirmed as not in order
                        //i can test that the test will pass here by changing to !prevSort... need to change in later assert too
                        Assert.assertTrue(prevSortDirection.equals(sortDirection));
                    }
                }
            }
            else
            {
                prevSortDirection = sortDirection;
                oldPrice = orderedHotels.get(i).price;
            }

        }
        //test has completed successfully as loop has completed without an error being thrown
        //change to !prevsort... to confirm test is working
        Assert.assertTrue(prevSortDirection.equals(sortDirection));
    }
}
