package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

import com.github.javafaker.Faker;

import api.payloads.User;

public class BaseClass {   
	
	Faker faker;
	User userpayload;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		// generate the data using faker library and pass it to the POJO class

		faker = new Faker();
		userpayload = new User(); 

		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());

	}
}
