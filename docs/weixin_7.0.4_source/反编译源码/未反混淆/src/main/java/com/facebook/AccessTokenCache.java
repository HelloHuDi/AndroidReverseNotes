package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONException;
import org.json.JSONObject;

class AccessTokenCache {
    static final String CACHED_ACCESS_TOKEN_KEY = "com.facebook.AccessTokenManager.CachedAccessToken";
    private final SharedPreferences sharedPreferences;
    private LegacyTokenHelper tokenCachingStrategy;
    private final SharedPreferencesTokenCachingStrategyFactory tokenCachingStrategyFactory;

    static class SharedPreferencesTokenCachingStrategyFactory {
        SharedPreferencesTokenCachingStrategyFactory() {
        }

        public LegacyTokenHelper create() {
            AppMethodBeat.i(71540);
            LegacyTokenHelper legacyTokenHelper = new LegacyTokenHelper(FacebookSdk.getApplicationContext());
            AppMethodBeat.o(71540);
            return legacyTokenHelper;
        }
    }

    AccessTokenCache(SharedPreferences sharedPreferences, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        this.sharedPreferences = sharedPreferences;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    public AccessTokenCache() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0), new SharedPreferencesTokenCachingStrategyFactory());
        AppMethodBeat.i(71541);
        AppMethodBeat.o(71541);
    }

    public AccessToken load() {
        AppMethodBeat.i(71542);
        AccessToken accessToken = null;
        if (hasCachedAccessToken()) {
            accessToken = getCachedAccessToken();
        } else if (shouldCheckLegacyToken()) {
            accessToken = getLegacyAccessToken();
            if (accessToken != null) {
                save(accessToken);
                getTokenCachingStrategy().clear();
            }
        }
        AppMethodBeat.o(71542);
        return accessToken;
    }

    public void save(AccessToken accessToken) {
        AppMethodBeat.i(71543);
        Validate.notNull(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_ACCESS_TOKEN_KEY, accessToken.toJSONObject().toString()).apply();
            AppMethodBeat.o(71543);
        } catch (JSONException e) {
            AppMethodBeat.o(71543);
        }
    }

    public void clear() {
        AppMethodBeat.i(71544);
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
        AppMethodBeat.o(71544);
    }

    private boolean hasCachedAccessToken() {
        AppMethodBeat.i(71545);
        boolean contains = this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
        AppMethodBeat.o(71545);
        return contains;
    }

    private AccessToken getCachedAccessToken() {
        AccessToken accessToken = null;
        AppMethodBeat.i(71546);
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, accessToken);
        if (string != null) {
            try {
                accessToken = AccessToken.createFromJSONObject(new JSONObject(string));
                AppMethodBeat.o(71546);
            } catch (JSONException e) {
                AppMethodBeat.o(71546);
            }
        } else {
            AppMethodBeat.o(71546);
        }
        return accessToken;
    }

    private boolean shouldCheckLegacyToken() {
        AppMethodBeat.i(71547);
        boolean isLegacyTokenUpgradeSupported = FacebookSdk.isLegacyTokenUpgradeSupported();
        AppMethodBeat.o(71547);
        return isLegacyTokenUpgradeSupported;
    }

    private AccessToken getLegacyAccessToken() {
        AppMethodBeat.i(71548);
        AccessToken accessToken = null;
        Bundle load = getTokenCachingStrategy().load();
        if (load != null && LegacyTokenHelper.hasTokenInformation(load)) {
            accessToken = AccessToken.createFromLegacyCache(load);
        }
        AppMethodBeat.o(71548);
        return accessToken;
    }

    private LegacyTokenHelper getTokenCachingStrategy() {
        AppMethodBeat.i(71549);
        if (this.tokenCachingStrategy == null) {
            synchronized (this) {
                try {
                    if (this.tokenCachingStrategy == null) {
                        this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71549);
                    }
                }
            }
        }
        LegacyTokenHelper legacyTokenHelper = this.tokenCachingStrategy;
        AppMethodBeat.o(71549);
        return legacyTokenHelper;
    }
}
