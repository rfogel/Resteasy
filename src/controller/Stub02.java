package controller;

import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Message;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@Controller
@RequestMapping("stub02.html")
public class Stub02
{
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String showUserForm (ModelMap model, HttpServletRequest request)
	{		
		if ( request.getParameter("service").equals("get") )		
			return doGet();
		else
			return doPost();
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(BindingResult result, HttpServletRequest request) throws Exception
	{
		return "redirect:index.html";
	}

	public String doGet()
	{
		try 
		{
			Client client = Client.create();
			WebResource resource = client.resource("http://192.168.1.119:8080/Resteasy/services/stub02/get");
			ClientResponse response = resource.path("rafael/Stub02_GET_Messsage").get(ClientResponse.class);
			
			Message msg = response.getEntity(Message.class);

			if ( msg == null ) return "";

			msg.getMessage().replace("_", " ");

			return objectToString(msg);

		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String doPost()
	{
		Message message = Message.getPrototype("rafael", "");
		
		try 
		{
			Client client = Client.create();
			WebResource resource = client.resource("http://192.168.1.119:8080/Resteasy/services/stub02/post");
			ClientResponse response = resource.type(MediaType.TEXT_XML).post(ClientResponse.class, objectToString(message));
			
			Message msg = response.getEntity(Message.class);

			if ( msg == null ) return "";

			msg.getMessage().replace("_", " ");

			return objectToString(msg);

		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}

		return "";
	}

	protected String objectToString(Object obj)
	{
		try
		{
			java.io.StringWriter sw = new StringWriter();
			
			JAXBContext ctx = JAXBContext.newInstance(obj.getClass());

			Marshaller m = ctx.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(obj, sw);
			
			return sw.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}

















