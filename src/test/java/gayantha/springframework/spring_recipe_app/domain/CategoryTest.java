package gayantha.springframework.spring_recipe_app.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp() {
        category = new Category();
        category.setId(4L);
    }

    @Test
    void testGetDescription() {
    }

    @Test
    void testGetId() {
        Long id = 4L;
        assertEquals(id, category.getId());
    }

    @Test
    void testGetRecipes() {

    }
}
