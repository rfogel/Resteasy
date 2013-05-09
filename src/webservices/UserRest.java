package webservices;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.Phone;
import model.User;
import model.UserList;

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
		List<Phone> phone = new ArrayList<Phone>();
		
		nickname.add("balzinho");
		nickname.add("balzord");
		
		Phone p = new Phone();
		p.setOperator("Oi");
		p.setNumber(123);
		
		phone.add(p);
		
		User user1 = new User("Bal", 30, "Vila Valqueire", nickname, phone);
		User user2 = new User("Fogel", 30, "Niteroi", nickname, phone);
		
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		
		UserList users = new UserList();
		users.setUsers(list);
		
		Gson gson = new Gson();

		String json = gson.toJson(users);
	 
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
	
	@POST
	@Consumes("text/xml")
	@Produces("text/plain")
	@Path("/xml")
	public String getServiceFromXml(User user) 
	{		
		Gson gson = new Gson();
		
		String json = gson.toJson(user);
		 
		System.out.println(json);
		
		return json;
	}
	
	/*<user>
	<name>rafael</name>
	<age>26</age>
	<phones>
	<operator>oi</operator>
	<number>123</number>
	</phones>
	<phones>
	<operator>vivo</operator>
	<number>987</number>
	</phones>
	<phones>
	<operator>claro</operator>
	<number>123456</number>
	</phones>
	</user>*/
}
