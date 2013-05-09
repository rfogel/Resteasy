package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="phone")
public class Phone
{
	private String operator;
	private Integer number;
	
	public String getOperator()
	{
		return operator;
	}
	public void setOperator(String operator)
	{
		this.operator = operator;
	}
	public Integer getNumber()
	{
		return number;
	}
	public void setNumber(Integer number)
	{
		this.number = number;
	}
}
