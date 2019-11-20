package playgroundApiTest.steps;

import org.jetbrains.annotations.Nullable;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.yecht.Data;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProductBody {

    public JSONObject productsBody = new JSONObject();
    public JSONObject updatedProductsBody = new JSONObject();

    public int getRandomIntegerBetweenRange(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public JSONObject createProduct() {
        productsBody.put("name", "Product" + getRandomIntegerBetweenRange(1, 1000));
        productsBody.put("type", "Hard");
        productsBody.put("upc", "12345676");
        productsBody.put("price", getRandomIntegerBetweenRange(1, 1000));
        productsBody.put("description", "This is a placeholder request for creating a new product.");
        productsBody.put("model", "NP12345");
        writeToFile(productsBody,"product.json");
        return productsBody;
    }

    public JSONObject createUpdatedProduct() {
        updatedProductsBody.put("name", "NewProduct" + getRandomIntegerBetweenRange(1, 1000));
        updatedProductsBody.put("type", "Soft");
        updatedProductsBody.put("upc", "9876543");
        updatedProductsBody.put("price", getRandomIntegerBetweenRange(1, 1000));
        updatedProductsBody.put("description", "This is a placeholder request for creating a new product.");
        updatedProductsBody.put("model", "NP12345");
        writeToFile(updatedProductsBody, "productChanged.json");
        return updatedProductsBody;
    }

    public void writeToFile(JSONObject data,String fileName) {
        try (FileWriter file = new FileWriter(fileName)) {
            file.write(data.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Nullable
    public JSONObject readFile(String fileName) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(
                    fileName));
            JSONObject productDetails = (JSONObject) obj;

            return productDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
