package ar.com.empresas.infraestructure.configuration;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;

@Configuration
public class RestConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestConfig.class);
    private String trustStore;
    private String trustStorePassword;

    @Autowired
    public RestConfig(final PaasCommonsConfig paasCommonsConfig) {
        this.trustStore = paasCommonsConfig.getTrustStore();
        this.trustStorePassword = paasCommonsConfig.getTrustStorePassword();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder
                .requestFactory(this::validateSSL)
                .build();
    }

    private HttpComponentsClientHttpRequestFactory validateSSL() {
        try {
            SSLContext sslContext = SSLContextBuilder
                    .create()
                    .loadTrustMaterial(ResourceUtils.getFile(trustStore), trustStorePassword.toCharArray())
                    .build();
            SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
            CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();

            return new HttpComponentsClientHttpRequestFactory(httpClient);
        } catch (Exception ex) {
            LOGGER.error("***** Ocurrio un error al cargar el keystore.jks configurado. {}", ex.getMessage());
        }
        return null;
    }

}