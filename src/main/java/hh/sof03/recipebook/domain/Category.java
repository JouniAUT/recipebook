package hh.sof03.recipebook.domain;

public class Category {
	
	private Long categoryid;
	private String name;
	
	public Category() {
		super();
		this.categoryid = null;
		this.name = null;
	}

	public Category(Long categoryid, String name) {
		super();
		this.categoryid = categoryid;
		this.name = name;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "categoryid: " + categoryid + ", name: " + name;
	}
	
	
	
	
	
	
}
