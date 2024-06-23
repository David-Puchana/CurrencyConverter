import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import com.google.gson.Gson;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Gson gson = new Gson();
        String url_str = "https://v6.exchangerate-api.com/v6/4c00c785ad086fc423d73982/pair/COP/EUR";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url_str))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);

        Money listMoney = gson.fromJson(json, Money.class);
        // float rate = listMoney.getRate("USD");
        System.out.println(listMoney.conversion_rates());

    }
}
