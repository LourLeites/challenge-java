package ar.com.empresas.infraestructure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "ofpv.excel")
@Data
public class AppConfiguration {
    private AltaManualConfig altaManual;
}
