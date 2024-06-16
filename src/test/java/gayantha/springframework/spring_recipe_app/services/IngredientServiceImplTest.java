package gayantha.springframework.spring_recipe_app.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gayantha.springframework.spring_recipe_app.commands.IngredientCommand;
import gayantha.springframework.spring_recipe_app.converters.IngredientCommandToIngredient;
import gayantha.springframework.spring_recipe_app.converters.IngredientToIngredientCommand;
import gayantha.springframework.spring_recipe_app.converters.UnitOfMeasureCommandToUnitOfMewasure;
import gayantha.springframework.spring_recipe_app.converters.UnitOfMeasureToUnitOfMeasureCommand;
import gayantha.springframework.spring_recipe_app.domain.Ingredient;
import gayantha.springframework.spring_recipe_app.domain.Recipe;
import gayantha.springframework.spring_recipe_app.repositories.RecipeRepository;
import gayantha.springframework.spring_recipe_app.repositories.UnitOfMeasureRepository;

public class IngredientServiceImplTest {

    private final IngredientToIngredientCommand ingredientToIngredientCommand;
    private final IngredientCommandToIngredient ingredientCommandToIngredient;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    IngredientService ingredientService;

    // init converters
    public IngredientServiceImplTest() {
        this.ingredientToIngredientCommand = new IngredientToIngredientCommand(
                new UnitOfMeasureToUnitOfMeasureCommand());
        this.ingredientCommandToIngredient = new IngredientCommandToIngredient(
                new UnitOfMeasureCommandToUnitOfMewasure());
    }

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        ingredientService = new IngredientServiceImpl(ingredientCommandToIngredient, ingredientToIngredientCommand,
                recipeRepository, unitOfMeasureRepository);
    }

    @Test
    void testFindByRecipeIdAndIngredientId() {
    }

    @Test
    public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
        // given
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setId(1L);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(1L);
        Ingredient ingredient3 = new Ingredient();
        ingredient3.setId(3L);
        recipe.addIngredients(ingredient1);
        recipe.addIngredients(ingredient2);
        recipe.addIngredients(ingredient3);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // when
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        // then
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());

    }

    @Test
    void testSaveIngredientCommand() {
        // given
        IngredientCommand command = new IngredientCommand();
        command.setId(3L);
        command.setRecipeId(2L);
        Optional<Recipe> recipeOptional = Optional.of(new Recipe());
        Recipe savedRecipe = new Recipe();
        savedRecipe.addIngredients(new Ingredient());
        savedRecipe.getIngredients().iterator().next().setId(3L);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(recipeRepository.save(any())).thenReturn(savedRecipe);

        // when
        IngredientCommand savedCommand = ingredientService.saveIngredientCommand(command);

        // then
        assertEquals(Long.valueOf(3L), savedCommand.getId());
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }

    @Test
    public void testDeleteById() throws Exception {
        // Given
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();
        ingredient.setId(3L);
        recipe.addIngredients(ingredient);
        ingredient.setRecipe(recipe);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        // When
        ingredientService.deleteById(1L, 3L);

        // Then
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, times(1)).save(any(Recipe.class));
    }
}
