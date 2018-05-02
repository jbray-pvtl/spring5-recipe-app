package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class IndexControllerTest {

    @Mock
    RecipeService mockRecipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    Model mockModel;

    @Autowired
    @InjectMocks
    IndexController indexController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        //indexController = new IndexController(mockRecipeService);
    }

    @Test
    void getIndexPageTest() {
        //indexController = new IndexController(mockRecipeService);

        //Given
        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();
        recipes.add(recipe1);
        recipes.add(recipe2);

        ArgumentCaptor<List<Recipe>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //When
        when(mockRecipeService.getRecipes()).thenReturn(recipes);
        indexController.getIndexPage(mockModel);

        //Then
        int expected = 2;
        verify(mockModel, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
        List<Recipe> recipeListInController = argumentCaptor.getValue();
        int actual = recipeListInController.size();
        assertEquals(expected,actual);
    }

    @Test
    void getIndexPageShouldNotReturnNull() {
        //indexController = new IndexController(mockRecipeService);
        Object actual = indexController.getIndexPage(mockModel);
        assertNotNull(actual);
    }

    @Test
    void getIndexPageShouldReturnIndex() {
        //indexController = new IndexController(mockRecipeService);
        String expected = "index";
        String actual = indexController.getIndexPage(mockModel);
        assertEquals(expected, actual);
    }

    @Test
    void getIndexPageShouldInteractWithService() {
        //indexController = new IndexController(mockRecipeService);
        indexController.getIndexPage(mockModel);
        verify(mockRecipeService).getRecipes();
    }
}