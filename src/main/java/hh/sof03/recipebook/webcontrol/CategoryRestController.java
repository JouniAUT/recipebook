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

import hh.sof03.recipebook.domain.Category;
import hh.sof03.recipebook.domain.CategoryRepository;

@CrossOrigin
@Controller
public class CategoryRestController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> categoryRestList() {
		return (List<Category>) categoryRepository.findAll();
	}
	
	@RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Category> categoryRestFind(@PathVariable("categoryid")Long categoryId) {
		return categoryRepository.findById(categoryId);
	}
}
