package com.eventoris.web.formbeans;

public class AddUserFormData {

	private String name;
	private String familyName;
	private String email;

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

	//
	// public String toString(){
	// StringBuilder builder = new
	// StringBuilder(this.getClass().getCanonicalName());
	// builder.append("[Title=").append(getTitle());
	// builder.append(";Description=").append(getDescription());
	// builder.append(";Category=").append(getCategory());
	// builder.append("]");
	// return builder.toString();
	// }
}
