package beans;

public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    // Constructor, getters, and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setName(String name) {
		this.name = name;
		
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	public void setPassword(String password) {
		this.password = password;
		
	}
}