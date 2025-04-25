package ar.com.empresas.infraestructure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "paas.commons.starter")
@Data
public class PaasCommonsConfig {
    private String trustStore;
    private String trustStorePassword;
    private String apimAppId;
    private String apimAppKey;
    private String channel;
}
