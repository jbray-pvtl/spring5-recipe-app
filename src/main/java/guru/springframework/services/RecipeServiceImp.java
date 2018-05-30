package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.commands.RecipeCommand;
import guru.springframework.converters.RecipeCommandToRecipe;
import guru.springframework.domain.Ingredient;
import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImp implements RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;

    public RecipeServiceImp(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.debug("getting recipe objects...");
        List<Recipe> recipes = (List)this.recipeRepository.findAll();
        return recipes;
    }

    @Override
    public Recipe findRecipeById(Long id) {
        Recipe recipe = new Recipe();
        Optional<Recipe> optionalRecipe = recipeRepository.findById(id);
        recipe = optionalRecipe.get();
        return recipe;
    }

    @Override
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        log.info("Persisting new recipe...");
        Recipe recipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(recipe);

        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setId(savedRecipe.getId());
        return recipeCommand;
    }

    @Override
    public void deleteById(Long idToDelete) {
        log.debug("Deleting recipe " + idToDelete);
        recipeRepository.deleteById(idToDelete);
    }

    @Override
    public List<IngredientCommand> getIngredients() {
        //TODO not implemented yet
        return null;
    }

    @Override
    public boolean deleteIngredientById(long id) {
        //
        return false;
    }
}
