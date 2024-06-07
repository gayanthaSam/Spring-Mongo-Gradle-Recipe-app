package gayantha.springframework.spring_recipe_app.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import gayantha.springframework.spring_recipe_app.domain.Recipe;
import gayantha.springframework.spring_recipe_app.repositories.RecipeRepository;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }

}
