package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;
import org.springframework.data.repository.CrudRepository;

public interface IngredientService {

    void deleteIngredient(Long id);
}
