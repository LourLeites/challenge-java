package ar.com.empresas;

import ar.com.empresas.infraestructure.configuration.AltaManualConfig;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.request.RequestContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Start up the Spring Boot Application
 */
@SpringBootApplication
public class ChallengeJavaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChallengeJavaApplication.class);

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

    @Bean
    public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
        return factory -> factory.setRegisterDefaultServlet(true);
    }

    @Bean
    public FTPClient ftpClient() {
        return new FTPClient();
    }

    @Bean
    public AltaManualConfig altaManualConfig() {
        return new AltaManualConfig();
    }

    /**
     * Main method to invoke the embedded tomcat server
     */
    public static void main(String[] args) {
        SpringApplication.run(ChallengeJavaApplication.class, args);
        LOGGER.info("The application is now running...");
    }
}