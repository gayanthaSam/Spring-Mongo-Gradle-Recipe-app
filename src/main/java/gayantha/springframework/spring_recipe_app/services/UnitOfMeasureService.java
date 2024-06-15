package gayantha.springframework.spring_recipe_app.services;

import java.util.Set;

import gayantha.springframework.spring_recipe_app.commands.UnitOfMeasureCommand;

public interface UnitOfMeasureService {

    Set<UnitOfMeasureCommand> listAllUoms();
}
