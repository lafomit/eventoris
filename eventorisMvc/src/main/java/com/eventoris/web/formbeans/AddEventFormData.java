package com.eventoris.web.formbeans;

public class AddEventFormData {

	private String title;
	private String description;
	private int category;
	
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
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
    	builder.append(";Description=").append(getDescription());
    	builder.append(";Category=").append(getCategory());
    	builder.append("]");
    	return builder.toString();
	}
}
