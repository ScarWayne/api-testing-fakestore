package fakestoreapi.com.specification;

import java.util.Map;

import fakestoreapi.com.builders.ProductBuilder;
import fakestoreapi.com.data.ProductBodyFactory;
import fakestoreapi.com.models.ProductRequest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class RequestSpecifications {

    public static final RequestSpecification baseRequestSpec = 
        new RequestSpecBuilder()
            .setBaseUri("https://fakestoreapi.com")
            .build();

    public static final RequestSpecification jsonRequestSpec = 
        new RequestSpecBuilder()
            .setBaseUri("https://fakestoreapi.com")
            .setContentType(ContentType.JSON)
            .build();
    
    public static final RequestSpecification getProductsRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(baseRequestSpec)
            .setBasePath("/products")
            .build();
    }

    public static final RequestSpecification getIncorrEndpointProdRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(baseRequestSpec)
            .setBasePath("/productssssssss")
            .build();
    }

    public static final RequestSpecification getLimitProductRequestSpec(int limit) {
        return new RequestSpecBuilder()
            .addRequestSpecification(getProductsRequestSpec())
            .addQueryParam("limit", limit)
            .build();
    }
    
    public static final RequestSpecification getLimitProductRequestSpec(String limit) {
        return new RequestSpecBuilder()
            .addRequestSpecification(getProductsRequestSpec())
            .addQueryParam("limit", limit)
            .build();
    }

    public static final RequestSpecification postNewProductRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(ProductBuilder.product().build())
            .build();
    }

    public static final RequestSpecification postProductWithOwnIdRequestSpec(ProductRequest productWithOwnId) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(productWithOwnId)
            .build();
    }

    public static final RequestSpecification postProductWithoutBodyRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .build();
    }

    public static final RequestSpecification postProductEmpthyBodyRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody("{}")
            .build();
    }

    public static final RequestSpecification postProductEmpthyTitleRequestSpec(ProductRequest productWithEmpthyTitle) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(productWithEmpthyTitle)
            .build();
    }

    public static final RequestSpecification postProductNumbsTitleRequestSpec(Map<String, Object> bodyIsNumbs) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(bodyIsNumbs)
            .build();
    }

    public static final RequestSpecification postProductEmpthyPriceRequestSpec() {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(ProductBodyFactory.productWithEmptyPriceJson())
            .build();
    }

    public static final RequestSpecification postProductNegativePriceRequestSpec(ProductRequest productWithNegativePrice) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(productWithNegativePrice)
            .build();
    }

    public static final RequestSpecification postProductPriceWordRequestSpec(Map<String, Object> bodyWord) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(bodyWord)
            .build();
    }

    public static final RequestSpecification postProductEmpthyCategoryRequestSpec(ProductRequest productWithEmpthyCategory) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(productWithEmpthyCategory)
            .build();
    }

    public static final RequestSpecification postProductNumberCategoryRequestSpec(Map<String, Object> bodyWithNumberCategory) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(bodyWithNumberCategory)
            .build();
    }

    public static final RequestSpecification postProductWithRandomFieldRequestSpec(Map<String, Object> bodyWithRandomField) {
        return new RequestSpecBuilder()
            .addRequestSpecification(jsonRequestSpec)
            .setBasePath("/products")
            .setBody(bodyWithRandomField)
            .build();
    }
}