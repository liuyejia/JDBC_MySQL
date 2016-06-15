package test_sql_2;

public class Customer {
 // private int id;
   private String  identity;
  private String name;
   private String gender;
   private int birthYear;
  
  Customer(String identity,String name,String gender,int bY)
  {
	//  this.id=id;
	  this.identity=identity;
	  this.name=name;
	  this.gender=gender;
	  this.birthYear=bY;
  }
 public Customer() {
	// TODO Auto-generated constructor stub
}
 /*
public int getId() {
	return id;
}
  public void setId(int id) {
	this.id = id;
}
*/
public String getIdentity() {
	return identity;
}
 public void setIdentity(String identity) {
	this.identity = identity;
}
public String getName() {
	return name;
}
 public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getBirthYear() {
	return birthYear;
}
public void setBirthYear(int birthYear) {
	this.birthYear = birthYear;
}
 

   
}
