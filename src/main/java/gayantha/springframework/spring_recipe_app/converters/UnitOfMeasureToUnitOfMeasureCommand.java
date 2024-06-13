package gayantha.springframework.spring_recipe_app.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gayantha.springframework.spring_recipe_app.commands.UnitOfMeasureCommand;
import gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;
import lombok.Synchronized;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure source) {
        if (source != null) {
            final UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
            unitOfMeasureCommand.setId(source.getId());
            unitOfMeasureCommand.setUom(source.getUom());
            return unitOfMeasureCommand;
        }
        return null;
    }

}
