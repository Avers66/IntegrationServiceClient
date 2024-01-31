package avers66.serviceremote.configuration;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClientConfiguration
 *
 * @Author Tretyakov Alexandr
 */

@Configuration
public class ClientConfiguration {

    @Bean
    public OkHttpClient getOkHttp() {
        return new OkHttpClient();
    }
}
