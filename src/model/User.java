package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User
{
	private String name;
	private Integer age;
	private String address;
	private List<String> nickname;
	private List<Phone> phones;
	
	public User() {}
	
	public User(String name, Integer age, String address, List<String> nickname, List<Phone> phones)
	{
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.nickname = nickname;
		this.phones = phones;
	}
	
	public List<Phone> getPhones()
	{
		return phones;
	}
	public void setPhones(List<Phone> phones)
	{
		this.phones = phones;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public List<String> getNickname()
	{
		return nickname;
	}
	public void setNickname(List<String> nickname)
	{
		this.nickname = nickname;
	}	
}
