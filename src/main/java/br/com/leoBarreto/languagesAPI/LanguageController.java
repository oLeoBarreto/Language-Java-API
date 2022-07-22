package br.com.leoBarreto.languagesAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository repository;

    @GetMapping("/languages")
    public List<Language> getLanguages() {
        List<Language> languages = repository.findAll();
        return languages;
    }

    @PostMapping("/languages")
    public Language postLanguage(@RequestBody Language language) {
        Language savedLanguage = repository.save(language);
        return savedLanguage;
    }

    @PutMapping("/languages")
    public Language putLanguage(@RequestParam String id, @RequestBody Language language) {
        Language languageUpdate = repository.findById(id).get();
        
        languageUpdate.setTitle(language.getTitle());
        languageUpdate.setImage(language.getImage());
        languageUpdate.setRanking(language.getRanking());

        return repository.save(languageUpdate);
    }

    @DeleteMapping("/languages")
    public void deleteLanguage(@RequestParam String id) {
        repository.deleteById(id);
    }
}
