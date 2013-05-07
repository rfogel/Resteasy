package webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.User;

import com.google.gson.Gson;

@Path("/user")
public class UserRest
{
	@GET
	@Produces("text/plain")
	@Path("/get")
	public String getService() 
	{
		List<String> nickname = new ArrayList<String>();
		
		nickname.add("balzinho");
		nickname.add("balzord");
		
		User user = new User("Bal", 30, "Vila Valqueire", nickname);
		
		Gson gson = new Gson();

		String json = gson.toJson(user);
	 
		System.out.println(json);
		
		return json;
	}
	
	@GET
	@Produces("text/plain")
	@Path("/json")
	public String getServiceFromJson() 
	{		
		Gson gson = new Gson();
		
		User user = gson.fromJson("{\"name\":\"Fogel\",\"age\":30,\"address\":\"Vila Valqueire\",\"nickname\":[\"balzinho\",\"balzord\"]}", User.class);
		
		String json = gson.toJson(user);
	 
		System.out.println(json);
		
		return json;
	}
}
