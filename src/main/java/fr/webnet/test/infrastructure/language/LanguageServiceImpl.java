package fr.webnet.test.infrastructure.language;

import fr.webnet.test.domain.language.Language;
import fr.webnet.test.domain.language.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageAdapter languageAdapter;

    @Autowired
    public LanguageServiceImpl(LanguageRepository languageRepository, LanguageAdapter languageAdapter) {
        this.languageRepository = languageRepository;
        this.languageAdapter = languageAdapter;
    }

    @Override
    public List<Language> retrieveLanguages() {
        return languageRepository.findAll().stream().map(languageAdapter::apply).collect(Collectors.toList());
    }
}
