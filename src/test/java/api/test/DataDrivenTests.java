package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

// Testcase:
/*
 * create user with different usernames using post request, by reading the data from the excel sheet.
 * 
 * read usernames from the excel sheet and delete them from the server.
 * 
 * */
public class DataDrivenTests {

	@Test(priority = 1, dataProvider  = "Data", dataProviderClass = DataProviders.class) 
	public void testPostUser(String userId, String username, String firstname, String lastname, String useremail,
			String pwd, String phone) {
		// Use POJO class to create Multiple users for which data is coming from the
		// excel sheet.
		User userpayload = new User();
		userpayload.setId(Integer.parseInt(userId));
		userpayload.setUsername(username);
		userpayload.setFirstName(firstname);
		userpayload.setLastName(lastname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(phone);

		Response response = UserEndPoints.createUser(userpayload);

		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String UserName) {

		Response response = UserEndPoints.deleteUser(UserName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
