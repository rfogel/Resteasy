package webservices;

import java.io.StringWriter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Message;

@Path("/stub02")
public class Stub02Rest
{
	@GET
	@Produces("text/xml")
	@Path("/get/{requester}/{message}")
	public String getService(@PathParam("requester") String requester, @PathParam("message") String message) 
	{
		Message msg = Message.getPrototype(requester, message);
		
		java.io.StringWriter sw = new StringWriter();
		
		JAXBContext ctx;
		
		try {
			ctx = JAXBContext.newInstance(Message.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(msg, sw);
			return sw.toString();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;		
	}
	
	@POST
	@Consumes("text/xml")
	@Produces("text/xml")
	@Path("/post")
	public String postService(Message msg) 
	{
		msg.setMessage("Stub02_POST_Message");
		
		java.io.StringWriter sw = new StringWriter();
		
		JAXBContext ctx;
		
		try {
			ctx = JAXBContext.newInstance(Message.class);
			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(msg, sw);
			return sw.toString();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return null;	
	}
}
