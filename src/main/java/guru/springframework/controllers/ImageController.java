package guru.springframework.controllers;

import guru.springframework.services.ImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController {

    ImageService imageService;

    public ImageController() {}

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/recipes/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("file") MultipartFile multipartFile) {
        imageService.saveImageFile(Long.valueOf(id),multipartFile);
        return "redirect:/";
    }
}
