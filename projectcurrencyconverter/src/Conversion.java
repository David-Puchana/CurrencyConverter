import java.util.HashMap;
import java.util.Map;

public class Conversion {
    public String conversion(int option){
        Map<Integer, String> mapCoins = new HashMap<>();

        mapCoins.put(1,"USD/COP");
        mapCoins.put(2,"COP/USD");
        mapCoins.put(3,"EUR/COP");
        mapCoins.put(4,"COP/EUR");
        mapCoins.put(5,"CLP/COP");
        mapCoins.put(6,"COP/CLP");

        return mapCoins.get(option);
    }
}
