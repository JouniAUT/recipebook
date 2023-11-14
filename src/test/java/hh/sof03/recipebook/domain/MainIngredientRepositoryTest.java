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
public class MainIngredientRepositoryTest {

	@Autowired
	private MainIngredientRepository mainIngredientRepository;
	
	@Test
	public void findByMainIngredientName() {
		List<MainIngredient> mainIngredients = mainIngredientRepository.findByName("Minced meat");
		
		assertThat(mainIngredients.get(0).getIngredientid()).isEqualTo(1);
	}
	
	@Test
	public void createNewMainIngredient() {
		MainIngredient ingredient = new MainIngredient("Salmon");
		mainIngredientRepository.save(ingredient);
		
		assertThat(ingredient.getIngredientid()).isGreaterThan(2);
		assertThat(ingredient.getName().equalsIgnoreCase("salmon"));
	}
	
	@Test
	public void deleteAllIngredients() {
		mainIngredientRepository.deleteAll();
		
		assertThat(mainIngredientRepository.findAll()).isNullOrEmpty();
	}
	
	@Test
	public void deleteFirstMainIngredient() {
		mainIngredientRepository.deleteById((long) 1);
		
		assertThat(mainIngredientRepository.count()).isLessThan(2);
	}
}
