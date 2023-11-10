package hh.sof03.recipebook.webcontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof03.recipebook.domain.Category;
import hh.sof03.recipebook.domain.CategoryRepository;
import jakarta.validation.Valid;

@Controller
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcat")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "addcategory";
		} else {
			categoryRepository.save(category);
			return "redirect:/categorylist";
		}
		
		
	}
}
