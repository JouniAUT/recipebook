package hh.sof03.recipebook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import hh.sof03.recipebook.webcontrol.CategoryController;
import hh.sof03.recipebook.webcontrol.CategoryRestController;
import hh.sof03.recipebook.webcontrol.MainIngredientController;
import hh.sof03.recipebook.webcontrol.MainIngredientRestController;
import hh.sof03.recipebook.webcontrol.RecipeController;
import hh.sof03.recipebook.webcontrol.RecipeRestController;
import hh.sof03.recipebook.webcontrol.UserDetailImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RecipebookApplicationTests {

	@Autowired
	private RecipeController recipeController;
	
	@Autowired
	private CategoryController categoryController;
	
	@Autowired
	private MainIngredientController mainIngredientController;
	
	@Autowired
	private UserDetailImpl userDetailImpl;
	
	@Autowired 
	private RecipeRestController recipeRestController;
	
	@Autowired
	private CategoryRestController categoryRestController;
	
	@Autowired
	private MainIngredientRestController mainIngredientRestController;
	
	@Test
	void contextLoads() {
		assertThat(recipeController).isNotNull();
		assertThat(categoryController).isNotNull();
		assertThat(mainIngredientController).isNotNull();
		assertThat(userDetailImpl).isNotNull();
		assertThat(recipeRestController).isNotNull();
		assertThat(categoryRestController).isNotNull();
		assertThat(mainIngredientRestController).isNotNull();
	}

}
