package com.quotemedia.loaders.model;

public class AddressList {

	int seq;
	String firstName;
	String LastName;
	int age;
	String street;
	String city;
	String state;
	String zip;
	String dollar;
	String pick;
	String  date;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getDollar() {
		return dollar;
	}
	public void setDollar(String dollar) {
		this.dollar = dollar;
	}
	public String getPick() {
		return pick;
	}
	public void setPick(String pick) {
		this.pick = pick;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "AddressList [seq=" + seq + ", firstName=" + firstName + ", LastName=" + LastName + ", age=" + age
				+ ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", dollar=" + dollar
				+ ", pick=" + pick + ", date=" + date + "]";
	}
	
}



