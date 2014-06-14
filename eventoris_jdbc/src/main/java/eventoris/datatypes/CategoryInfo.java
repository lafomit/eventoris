package eventoris.datatypes;

public class CategoryInfo {
	
	private int idCategory;
	private String categoryName;
	private String categoryDescription;
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder(this.getClass().getCanonicalName());
		builder.append("[ name=").append(getCategoryName());
		builder.append("; description=").append(getCategoryDescription());
		builder.append("]");
		return builder.toString();
	}
	
	public int getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
}
