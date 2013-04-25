package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.WebResource;


@Controller
@RequestMapping("stub01.html")
public class Stub01
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
			WebResource resource = client.resource("http://192.168.1.119:8080/Resteasy/services/stub01/get");
			String result = resource.path("rafael").get(String.class);
			
			return result;
			
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public String doPost()
	{
		try 
		{
			Client client = Client.create();
			WebResource resource = client.resource("http://192.168.1.119:8080/Resteasy/services/stub01/post");
			String result = resource.path("rafael").post(String.class);
			
			return result;
			
		} catch (ClientHandlerException e) {
			e.printStackTrace();
		}
		
		return "";
	}
}
