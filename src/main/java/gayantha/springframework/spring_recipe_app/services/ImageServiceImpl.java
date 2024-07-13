package gayantha.springframework.spring_recipe_app.services;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import gayantha.springframework.spring_recipe_app.domain.Recipe;
import gayantha.springframework.spring_recipe_app.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional
    public void saveImageFile(String reipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(reipeId).get();
            Byte[] imageByte = new Byte[file.getBytes().length];
            int i = 0;
            for (byte b : file.getBytes()) {
                imageByte[i++] = b;
            }
            recipe.setImage(imageByte);
            recipeRepository.save(recipe);
        } catch (IOException e) {
            // TODO: Better handling
            log.error("Error Occured", e);
            e.printStackTrace();
        }
    }
}
