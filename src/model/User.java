package model;

import java.util.List;

public class User
{
	private String name;
	private Integer age;
	private String address;
	private List<String> nickname;
	
	public User(String name, Integer age, String address, List<String> nickname)
	{
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.nickname = nickname;
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
