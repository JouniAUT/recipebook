package hh.sof03.recipebook.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.recipebook.domain.CategoryRepository;
import hh.sof03.recipebook.domain.MainIngredientRepository;
import hh.sof03.recipebook.domain.Recipe;
import hh.sof03.recipebook.domain.RecipeRepository;
import jakarta.validation.Valid;



@Controller
public class RecipeController {
	
	@Autowired 
	RecipeRepository recipeRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	MainIngredientRepository mainIngredientRepository;

	@RequestMapping(value = "/recipelist")
	public String recipeList(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipelist";
	}
	
	@RequestMapping(value = "/add")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("ingredients", mainIngredientRepository.findAll());
		return "addrecipe";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("recipe", recipe);
			model.addAttribute("categories", categoryRepository.findAll());
			model.addAttribute("ingredients", mainIngredientRepository.findAll());
			return "addrecipe";
				
		} else {
		recipeRepository.save(recipe);
		return "redirect:/recipelist";
		}	
	}
	
	@RequestMapping(value = "/show/{id}") //Näytä yhden reseptin ohjeistus
	public String showMethodOfTheRecipe(@PathVariable("id")Long recipeId, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(recipeId).get());
		return "method";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
		recipeRepository.deleteById(recipeId);
		return "redirect:../recipelist";
	}
	
	@RequestMapping(value = "/edit/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String showEditRecipe(@PathVariable("id")Long recipeId, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(recipeId));
		model.addAttribute("categories", categoryRepository.findAll());
		model.addAttribute("mainIngredients", mainIngredientRepository.findAll());
		return "editrecipe";
	}
	
}

