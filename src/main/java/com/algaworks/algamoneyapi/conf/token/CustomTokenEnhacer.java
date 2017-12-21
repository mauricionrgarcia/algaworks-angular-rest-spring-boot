package com.algaworks.algamoneyapi.conf.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.algaworks.algamoneyapi.security.util.AppSystemUser;

/**
 * Custom {@link TokenEnhancer}
 *
 * @author <a href="mailto:mauricionrgarcia@gmail.com">Mauricio</a>
 * @version
 * @sinse 20/12/2017 23:08:04
 */
public class CustomTokenEnhacer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		AppSystemUser user = (AppSystemUser) authentication.getPrincipal();

		Map<String, Object> additionalInformation = new HashMap<>();
		additionalInformation.put("name", user.getUser().getName());

		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
		return accessToken;
	}

}
