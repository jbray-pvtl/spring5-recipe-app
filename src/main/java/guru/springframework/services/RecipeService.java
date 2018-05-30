package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {

    List<Recipe> getRecipes();

    public Recipe findRecipeById(Long id);

    public RecipeCommand saveRecipeCommand(RecipeCommand command);

    public void deleteById(Long idToDelete);

    List<IngredientCommand> getIngredients();

    public boolean deleteIngredientById(long id);
}
