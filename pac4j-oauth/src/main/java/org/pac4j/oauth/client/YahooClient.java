package org.pac4j.oauth.client;

import com.github.scribejava.apis.YahooApi;
import org.pac4j.core.context.WebContext;
import org.pac4j.oauth.profile.yahoo.YahooProfile;
import org.pac4j.oauth.profile.yahoo.YahooProfileCreator;
import org.pac4j.oauth.profile.yahoo.YahooProfileDefinition;

/**
 * <p>This class is the OAuth client to authenticate users in Yahoo.</p>
 * <p>It returns a {@link org.pac4j.oauth.profile.yahoo.YahooProfile}.</p>
 * <p>More information at http://developer.yahoo.com/social/rest_api_guide/extended-profile-resource.html</p>
 *
 * @author Jerome Leleu
 * @since 1.0.0
 */
public class YahooClient extends OAuth10Client<YahooProfile> {

    public YahooClient() {
    }

    public YahooClient(final String key, final String secret) {
        setKey(key);
        setSecret(secret);
    }

    @Override
    protected void internalInit(final WebContext context) {
        configuration.setApi(YahooApi.instance());
        configuration.setProfileDefinition(new YahooProfileDefinition());
        setConfiguration(configuration);
        setProfileCreator(new YahooProfileCreator(configuration));

        super.internalInit(context);
    }
}
