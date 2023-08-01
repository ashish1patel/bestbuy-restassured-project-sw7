package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;

        response =  given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }
    //21. Extract the limit
@Test
    public void extractTheLimit(){
    int limit = response.extract().path("limit");
    System.out.println(limit);
}
    //22. Extract the total
    @Test
    public void extractTotal() {
        int total = response.extract().path("total");
        System.out.println("The value of total is : " + total);
    }
    //23. Extract the name of 5th product
    @Test
    public void nameOf5thProduct(){
        String productName = response.extract().path("data[4].name");
        System.out.println("The name of 5th product is :"  + productName);
    }
    //24. Extract the names of all the products
    @Test
    public void nameOfAllTheProduct() {
        List<String> allProductName = response.extract().path("data.name");
        System.out.println("The all product name are : " + allProductName);
    }
    //25. Extract the productId of all the products
    @Test
    public void theProductIdOfAllProduct(){
        List<Integer> allProductId =response.extract().path("data.id");
        System.out.println("The productId of all the products are :" + allProductId);
    }
    //26. Print the size of the data list
    @Test
    public void theSizeOfTheDataList(){
        List<Integer> size = response.extract().path("data");
        System.out.println("the size of the data list is :" +size.size());
    }
    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void getAllTheValueOfTheProduct(){
        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println(values);
    }
    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void getTheModelOfTheProduct(){
       List<HashMap<String,?>> modelName = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println(modelName);
    }
    //29. Get all the categories of 8th products
    @Test
    public void getAllCategoriesOf8thStore() {
        List<HashMap<String, ?>> categories = response.extract().path("data[7].categories");
        System.out.println(categories);
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void getAllCategoriesOfProductId150115() {
        List<HashMap<Integer, ?>> categories = response.extract().path("data[3].categories");
        System.out.println(categories);
    }
    //31. Get all the descriptions of all the products
    @Test
    public void getAllTheDescriptionsOfTheProduct(){
        List<HashMap<String,?>> descriptions = response.extract().path("data.description");
        System.out.println(descriptions);
    }
    //32. Get id of all the all categories of all the products
    @Test
    public void getIdOfAllTheCategories() {
        List<String> allProductId = response.extract().path("data.categories.id");
        System.out.println("The productId of all the store are :" + allProductId);
    }
    //33. Find the product names Where type = HardGood
    @Test
    public void findTheProductName(){
        List<String> name = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println(name);
    }
    //34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)
    @Test
    public void findTotalNumberOfProduct(){
        List<HashMap<?, ?>> totalNumber = response.extract().path("data.find{it.name == 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println(totalNumber.size());
    }
    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test35(){
        List<Integer> price = response.extract().path("data.findAll{it.price<5.49}.createdAt");
        System.out.println(price);
    }
    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void findTheNameOfProduct(){
        List<?> nameOfProduct = response.extract().path("data[3].categories.name");
        System.out.println(nameOfProduct);}
    //37. Find the manufacturer of all the products
    @Test
    public void findTheManufacturerOfAllProducts(){
        List<HashMap<String,?>> manufacturer = response.extract().path("data.manufacturer");
        System.out.println(manufacturer);
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void findTheImageOfTheProduct(){
        List<HashMap<String,?>> image = response.extract().path("data.findAll{it.manufacture = 'Energizer'}.image");
        System.out.println(image);
    }
    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test39(){
        List<Integer> price = response.extract().path("data.findAll{it.price>5.99}.createdAt");
        System.out.println(price);
    }
    //40. Find the uri of all the products
    @Test
    public void findTheUrlOfProducts(){
        List<HashMap<String,?>> url = response.extract().path("data.url");
        System.out.println(url);

    }
}
