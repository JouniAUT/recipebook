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

import hh.sof03.recipebook.domain.MainIngredient;
import hh.sof03.recipebook.domain.MainIngredientRepository;

@CrossOrigin
@Controller
public class MainIngredientRestController {

	@Autowired
	private MainIngredientRepository mainIngredientRepository;
	
	@RequestMapping(value = "/mainIngredients", method = RequestMethod.GET)
	public @ResponseBody List<MainIngredient> mainIngredientList () {
		return (List<MainIngredient>) mainIngredientRepository.findAll();
		
	}
	
	@RequestMapping(value = "mainIngredients/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<MainIngredient> mainIngredientRestFind(@PathVariable("ingredientid")Long ingredientId) {
		return mainIngredientRepository.findById(ingredientId);
	}
}
