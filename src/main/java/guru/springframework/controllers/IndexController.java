package guru.springframework.controllers;

import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
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
        log.debug("Getting index page...");
        Long categoryId = categoryRepository.findByDescription("Italian").get().getId();
        Long unitOfMeasureId = unitOfMeasureRepository.findByDescription("Teaspoon").get().getId();
        System.out.println("Category ID is " + categoryId);
        System.out.println("Unit of Measure ID is " + unitOfMeasureId);
        return "index";
    }
}
