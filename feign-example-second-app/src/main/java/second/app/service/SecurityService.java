package second.app.service;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Service
public class SecurityService {

    @Value("${keycloak.auth-server-url}")
    private String keyCloakUrl;
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.realm}")
    private String realm;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getToken(String username, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("username", username);
        parameters.add("password", password);
        parameters.add("grant_type", "password");
        parameters.add("client_id", clientId);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(parameters, headers);

        return Objects.requireNonNull(restTemplate.exchange(getAuthUrl(),
                HttpMethod.POST,
                entity,
                AccessTokenResponse.class).getBody()).getToken();
    }

    private String getAuthUrl() {
        return UriComponentsBuilder.fromHttpUrl(keyCloakUrl)
                .pathSegment("realms")
                .pathSegment(realm)
                .pathSegment("protocol")
                .pathSegment("openid-connect")
                .pathSegment("token")
                .toUriString();
    }
}
