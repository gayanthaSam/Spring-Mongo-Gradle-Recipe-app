package gayantha.springframework.spring_recipe_app.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gayantha.springframework.spring_recipe_app.domain.Category;
import gayantha.springframework.spring_recipe_app.domain.UnitOfMeasure;
import gayantha.springframework.spring_recipe_app.repositories.CategoryRepository;
import gayantha.springframework.spring_recipe_app.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({ "", "/", "/index" })
    public String getIndexPage() {

        Optional<Category> cateOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByUom("Teaspoon");
        System.out.println("Cat id is: " + cateOptional.get().getId());
        System.out.println("UOM id id: " + unitOfMeasureOptional.get().getId());
        return "index";
    }
}
