package hh.sof03.recipebook.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.recipebook.domain.MainIngredient;
import hh.sof03.recipebook.domain.MainIngredientRepository;
import jakarta.validation.Valid;

@Controller
public class MainIngredientController {

	@Autowired
	MainIngredientRepository mainIngredientRepository;
	
	@RequestMapping(value = "/mainingredientlist")
	public String mainingredientList(Model model) {
		model.addAttribute("mainIngredients", mainIngredientRepository.findAll());
		return "mainingredientlist";
	}
	
	@RequestMapping(value = "/addingre")
	public String addMainIngredient(Model model) {
		model.addAttribute("mainIngredient", new MainIngredient());
		return "addmainingredient";
	}
	
	@RequestMapping(value = "/savemainingredient", method = RequestMethod.POST)
	public String saveMainIngredient(@Valid @ModelAttribute("mainIngredient") MainIngredient mainIngredient, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addmainingredient";
		} else {
			mainIngredientRepository.save(mainIngredient);
			return "redirect:/mainingredientlist";
		}
		
	}
}
