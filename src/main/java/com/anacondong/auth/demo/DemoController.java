package com.anacondong.auth.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.representations.AccessToken;

@RestController
public class DemoController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }

    @GetMapping("/secure")
    public String secureEndpoint(@AuthenticationPrincipal KeycloakPrincipal<?> principal) {
        AccessToken token = principal.getKeycloakSecurityContext().getToken();
        return "Hello " + token.getPreferredUsername();
    }
}
