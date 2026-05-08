package fakestoreapi.com.tests;

import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fakestoreapi.com.builders.ProductBuilder;
import fakestoreapi.com.data.ProductBodyFactory;
import fakestoreapi.com.models.ProductRequest;
import fakestoreapi.com.specification.RequestSpecifications;
import fakestoreapi.com.specification.ResponseSpecifications;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductsTest {
    
    @Test
    @Order(1)
    @DisplayName("Получить список всех продуктов")
    public void getAllProducts() {
        
        given(RequestSpecifications.getProductsRequestSpec())
            .get()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.getJsonProductsListResponseSpec);            
    }

    @Test
    @Order(2)
    @DisplayName("Получить список из 4 продуктов")
    public void getFourProducts() {

        given(RequestSpecifications.getLimitProductRequestSpec(4))                  
            .get()
            .then()
            //.log().body()
                .spec(ResponseSpecifications.getLimitProductsListResponseSpec(4));               
    }

    @Test
    @Order(3)
    @DisplayName("Получить все продукты с некорректным эндпоинтом")
    public void getProductsWithIncorrectEndpoint() {

        given(RequestSpecifications.getIncorrEndpointProdRequestSpec())
            .get()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.getFailureIncorUriResponseSpec);
    }

    @Test
    @Order(4)
    @DisplayName("Получить продукты с некорректным лимитом")
    public void getProductsWithIncorrectLimit() {

        given(RequestSpecifications.getLimitProductRequestSpec("ABC"))
            .get()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.getProductsListResponseSpec);            
    }

    @Test
    @Order(5)
    @DisplayName("Добавить новый продукт")
    public void addNewProduct() {
     
        given(RequestSpecifications.postNewProductRequestSpec())          
            .post()
            .then()
                //.log().all()
                .spec(ResponseSpecifications.postSuccessFieldsResponseSpec);         
    }

    @Test
    @Order(6)
    @DisplayName("Добавить новый продукт с собственным ID")
    public void addNewProductWithOwnId() {

        ProductRequest productWithOwnId = ProductBuilder.product()
            .id(77)
            .build();

        given(RequestSpecifications.postProductWithOwnIdRequestSpec(productWithOwnId))          
            .post()        
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postProductWithOwnIdResponseSpec(77));
            
    }

    //@Disabled
    @Test
    @Order(7)
    @DisplayName("Добавить новый продукт без Body")
    public void addNewProductWithoutBody() {

        given(RequestSpecifications.postProductWithoutBodyRequestSpec())            
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(8)
    @DisplayName("Добавить новый продукт с пустым Body")
    public void addNewProductWithEmptyBody() {

        given(RequestSpecifications.postProductEmpthyBodyRequestSpec())            
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(9)
    @DisplayName("Добавить новый продукт с пустым полем 'Название'")
    public void addNewProductWithEmptyTitle() {

       ProductRequest productWithEmpthyTitle = ProductBuilder.product()
            .title("")
            .build();

        given(RequestSpecifications.postProductEmpthyTitleRequestSpec(productWithEmpthyTitle))           
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(10)
    @DisplayName("Добавить новый продукт с цифрами в поле 'Название'")
    public void addNewProductWithNumberInTitle() {

        Map<String, Object> bodyIsNumbs = ProductBodyFactory.defaultProduct();
        bodyIsNumbs.put("title", 123);
        
        given(RequestSpecifications.postProductNumbsTitleRequestSpec(bodyIsNumbs))            
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(11)
    @DisplayName("Добавить новый продукт с пустым полем 'Цена'")
    public void addNewProductWithEmpthyPrice() {

        given(RequestSpecifications.postProductEmpthyPriceRequestSpec())
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(12)
    @DisplayName("Добавить новый продукт с отрицательным значением в поле 'Цена'")
    public void addNewProductWithNegativePrice() {

       ProductRequest productWithNegativePrice = ProductBuilder.product()
            .price(-555F)
            .build();

        given(RequestSpecifications.postProductNegativePriceRequestSpec(productWithNegativePrice))
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(13)
    @DisplayName("Добавить новый продукт с буквенным значением в поле 'Цена'")
    public void addNewProductWithStringPrice() {

        Map<String, Object> bodyWord = ProductBodyFactory.defaultProduct();
        bodyWord.put("price", "fifty five");

        given(RequestSpecifications.postProductPriceWordRequestSpec(bodyWord))
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(14)
    @DisplayName("Добавить новый продукт с пустым полем 'Категория'")
    public void addNewProductWithEmpthyCategory() {

        ProductRequest productWithEmpthyCategory = ProductBuilder.product()
            .category("")
            .build();

        given(RequestSpecifications.postProductEmpthyCategoryRequestSpec(productWithEmpthyCategory))            
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    //@Disabled
    @Test
    @Order(15)
    @DisplayName("Добавить новый продукт с цифровым значением в поле 'Категория'")
    public void addNewProductWithNumberCategory() {

        Map<String, Object> bodyWithNumberCategory = ProductBodyFactory.defaultProduct();
        bodyWithNumberCategory.put("category", 12345);

        given(RequestSpecifications.postProductNumberCategoryRequestSpec(bodyWithNumberCategory))            
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postFailureResponseSpec);
    }

    @Test
    @Order(16)
    @DisplayName("Добавить новый продукт с новым дополнительным полем")
    public void addNewProductWithNewField() {

        Map<String, Object> bodyWithRandomField = ProductBodyFactory.defaultProduct();
            bodyWithRandomField.put("random_field", "blablabla");

        given(RequestSpecifications.postProductWithRandomFieldRequestSpec(bodyWithRandomField))
            .post()
            .then()
                //.log().body()
                .spec(ResponseSpecifications.postProductWithRandomFieldResponseSpec("random_field"));
    }
}
