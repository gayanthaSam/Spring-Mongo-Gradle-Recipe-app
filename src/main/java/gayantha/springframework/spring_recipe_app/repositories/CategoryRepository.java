package gayantha.springframework.spring_recipe_app.repositories;

import org.springframework.data.repository.CrudRepository;

import gayantha.springframework.spring_recipe_app.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
