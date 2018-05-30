package guru.springframework.controllers;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;

    public RecipeController() {}

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(value = "/recipe/show/{id}", method = RequestMethod.GET)
    public String showRecipeById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findRecipeById(Long.parseLong(id)));
        return "recipes/show";
    }

    @RequestMapping(value = "/recipe/new", method = RequestMethod.GET)
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipes/recipeForm";
    }

    @GetMapping(value = "/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findRecipeById(Long.valueOf(id)));
        return "recipes/recipeForm";
    }

    @PostMapping(value = "/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        log.info("Saving recipe to database...");
        RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
        return "redirect:/recipe/show/" + savedCommand.getId();
    }

    @GetMapping(value = "/recipe/{id}/delete")
    public String deleteById(@PathVariable String id) {
        log.info("Deleting recipe " + id);
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}
