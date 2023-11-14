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
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void findByCategoryName() {
		List<Category> categories = categoryRepository.findByName("Main course");
		
		assertThat(categories.get(0).getCategoryid()).isEqualTo(1);
	}
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Snack");
		categoryRepository.save(category);
		
		assertThat(category.getCategoryid()).isNotNull();
		assertThat(category.getCategoryid()).isEqualTo(3);
	}
	
	@Test
	public void deleteAllCategories() {
		categoryRepository.deleteAll();
		
		assertThat(categoryRepository.equals(null));

	}
	
	@Test
	public void deleteLastCategory() {
		categoryRepository.deleteById((long) 1);
		
		assertThat(categoryRepository.count()).isEqualTo(1);
	}
	
}
