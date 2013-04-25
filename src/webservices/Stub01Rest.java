package webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/stub01")
public class Stub01Rest
{
	@GET
	@Produces("text/plain")
	@Path("/get/{username}")
	public String getService(@PathParam("username") String userName) 
	{
		return "Stub01 GET Message for " + userName;
	}
	
	@POST
	@Consumes("text/plain")
	@Produces("text/plain")
	@Path("/post/{username}")
	public String postService(@PathParam("username") String userName) 
	{
		return "Stub01 POST Message for " + userName;
	}
}
