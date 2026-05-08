package fakestoreapi.com.specification;

import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;


public class ResponseSpecifications {

    public static final ResponseSpecification getSuccessResponseSpec = 
        new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectResponseTime(lessThan(2500L))
            .build();
    
    public static final ResponseSpecification getFailureIncorUriResponseSpec = 
        new ResponseSpecBuilder()
            .expectStatusCode(404)
            .expectResponseTime(lessThan(2500L))
            .build();

    public static final ResponseSpecification productsListBodyResponse = 
        productsListBodyBuilder()
            .build();
    
    private static ResponseSpecBuilder productsListBodyBuilder() {
        return new ResponseSpecBuilder()
            .expectBody("[0].id", notNullValue())
            .expectBody("[0].title", not(emptyOrNullString()))
            .expectBody("price", everyItem(notNullValue()));
    }

    public static final ResponseSpecification jsonBodyResponseSpec = 
        jsonBodyBuilder()
            .build();
    
    private static ResponseSpecBuilder jsonBodyBuilder() {
        return new ResponseSpecBuilder()
            .expectContentType(ContentType.JSON);
    }

    public static final ResponseSpecification getProductsListResponseSpec = 
        new ResponseSpecBuilder()
            .addResponseSpecification(getSuccessResponseSpec)
            .addResponseSpecification(productsListBodyResponse)
            .build();

    public static final ResponseSpecification getLimitProductsListResponseSpec(int limit) {
        return new ResponseSpecBuilder()
            .expectBody("$", hasSize(limit))
            .addResponseSpecification(getProductsListResponseSpec)
            .build();
    }

    public static final ResponseSpecification getJsonProductsListResponseSpec =
        new ResponseSpecBuilder()
            .addResponseSpecification(getSuccessResponseSpec)
            .addResponseSpecification(getProductsListResponseSpec)
            .addResponseSpecification(jsonBodyResponseSpec)
            .build();

    public static final ResponseSpecification postSuccessResponseSpec =
        new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectResponseTime(lessThan(2000L))
            .build();
    
    public static final ResponseSpecification postFailureResponseSpec =
        new ResponseSpecBuilder()
            .expectStatusCode(400)
            .expectResponseTime(lessThan(2000L))
            .build();

    public static final ResponseSpecification postAllfieldsJsonResponseSpec = 
        productFieldsJsonResponseBuilder()
            .build();

    private static ResponseSpecBuilder productFieldsJsonResponseBuilder() {
        return new ResponseSpecBuilder()
            .expectBody("title", equalTo("FelixFelicius"))
            .expectBody("price", equalTo(0.666F))
            .expectBody("description", equalTo("Felix Felicis, also called 'Liquid Luck', was a potion that made the drinker lucky for a period of time, during which everything they attempt would be successful. It turned an ordinary day into an extraordinary one. It was very difficult to make, disastrous if made wrong, and required six months to brew before it was ready to be consumed"))
            .expectBody("category", equalTo("Potion"))
            .expectBody("image", equalTo("http://example.com"))
            .expectContentType(ContentType.JSON);
    }

    public static final ResponseSpecification postSuccessFieldsResponseSpec =
        new ResponseSpecBuilder()
            .addResponseSpecification(postSuccessResponseSpec)
            .addResponseSpecification(postAllfieldsJsonResponseSpec)
            .build();

    public static final ResponseSpecification postProductWithOwnIdResponseSpec(int id) {
        return new ResponseSpecBuilder()
            .expectBody("id", not(equalTo(id)))
            .addResponseSpecification(postSuccessFieldsResponseSpec)
            .build();
    }

    public static final ResponseSpecification postProductWithRandomFieldResponseSpec(String randomField){
        return new ResponseSpecBuilder()
            .expectStatusCode(201)
            .expectContentType(ContentType.JSON)
            .expectBody("$",not(hasKey(randomField)))
            .build();
    }
}

