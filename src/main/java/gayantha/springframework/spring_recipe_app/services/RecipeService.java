package gayantha.springframework.spring_recipe_app.services;

import java.util.Set;

import gayantha.springframework.spring_recipe_app.domain.Recipe;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long id);
}
