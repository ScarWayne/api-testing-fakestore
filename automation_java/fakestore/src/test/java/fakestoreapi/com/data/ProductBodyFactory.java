package fakestoreapi.com.data;

import java.util.HashMap;
import java.util.Map;

public class ProductBodyFactory {
    public static Map<String, Object> defaultProduct() {

        Map<String, Object> body = new HashMap<>();

        body.put("title", "FelixFelicius");
        body.put("price", 0.666F);
        body.put("description", "Felix Felicis, also called 'Liquid Luck'," + 
                        " was a potion that made the drinker lucky for a period of time," + 
                        " during which everything they attempt would be successful." + 
                        " It turned an ordinary day into an extraordinary one. It was very difficult to make," + 
                        " disastrous if made wrong, and required six months to brew before it was ready to be consumed");
        body.put("category", "Potion");
        body.put("image", "http://example.com");

        return body;
    }

    public static final String productWithEmptyPriceJson() {
        String body = "{\"title\":\"FelixFelicius\"," +
                "\"price\":," +
                "\"description\":\"Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, " +
                "during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. " +
                "It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed\"," +
                "\"category\":\"Potion\"," +
                "\"image\":\"http://example.com\"}";
                
        return body;        
    }
}
