package hh.sof03.recipebook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.recipebook.domain.Category;
import hh.sof03.recipebook.domain.CategoryRepository;
import hh.sof03.recipebook.domain.MainIngredient;
import hh.sof03.recipebook.domain.MainIngredientRepository;
import hh.sof03.recipebook.domain.Recipe;
import hh.sof03.recipebook.domain.RecipeRepository;
import hh.sof03.recipebook.domain.User;
import hh.sof03.recipebook.domain.UserRepository;

@SpringBootApplication
public class RecipebookApplication {
	private static final Logger log = LoggerFactory.getLogger(RecipebookApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(RecipebookApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository recipeRepository, CategoryRepository categoryRepository, MainIngredientRepository mainIngredientRepository, UserRepository userRepository) {
		return (args) -> {
			
			log.info("Create new category");
			
			Category mainCourse = new Category("Main course");
			categoryRepository.save(mainCourse);
			
			Category dessert = new Category("Dessert");
			categoryRepository.save(dessert);
			
			log.info("Create new main ingredient");
			
			MainIngredient mincedMeat = new MainIngredient("Minced meat");
			mainIngredientRepository.save(mincedMeat);
			
			MainIngredient strawberry = new MainIngredient("Strawberry");
			mainIngredientRepository.save(strawberry);
			
			log.info("save one recipe");
			recipeRepository.save(new Recipe ("Macaroni cassarole", "Easy", 45, "Boil the macaroni, fry the minced meat, mix eggs and milk, put everything together, bake in the oven", mainCourse, mincedMeat ));
			
			User user1 = new User("user", "$2a$10$LRjNVt.J8WqlqyOJCabuROK3vtcNoCmb8SHeTKGItMBDtiJhcFggu", "USER");
			userRepository.save(user1);
			
			User user2 = new User("admin", "$2a$10$uJrw5lj27HkSbRIbNsBOxOAxZR.lbuiJ5HkvroZivWPjp.v0DBn9i", "ADMIN");
			userRepository.save(user2);
			
			log.info("Fetch all recipes");
			for (Recipe recipe : recipeRepository.findAll()) {
				log.info(recipe.toString());
			}
		};
	}
 
}
