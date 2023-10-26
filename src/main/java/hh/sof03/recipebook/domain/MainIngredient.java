package hh.sof03.recipebook.domain;

public class MainIngredient {

	private Long ingredientid;
	private String name;
	
	public MainIngredient() {
		super();
		this.ingredientid = null;
		this.name = null;
	}

	public MainIngredient(Long inredientid, String name) {
		super();
		this.ingredientid = inredientid;
		this.name = name;
	}

	public Long getInredientid() {
		return ingredientid;
	}

	public void setInredientid(Long inredientid) {
		this.ingredientid = inredientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "inredientid: " + ingredientid + ", name: " + name;
	}
	
	
	
}
