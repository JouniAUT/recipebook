package hh.sof03.recipebook.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class RecipeRepositoryTest {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private MainIngredientRepository mainIngredientRepository;
	
	@Test
	public void findByNameReturnsMainIngredientName() {
		List<Recipe> recipes = recipeRepository.findByName("Macaroni cassarole");
		
		assertThat(recipes).hasSize(1);
		assertThat(recipes.get(0).getMainIngredient().getName()).isEqualTo("Minced meat");
	}
	
	@Test
	public void createNewRecipe() {
		Category category = new Category("Soup");
		categoryRepository.save(category);
		
		MainIngredient mainIngredient = new MainIngredient("Salmon");
		mainIngredientRepository.save(mainIngredient);
		
		Recipe recipe = new Recipe("Salmon soup", "medium", 30, "Cut, boil, serve", category, mainIngredient);
		recipeRepository.save(recipe);
		
		assertThat(recipe.getRecipeid()).isNotNull();
		assertThat(recipe.getCategory().getName()).isEqualTo("Soup");
	}
	
	@Test
	public void deleteAllRecipes() {
		recipeRepository.deleteAll();
		
		assertThat(recipeRepository.count()).isEqualTo(0);
	}
}
