package guru.springframework.controllers;

import guru.springframework.domain.Recipe;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.AdditionalMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@SpringBootTest
//@ExtendWith(SpringExtension.class)
class RecipeControllerTest {

    //@Mock
    RecipeService mockRecipeService;

    MockMvc mockMvc;

    //@InjectMocks
    //@Autowired
    RecipeController recipeController;

    @BeforeEach
    void setUp() {
        mockRecipeService = mock(RecipeService.class);
//        RecipeService recipeService = mock(RecipeService.class);
//        when(recipeService.findRecipeById(anyLong())).thenReturn(any(Recipe.class));
//        recipeController = new RecipeController(recipeService);
    }

    @AfterEach
    void tearDown() {
        recipeController = null;
    }

    @Test
    void shouldShowRecipeByIdTest() throws Exception {
        //Given
        Model myModel = modelBuilder();
        String expected ="recipes/show";

        // When
        when(mockRecipeService.findRecipeById(anyLong())).thenReturn(any(Recipe.class));
        recipeController = new RecipeController(mockRecipeService);

        //Then
        String actual = recipeController.showRecipeById("2",myModel);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCreateNewRecipeTest() throws Exception {
        //Given

        //When

        //Then
        fail("not implemented yet!");
    }

    @Test
    void shoudUpdateRecipeTest() throws Exception {
        //Given

        //When

        //Then
        fail("not implemented yet!");
    }

    @Test
    void shouldSaveOrUpdateTest() throws Exception {
        //Given

        //When

        //Then
        fail("not implemented yet!");
    }

    @Test
    void shoudDeleteByIdTest() throws Exception {
        //Given

        //When

        //Then
        fail("not implemented yet!");
    }

    private Model modelBuilder() {
        return new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }
}