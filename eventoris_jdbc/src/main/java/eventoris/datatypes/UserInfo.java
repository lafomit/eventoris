package eventoris.datatypes;

public class UserInfo {

	private String name;
	private String familyName;
	private String email;
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private String birthday;

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
		builder.append("[birthday=").append(getBirthday());
		builder.append(";email=").append(getEmail());
		builder.append(";family=").append(getFamilyName());
		builder.append(";id=").append(getId());
		builder.append(";name=").append(getName());
		builder.append(";userName=").append(getUserName());
		builder.append("]");
		return builder.toString();
	}
	
}
