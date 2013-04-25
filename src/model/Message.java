package model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message implements Serializable
{
	private static final long serialVersionUID = 1812908819029669642L;
	
	private String message;
	private String requester;
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getRequester()
	{
		return requester;
	}
	public void setRequester(String requester)
	{
		this.requester = requester;
	}
	
	public static Message getPrototype(String requester, String message)
	{
		Message msg = new Message();
		
		msg.setMessage(message);
		msg.setRequester(requester);
		
		return msg;
	}
}
