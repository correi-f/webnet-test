package fr.webnet.test.exposition;

import fr.webnet.test.application.RetrieveWelcomeMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWebnet {

    private final RetrieveWelcomeMessage retrieveWelcomeMessage;

    public HelloWebnet(RetrieveWelcomeMessage retrieveWelcomeMessage) {
        this.retrieveWelcomeMessage = retrieveWelcomeMessage;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(retrieveWelcomeMessage.of());
    }
}
