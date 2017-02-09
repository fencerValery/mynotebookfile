

public class ContactFromFile{
  private String email;
  private String name;
  
  public ContactFromFile(String email, String name){
	this.email = email;
	this.name = name;
  }
  
  public String getEmail(){
    return email;
  }
  
  public void setEmail(String email){
    this.email = email;
  }
  
   public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.email = name;
  }
  
  public String toString(){
    String text = email + " " + name;
    return text;
  }
  
}
