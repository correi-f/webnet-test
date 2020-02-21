package fr.webnet.test.exposition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ExpositionConfiguration {

    @Bean
    public Docket webnetApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("fr.webnet.test.exposition"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(webnetApiInfo());
    }

    private ApiInfo webnetApiInfo() {
        return new ApiInfoBuilder()
                .title("Webnet Test Api")
                .description("Test Application for the newcomers")
                .contact(new Contact("Frédéric CORREIA", "https://github.com/correi-f", "fcorreia@webnet.fr"))
                .version("0.0.1")
                .build();
    }
}
