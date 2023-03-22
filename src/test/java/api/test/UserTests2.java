package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints2;
import io.restassured.response.Response;

// Here, we are referring the userEndPoints2.java

public class UserTests2 extends BaseClass { 


	@Test(priority = 1)
	public void testPostUser() {
		
		logger.info("********** creating user **************");
		Response response = UserEndPoints2.createUser(userpayload);

		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********** user is created **************");
	}

	@Test(priority = 2)
	public void testGetUser() {
		
		logger.info("********** Reading user info **************");
		Response response = UserEndPoints2.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("********** user info is displayed **************");
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {
		// update the new data using payload.
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		logger.info("********** cupdating the user **************");
		Response response = UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);

		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		// check the data after update
		Response responseAfterUpdate = UserEndPoints2.readUser(this.userpayload.getUsername());
		responseAfterUpdate.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
		logger.info("********** user is updated **************");
	}

	@Test(priority = 4)
	public void testDeleteUserByName() {
		logger.info("********** deleting user **************");
		Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********user deleted **************");
	}

}
