import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SearchCoin {

    public double searchRate(String coins){
        URI dir = URI.create("https://v6.exchangerate-api.com/v6/4c00c785ad086fc423d73982/pair/" + coins );

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(dir)
                .build();
        try{
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            String json = response.body();
            Money listMoney = gson.fromJson(json, Money.class);
            return listMoney.conversion_rate();
        } catch (Exception e){
            throw new RuntimeException("API fuera de servicio");
        }

    }

}
