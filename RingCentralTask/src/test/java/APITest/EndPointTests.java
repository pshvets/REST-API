package APITest;

import com.google.gson.Gson;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EndPointTests {

    @BeforeClass
    public void setUpClass(){

        baseURI="http://localhost:8080/api/v1/users";
    }

    @Test
    //Case 1: Creating a new User
    public void createUser(){

      Map<String, Object> users= new HashMap<>();
        users.put("name", "ibrahim demir");
        users.put("email", "brhmdmr@yahoo.com");

        Gson gson = new Gson();

           Response response= given().accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Content-Type", "application/json")
                    .body(gson.toJson(users))
                    .when().post("/createUser");

                   response.then().assertThat().statusCode(201)
                    .and().assertThat().contentType("application/json")
                                .and().assertThat().body("name", equalTo("ibrahim demir"),
                                "email", equalTo("brhmdmr@yahoo.com") );

                   response.prettyPrint();

    }

    @Test
    // Case 2: Validating ID with GET Request
    public void getUser(){

        given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .when().get("/getUser/{some_id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("name", equalTo("ibrahim demir"),
                "email", equalTo("brhmdmr@yahoo.com") );
    }

    @Test
    // Case 3: Validating All Users with Get Request

    public void getAllUsers(){
       Response response= given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .when().get("/getUsers");

                response.then().assertThat().statusCode(200);
                response.prettyPrint();

    }

    @Test
    // Case 4: Updating a User with Put Request
    public void updateUser(){

        Map<String,Object> putBodyMap = new LinkedHashMap<>() ;
        putBodyMap.put("name","ibrahimUpdated");
        putBodyMap.put("email","dmribra@yahoo.com");

        given()
                .log().all()
                .pathParam("id","some_id")
                .contentType(ContentType.JSON)
                .body(putBodyMap).
                when()
                .put("/{some_id}/update").
                then()
                .log().all()
                .statusCode(204);
    }

    @Test
    //  Case 5: Delete a User
    public void deleteUser(){
        given().pathParam("id", "some_id")
                .when().delete("/{some_id}/delete")
                .then().assertThat().statusCode(204);

    }


}
