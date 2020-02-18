package fr.webnet.test.exposition.language;

import fr.webnet.test.application.RetrieveLanguage;
import fr.webnet.test.domain.language.Language;
import fr.webnet.test.exposition.language.dto.LanguageDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LanguageApiImpl implements LanguageApi {

    private final RetrieveLanguage retrieveLanguage;

    LanguageApiImpl(RetrieveLanguage retrieveLanguage) {
        this.retrieveLanguage = retrieveLanguage;
    }

    @Override
    @GetMapping("/languages")
    public ResponseEntity<List<LanguageDTO>> languages() {
        return ResponseEntity.ok(retrieveLanguage.of().stream()
                .map(this::adaptToResponse).collect(Collectors.toList()));
    }

    private LanguageDTO adaptToResponse(Language language) {
        return new LanguageDTO(language.value(), language.description());
    }
}
