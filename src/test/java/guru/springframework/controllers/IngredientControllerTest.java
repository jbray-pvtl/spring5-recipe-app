package guru.springframework.controllers;

import guru.springframework.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IngredientControllerTest {

    @Mock
    RecipeService mockRecipeService;

    MockMvc mockMvc;

    @InjectMocks
    IngredientController ingredientController;

    @BeforeEach
    void setUp() {
        ingredientController = new IngredientController(mockRecipeService);
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ingredientController).build();
    }

    @Test
    void shouldReturnListOfIngredientsTest() {
        //Given
        Model mockModel = mock(Model.class);

        //When
        ingredientController.getListOfIngredients(mockModel);

        //Then
        verify(mockRecipeService, times(1)).getIngredients();
    }

    @Test
    void shouldDeleteSelectedIngredientTest() {
        //Given
        Model mockModel = mock(Model.class);
        //When
        ingredientController.deleteSelectedIngredient(mockModel, 2L);
        //Then
        verify(mockRecipeService, times(1)).deleteIngredientById(anyLong());
    }

    @Test
    void shouldDeleteOneIngredientTest() throws Exception {
        mockMvc.perform(get("/recipe/2/ingredient/3/delete")).andExpect(status().is3xxRedirection());
    }
}
