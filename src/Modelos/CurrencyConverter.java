package Modelos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyConverter {

    public ConversionRate getConversionRate(String baseCode, String targetCode) {
        String APIKEY = "8795cb823fe53d433d89d239";
        URI direction = URI.create("https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/" + baseCode + "/" + targetCode);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direction).build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            return new Gson().fromJson(json, ConversionRate.class);
        } catch (Exception e) {
            System.out.println("Something wrong happened");


        }

        return null;
    }
}
