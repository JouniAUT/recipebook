package hh.sof03.recipebook.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MainIngredientRepository extends CrudRepository<MainIngredient, Long> {
	
	List<MainIngredient> findByName (String name);

}
