package hh.sof03.recipebook.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeid;
	private String name;
	private String level;
	private int duration;
	private String method;
	
	@ManyToOne
	@JsonIgnoreProperties ("recipes")
	@JoinColumn(name = "categoryid")
	private Category category;
	
	@ManyToOne
	@JsonIgnoreProperties ("recipes")
	@JoinColumn(name = "ingredientid")
	private MainIngredient mainIngredient;
	
	public Recipe() {
		super();
		this.name = null;
		this.level = null;
		this.duration = 0;
		this.method = null;
		this.category = null;
		this.mainIngredient = null;
				
	}
		public Recipe(String name, String level, int duration, String method, Category category, MainIngredient mainIngredient) {
		super();
		this.name = name;
		this.level = level;
		this.duration = duration;
		this.method = method;
		this.category = category;
		this.mainIngredient = mainIngredient;
	}
	
	public Long getRecipeid() {
		return recipeid;
	}
	public void setRecipeid(Long recipeid) {
		this.recipeid = recipeid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public MainIngredient getMainIngredient() {
		return mainIngredient;
	}
	public void setMainIngredient(MainIngredient mainIngredient) {
		this.mainIngredient = mainIngredient;
	}
	@Override
	public String toString() {
		if(this.recipeid != null)
		return "name: " + name + ", level: " + level + ", duration: " + duration + ", method: " + method + ", category: " + this.getCategory() + ", main ingredient: " + this.getMainIngredient();
		
		else
			return "name: " + name + ", level: " + level + ", duration: " + duration + ", method: " + method;
	}
	
}
