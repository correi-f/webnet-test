package fr.webnet.test.exposition;

import fr.webnet.test.application.RetrieveWelcomeMessage;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWebnet {

    private final RetrieveWelcomeMessage retrieveWelcomeMessage;

    public HelloWebnet(RetrieveWelcomeMessage retrieveWelcomeMessage) {
        this.retrieveWelcomeMessage = retrieveWelcomeMessage;
    }

    @ApiOperation(value = "Hello World Webnet")
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(retrieveWelcomeMessage.of());
    }
}
