package APIAutomation.com.api.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Users {
	
	private static Response response;
	private List<String> userIdList = new ArrayList<String>();
	private String id = "";
	
	@Given("I hit GetUsers End point")
		public void i_hit_get_users_end_point() {		
		RestAssured.baseURI = "http://localhost:8080/api/v1/users";
		RequestSpecification request = RestAssured.given();
		response = request.get("/getUsers");
		}

		@Then("I check the response of GetUsers")
		public void i_check_the_response_of_get_users() {			
			String jsonString = response.asString();
			List<Map<String, String>> userIds = JsonPath.from(jsonString).get("id");
			Assert.assertTrue(userIds.size() > 0);
			Assert.assertTrue(response.getStatusCode() == 200);
		}
		
		@Given("I provide {string} and {string} to create user")
		public void i_provide_and_to_create_user(String name, String email) {
			RestAssured.baseURI = "http://localhost:8080/api/v1/users";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
			JsonObject requestParams = new JsonObject();
			requestParams.add("name", name); 
			requestParams.add("email", email);
			request.body(requestParams.toString());
			response = request.post("/createUser");
			Assert.assertEquals(200, response.getStatusCode());
			String bodyData = response.getBody().asPrettyString();
			String userId = JsonPath.from(bodyData).get("id");
			userIdList.add(userId);
			
		}

		@Then("User should be created with {string} and {string}")
		public void user_should_be_created_with_and(String name, String email) {
			Assert.assertEquals(200, response.getStatusCode());
		    Assert.assertTrue(response.getBody().asString().contains(name));
		    Assert.assertTrue(response.getBody().asString().contains(email));
		}

		@Given("I provide ID to getUser endpoint")
		public void i_provide_id_to_get_user_endpoint() {
			RestAssured.baseURI = "http://localhost:8080/api/v1/users";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
			response = request.get("/getUsers");
			String jsonString = response.asString();
			List<String> userIds = JsonPath.from(jsonString).get("id");
			id = userIds.get(0);
			response = request.get("/getUser/"+id);
			//System.out.println("Request user id is "+response.getBody().asPrettyString());
		}

		@Then("User details should be available in response")
		public void user_details_should_be_available_in_response() {
			String jsonString = response.asString();
			String exceptedUserId = JsonPath.from(jsonString).get("id");
			Assert.assertEquals(exceptedUserId, id);
			
		}

		@Given("User update details with {string} and {string} on User ID")
		public void user_update_details_with_and_on_user_id(String name, String email) {
			RestAssured.baseURI = "http://localhost:8080/api/v1/users";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
			response = request.get("/getUsers");
			String jsonString = response.asString();
			List<String> userIds = JsonPath.from(jsonString).get("id");
			id = userIds.get(0);
			JsonObject requestParams = new JsonObject();
			requestParams.add("name", name); 
			requestParams.add("email", email);
			request.body(requestParams.toString());
			response = request.post("/"+id+"/update");
		}

		@Then("User details should be updated with {string} and {string}")
		public void user_details_should_be_updated_with_and(String name, String email) {
		    Assert.assertEquals(200, response.getStatusCode());
		    Assert.assertTrue(response.getBody().asString().contains(name));
		    Assert.assertTrue(response.getBody().asString().contains(email));
		}


		@Given("user Id to Delete end point")
		public void user_id_to_delete_end_point() {
			RestAssured.baseURI = "http://localhost:8080/api/v1/users";
			RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
			response = request.get("/getUsers");
			String jsonString = response.asString();
			List<String> userIds = JsonPath.from(jsonString).get("id");
			id = userIds.get(0);
			response = request.get("/"+id+"/delete");
		}

		@Then("User should be deleted with success response")
		public void user_should_be_deleted_with_success_response() {
		   Assert.assertEquals(200, response.getStatusCode());
		}

}