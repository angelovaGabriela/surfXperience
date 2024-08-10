package b.softuni.surfApp.config;

import b.softuni.surfApp.service.JwtService;
import b.softuni.surfApp.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Configuration
public class RestConfig {



    @Bean("genericRestClient")
    public RestClient genericRestClient() {
        return RestClient.create();
    }

    @Bean("storiesRestClient")
    public RestClient storyRestClient(StoryApiConfig storyApiConfig,
                                      ClientHttpRequestInterceptor requestInterceptor) {
        return RestClient
                .builder()
                .baseUrl(storyApiConfig.getBaseUrl())
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .requestInterceptor(requestInterceptor)
                .build();
    }

    @Bean
    public ClientHttpRequestInterceptor requestInterceptor(UserService userService, JwtService jwtService) {
        return (r,b,e) -> {
            userService.getCurrentUser()
                    .ifPresent(surfAppUserDetails -> {
                        String bearerToken = jwtService.generateToken(
                                surfAppUserDetails.getUuid().toString(),
                                Map.of(
                                        "roles",
                                        surfAppUserDetails.getAuthorities().stream()
                                                .map(GrantedAuthority::getAuthority).toList(),
                                        "user",
                                        surfAppUserDetails.getUuid().toString()
                                )
                        );
                        r.getHeaders().setBearerAuth(bearerToken);
                    });

            return e.execute(r, b);
        };
    }
}
