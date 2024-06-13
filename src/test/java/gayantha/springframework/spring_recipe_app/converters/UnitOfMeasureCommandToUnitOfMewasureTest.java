package gayantha.springframework.spring_recipe_app.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gayantha.springframework.spring_recipe_app.commands.UnitOfMeasureCommand;
import gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMewasureTest {

    public static final String DESCRIPTION = "description";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    UnitOfMeasureCommandToUnitOfMewasure converter;

    @BeforeEach
    void setUp() {
        converter = new UnitOfMeasureCommandToUnitOfMewasure();
    }

    @Test
    public void testNullParamter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new UnitOfMeasureCommand()));
    }

    @Test
    void testConvert() {
        // given
        UnitOfMeasureCommand command = new UnitOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setUom(DESCRIPTION);

        // when
        UnitOfMeasure uom = converter.convert(command);

        // then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getUom());
    }
}
