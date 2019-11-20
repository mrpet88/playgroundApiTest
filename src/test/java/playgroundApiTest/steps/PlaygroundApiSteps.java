package playgroundApiTest.steps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import org.assertj.core.api.SoftAssertions;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;

import static playgroundApiTest.PlaygroundEndPoints.PRODUCTS;

public class PlaygroundApiSteps {
    private ProductBody productBody = new ProductBody();
    private SoftAssertions softly = new SoftAssertions();
    private RequestSpecBuilder builder = new RequestSpecBuilder();
    private RequestSpecification requestSpec;
    private JSONObject product;
    private Response res;

    public void buildUrl(boolean isPostRequest) {
        builder.setBaseUri(PRODUCTS.getUrl());
        builder.setContentType("application/json");
        if (isPostRequest) {
            product = productBody.createProduct();
            builder.setBody(product);
        }
        requestSpec = builder.build();
        requestSpec = SerenityRest.given().spec(requestSpec);
    }

    public void postProductDetails() {
        res = requestSpec.when().post();
    }

    public void deleteProduct() {
        product = productBody.readFile("product.json");
        res = requestSpec.when().delete(PRODUCTS.getUrl() + "{productDetails}", product.get("id"));
    }


    public void getProductDetails() {
        product = productBody.readFile("product.json");
        res = requestSpec.when().get((("?name=" + product.get("name"))));
    }

    public void setPatchBody() {
        product = productBody.readFile("product.json");
        JSONObject updatedProduct = productBody.createUpdatedProduct();
        res = requestSpec.when().
                patch(PRODUCTS.getUrl() + "{productDetails}", product.get("id"));
    }

    public void validateResponseStatus(int expectedStatus) {
        Assert.assertEquals(expectedStatus, res.statusCode());
    }

    public void validateExistingProduct() {
        ArrayList data = res.then().extract().path("data");
        HashMap hashMap = (HashMap) data.get(0);

        softly.assertThat(200).as("status code").isEqualTo(res.getStatusCode());
        softly.assertThat(hashMap.get("name")).as("product name").isEqualTo(product.get("name"));
        softly.assertThat(hashMap.get("price").toString()).as("product price").isEqualTo(product.get("price").toString());
        softly.assertThat((hashMap.get("upc"))).as("product upc").isEqualTo(product.get("upc"));

        JSONObject responseBody = new JSONObject(hashMap);
        new ProductBody().writeToFile(responseBody, "product.json");

        softly.assertAll();
    }


}
