package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        Long categoryId = categoryRepository.findByDescription("Italian").get().getId();
        Long unitOfMeasureId = unitOfMeasureRepository.findByDescription("Teaspoon").get().getId();
        System.out.println("Category ID is " + categoryId);
        System.out.println("Unit of Measure ID is " + unitOfMeasureId);
        return "index";
    }
}
