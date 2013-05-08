package com.mycompany.app;


import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DealLoader {
    private static final String HOTEL_DEALS_URL = "http://deals.expedia.com/beta/deals/hotels.json";

    public String loadDealJson() {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(HOTEL_DEALS_URL);
        httpGet.addHeader("accept", "application/json");

        HttpResponse response = null;
        String deals = null;
        try {
            response = httpClient.execute(httpGet);


            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            deals = IOUtils.toString(br);
        } catch (IOException e) {
            throw new RuntimeException("Unable to fetch deals: ", e);
        }

        httpClient.getConnectionManager().shutdown();
        return deals;
    }
}
