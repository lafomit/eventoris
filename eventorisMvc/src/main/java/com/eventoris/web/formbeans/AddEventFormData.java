package com.eventoris.web.formbeans;

public class AddEventFormData {

	private String title;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
    	builder.append("[Title=").append(getTitle());
    	builder.append(";Description=").append(getDescription()).append("]");
    	return builder.toString();
	}
}
