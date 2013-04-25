package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;


@Path("/stub01")
public class Stub01Rest
{
	@GET
	@Produces("text/xml")
	@Path("/get/{username}")
	public String getAccountByUser(@PathParam("username") String userName) 
	{
		try 
		{
			Client client = Client.create();
			WebResource resource = client.resource("http://192.168.1.211/flexservices/user/get/username");
			String result  = resource.path(userName + "/token").get(String.class);
			return result;
			
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
