package fr.webnet.test.infrastructure.language;

import fr.webnet.test.domain.language.Language;
import fr.webnet.test.infrastructure.language.dto.LanguageEntity;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
class LanguageAdapter implements Function<LanguageEntity, Language> {

    @Override
    public Language apply(LanguageEntity languageEntity) {
        return new Language(languageEntity.getName(), languageEntity.getDescription());
    }
}
