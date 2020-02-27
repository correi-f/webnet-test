package fr.webnet.test.exposition.language;

import fr.webnet.test.exposition.language.dto.LanguageDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface LanguageApi {

    @ApiOperation(value = "Retrieve all languages.")
    @GetMapping("/languages")
    public ResponseEntity<List<LanguageDTO>> languages();
}
