package entity;

import java.sql.Date;

public class Receipt {
	private String name;
	private double value;
	private Date date;
	
	public Receipt(String name, double value, Date date) {
		super();
		this.name = name;
		this.value = value;
		this.date = date;
	}
	
	public Receipt() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Receipt [name=" + name + ", value=" + value + ", date=" + date + "]";
	}
}
