package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    private RecipeService recipeService;

    public IndexController() {}

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("Getting index page...");
        List<Recipe> recipes = this.recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "index";
    }
}
