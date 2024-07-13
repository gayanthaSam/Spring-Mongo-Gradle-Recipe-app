package gayantha.springframework.spring_recipe_app.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {

    Optional<UnitOfMeasure> findByUom(String uom);
}
