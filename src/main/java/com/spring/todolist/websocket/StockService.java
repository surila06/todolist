package com.spring.todolist.websocket;

import org.json.JSONException;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.json.JSONObject;

@Service
public class StockService {

    private final String API_KEY = "C2U1OBG2MR47QN76";
    private final String BASE_URL = "https://www.alphavantage.co/query";

    public JSONObject getStockData(String symbol) throws JSONException {
        String url = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("function", "TIME_SERIES_INTRADAY")
                .queryParam("symbol", symbol)
                .queryParam("interval", "1min")
                .queryParam("apikey", API_KEY)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        return new JSONObject(response);
    }
}
