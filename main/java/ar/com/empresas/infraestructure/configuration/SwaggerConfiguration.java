package ar.com.empresas.infraestructure.configuration;

import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Configuration
public class SwaggerConfiguration {

    private static final String AUTOR_API = "challenge";
    private static final String BASE_PACKAGE = "ar.com.empresas";
    @Value("${application.name}")
    private String applicationName;
    @Value("${application.version}")
    private String version;

    @Bean
    public Docket swagger() {
        return new Docket(
                DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true);
    }

    private ApiInfo apiInfo() {
        // Agrego el html con los codigos de errores
        InputStream fileStream = this.getClass().getResourceAsStream("/api-description.html");
        String apiDescription = IOUtils.toString(fileStream, StandardCharsets.UTF_8);
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(apiDescription)
                .version(version)
                .contact(new Contact(AUTOR_API, null, null))
                .build();
    }
}