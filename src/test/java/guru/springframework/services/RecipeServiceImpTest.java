package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class RecipeServiceImpTest {

    @Mock
    RecipeRepository mockRepository;

    RecipeService recipeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImp(mockRepository);
    }

    @Test
    public void shouldCallMethodOnRecipeRepository() throws Exception {
        recipeService = new RecipeServiceImp(mockRepository);
        recipeService.getRecipes();
        verify(mockRepository).findAll();
    }

    @Test
    public void shouldReturnASetOfRecipesTest() throws Exception {
        recipeService = new RecipeServiceImp(mockRepository);
        List<Recipe> recipes = recipeService.getRecipes();
        assertNotNull(recipes);
    }

    @Test
    public void shouldReturnAtLeastOneRecipe() throws Exception {
        recipeService = new RecipeServiceImp(mockRepository);
        Recipe recipe = new Recipe();
        List<Recipe> recipeData = new ArrayList<>();
        recipeData.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipeData);

        List<Recipe> recipes = recipeService.getRecipes();
        int expected = 1;
        assertEquals(expected, recipes.size());
    }

    @Test
    public void shouldDeleteRecipeByIdTest() {
        //Given
        Long idToDelete = Long.valueOf(2L);
        //When
        recipeService.deleteById(idToDelete);
        //Then
        verify(mockRepository, times(1)).deleteById(anyLong());
    }

}