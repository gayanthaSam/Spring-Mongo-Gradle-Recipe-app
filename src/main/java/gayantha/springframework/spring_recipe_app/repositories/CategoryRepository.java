package gayantha.springframework.spring_recipe_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gayantha.springframework.spring_recipe_app.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
