package fr.webnet.test.exposition.language;

import fr.webnet.test.exposition.language.dto.LanguageDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface LanguageApi {

    public ResponseEntity<List<LanguageDTO>> languages();
}
