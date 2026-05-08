package fakestoreapi.com.builders;

import fakestoreapi.com.models.ProductRequest;

public class ProductBuilder {
    
    private ProductRequest product;

    public ProductBuilder() {

        product = new ProductRequest();

        product.title = "FelixFelicius";
        product.price = 0.666F;
        product.description = "Felix Felicis, also called 'Liquid Luck'," + 
                        " was a potion that made the drinker lucky for a period of time," + 
                        " during which everything they attempt would be successful." + 
                        " It turned an ordinary day into an extraordinary one. It was very difficult to make," + 
                        " disastrous if made wrong, and required six months to brew before it was ready to be consumed";
        product.category = "Potion";
        product.image = "http://example.com";
    }

    public static ProductBuilder product() {
        return new ProductBuilder();
    }

    public ProductBuilder id(int id) {      
        product.id = id;
        return this;
    }

    public ProductBuilder title(String title) {
        product.title = title;
        return this;
    }

    public ProductBuilder price(float price) {
        product.price = price;
        return this;
    }

    public ProductBuilder description(String description) {
        product.description = description;
        return this;
    }

    public ProductBuilder category(String category) {
        product.category = category;
        return this;
    }

    public ProductBuilder image(String image) {
        product.image = image;
        return this;
    }

    public ProductRequest build() {
        return product;
    }
}
