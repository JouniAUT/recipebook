package hh.sof03.recipebook.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recipeid;
	private String name;
	private String level;
	private int minutes;
	
	public Recipe() {
		super();
		this.recipeid = null;
		this.name = null;
		this.level = null;
		this.minutes = 0;
	}
		public Recipe(Long recipeid, String name, String level, int minutes) {
		super();
		this.recipeid = recipeid;
		this.name = name;
		this.level = level;
		this.minutes = minutes;
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
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	@Override
	public String toString() {
		return "recipeid: " + recipeid + ", name: " + name + ", level: " + level + ", minutes: " + minutes;
	}
	
}
