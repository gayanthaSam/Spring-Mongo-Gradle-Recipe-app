package gayantha.springframework.spring_recipe_app.repositories.reactive;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import  gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;


public interface UnitOfMeasureReactiveRepository extends ReactiveMongoRepository<UnitOfMeasure, String> {

}
