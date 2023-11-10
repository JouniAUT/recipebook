package hh.sof03.recipebook.webcontrol;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.sof03.recipebook.domain.Recipe;
import hh.sof03.recipebook.domain.RecipeRepository;

@CrossOrigin
@Controller
public class RecipeRestController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@RequestMapping(value = "/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> recipeRestList() {
		return (List<Recipe>) recipeRepository.findAll();
	}
	
	@RequestMapping(value = "/recipes/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Recipe> recipeRestFind(@PathVariable("id")Long recipeId) {
		return recipeRepository.findById(recipeId);
	}
}	
