package hh.sof03.recipebook.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class MainIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ingredientid;
	@NotBlank(message = "Please, name your main ingredient")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "mainIngredient")
	@JsonIgnoreProperties("mainIngredient")
	private List<Recipe> recipes;
	
	public MainIngredient() {
		super();
		this.name = null;
	}

	public MainIngredient(String name) {
		super();
		this.name = name;
	}

	public Long getIngredientid() {
		return ingredientid;
	}

	public void setIngredientid(Long ingredientid) {
		this.ingredientid = ingredientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public String toString() {
		return "Ingredientid: " + ingredientid + ", name: " + name;
	}
	
	
	
}
