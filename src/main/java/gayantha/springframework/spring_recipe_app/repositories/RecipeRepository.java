package gayantha.springframework.spring_recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;

import gayantha.springframework.spring_recipe_app.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, String> {

}
