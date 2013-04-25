package webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/stub01")
public class Stub01Rest
{
	@GET
	@Produces("text/xml")
	@Path("/get/{username}")
	public String getService(@PathParam("username") String userName) 
	{
		return "GET SERVICE for " + userName;
	}
	
	@GET
	@Produces("text/xml")
	@Path("/post/{username}")
	public String postService(@PathParam("username") String userName) 
	{
		return "POST SERVICE for " + userName;
	}
}
