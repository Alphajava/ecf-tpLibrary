package fr.alpha.beans;

public class Author {
	private int id;
    private String firstname;
    private String lastname;
    private String nativeCountry;
    
    
	public Author() {}
	public Author(String firstname, String lastname, String nativeCountry) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.nativeCountry = nativeCountry;
	}
	public Author(int id, String firstname, String lastname,String nativeCountry) {
		this(firstname, lastname, nativeCountry);
		this.id = id;
	}
	    
    
	public int getId() {
		return id;
	}  
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getNativeCountry() {
		return nativeCountry;
	}
	public void setNativeCountry(String nativeCountry) {
		this.nativeCountry = nativeCountry;
	}
	
	
   
	
}
