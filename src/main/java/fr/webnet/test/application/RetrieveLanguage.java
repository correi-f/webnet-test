package fr.webnet.test.application;

import fr.webnet.test.domain.language.Language;
import fr.webnet.test.domain.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrieveLanguage {

    private final LanguageService languageService;

    @Autowired
    public RetrieveLanguage(LanguageService languageService) {
        this.languageService = languageService;
    }

    public List<Language> of() {
        return languageService.retrieveLanguages();
    }
}
