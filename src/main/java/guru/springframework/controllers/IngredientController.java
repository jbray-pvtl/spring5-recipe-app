package guru.springframework.controllers;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IngredientController {

    RecipeService recipeService;

    public IngredientController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipe/ingredient/list", method = RequestMethod.GET)
    public String getListOfIngredients(Model model) {
        List<IngredientCommand> ingredients = recipeService.getIngredients();
        model.addAttribute("ingredients", ingredients);
        return "/recipes/ingredient/list";
    }

    @RequestMapping(value = "/recipe/ingredient/delete", method = RequestMethod.GET)
    public String deleteSelectedIngredient(Model model, long id) {
        recipeService.deleteIngredientById(id);
        return "/recipes/ingredient/delete";
    }
}
