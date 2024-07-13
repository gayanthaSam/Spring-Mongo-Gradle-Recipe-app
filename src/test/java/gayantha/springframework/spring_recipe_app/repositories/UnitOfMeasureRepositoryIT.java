package gayantha.springframework.spring_recipe_app.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;

//@ExtendWith(SpringExtension.class)
// ---JUnit4 @Runwith(SpringRunner.class)
//@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    // @Autowired
    // UnitOfMeasureRepository unitOfMeasureRepository;

    // @BeforeEach
    // void setUp() {

    // }

    // @Test
    // void testFindByUom() {
    //     Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Teaspoon");
    //     assertEquals("Teaspoon", uomOptional.get().getUom());
    // }

    // @Test
    // void testFindByUomCup() {
    //     Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByUom("Cup");
    //     assertEquals("Cup", uomOptional.get().getUom());
    // }
}
