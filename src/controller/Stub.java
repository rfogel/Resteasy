package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;


@Controller
@RequestMapping("stub.html")
public class Stub
{
	@RequestMapping(method = RequestMethod.GET)
	public String showUserForm (ModelMap model)
	{		
		try 
		{
			Client client = Client.create();
			WebResource resource = client.resource("localhost/Resteasy/stub01/get");
			String result  = resource.path("rodrigo").get(String.class);
			return result;
			
		} catch (UniformInterfaceException e) {
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
		
		return "";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(BindingResult result, HttpServletRequest request) throws Exception
	{
		return "redirect:index.html";
	}
}
