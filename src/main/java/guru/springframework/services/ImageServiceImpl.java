package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
public class ImageServiceImpl implements ImageService {

    RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long id, MultipartFile image) {
        log.info("Saving uploaded file...");

        Recipe recipe = recipeRepository.findById(id).get();

        try {
            Byte[] byteObjects = new Byte[image.getBytes().length];

            int i = 0;

            for(byte b: image.getBytes()) {
                byteObjects[i++] = b;
            }

            recipe.setImage(byteObjects);
            recipeRepository.save(recipe);

        } catch(IOException ioe) {
            log.error("Error occurred while attempting to save image file: " + ioe.getLocalizedMessage());
        }
    }
}
