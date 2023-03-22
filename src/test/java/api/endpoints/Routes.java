package api.endpoints;

// This Routes class is to maintain the url's.
// From swagger all the url's are captured.

/*  Swagger URI - https://petstore.swagger.io/ 
 * 	create user (post) : https://petstore.swagger.io/v2/user
 * 	Get user (GET): https://petstore.swagger.io/v2/user/{username}
 * 	update user(PUT):  https://petstore.swagger.io/v2/user/{username}
 * 	delete user(DELETE):  https://petstore.swagger.io/v2/user/{username}
 * */
public class Routes {
	 
	public static String base_Url = "https://petstore.swagger.io/v2"; 
	
	//user module url's 
	
	public static String post_url = base_Url+"/user";
	public static String get_url = base_Url+"/user/{username}";
	public static String update_url = base_Url+"/user/{username}";
	public static String delete_url = base_Url+"/user/{username}";
	
	//Store module url's
	
	//Pet module url's
}
