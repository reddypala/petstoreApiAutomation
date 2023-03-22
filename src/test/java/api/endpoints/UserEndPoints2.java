package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
// NOTE : This file takes url's for desired CRUD operations from the routes.properties file.
// This file contains CRUD operation methods.

// Created for performing CRUD(Create,Read,Update,Delete) operations.

public class UserEndPoints2 {

	// method to load the properties file and get the Url's from properties file.
	public static ResourceBundle getURL() {
		// Load the properties file and provide the properties file name in
		// getBundle("routes")
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes; 
	}

	public static Response createUser(User payload) {

		String post_url = getURL().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(post_url);

		return response;
	}

	public static Response readUser(String username) {

		String get_url = getURL().getString("get_url");
		Response response = given().pathParam("username", username).when().get(get_url);

		return response;
	}

	public static Response updateUser(String username, User payload) {
		
		String update_url = getURL().getString("update_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", username).body(payload).when().put(update_url);

		return response;
	}

	public static Response deleteUser(String username) {
		
		String delete_url = getURL().getString("delete_url");
		Response response = given().pathParam("username", username).when().delete(delete_url);

		return response;
	}

}
