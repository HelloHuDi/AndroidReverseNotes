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
            AppMethodBeat.m2504i(71540);
            LegacyTokenHelper legacyTokenHelper = new LegacyTokenHelper(FacebookSdk.getApplicationContext());
            AppMethodBeat.m2505o(71540);
            return legacyTokenHelper;
        }
    }

    AccessTokenCache(SharedPreferences sharedPreferences, SharedPreferencesTokenCachingStrategyFactory sharedPreferencesTokenCachingStrategyFactory) {
        this.sharedPreferences = sharedPreferences;
        this.tokenCachingStrategyFactory = sharedPreferencesTokenCachingStrategyFactory;
    }

    public AccessTokenCache() {
        this(FacebookSdk.getApplicationContext().getSharedPreferences(AccessTokenManager.SHARED_PREFERENCES_NAME, 0), new SharedPreferencesTokenCachingStrategyFactory());
        AppMethodBeat.m2504i(71541);
        AppMethodBeat.m2505o(71541);
    }

    public AccessToken load() {
        AppMethodBeat.m2504i(71542);
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
        AppMethodBeat.m2505o(71542);
        return accessToken;
    }

    public void save(AccessToken accessToken) {
        AppMethodBeat.m2504i(71543);
        Validate.notNull(accessToken, "accessToken");
        try {
            this.sharedPreferences.edit().putString(CACHED_ACCESS_TOKEN_KEY, accessToken.toJSONObject().toString()).apply();
            AppMethodBeat.m2505o(71543);
        } catch (JSONException e) {
            AppMethodBeat.m2505o(71543);
        }
    }

    public void clear() {
        AppMethodBeat.m2504i(71544);
        this.sharedPreferences.edit().remove(CACHED_ACCESS_TOKEN_KEY).apply();
        if (shouldCheckLegacyToken()) {
            getTokenCachingStrategy().clear();
        }
        AppMethodBeat.m2505o(71544);
    }

    private boolean hasCachedAccessToken() {
        AppMethodBeat.m2504i(71545);
        boolean contains = this.sharedPreferences.contains(CACHED_ACCESS_TOKEN_KEY);
        AppMethodBeat.m2505o(71545);
        return contains;
    }

    private AccessToken getCachedAccessToken() {
        AccessToken accessToken = null;
        AppMethodBeat.m2504i(71546);
        String string = this.sharedPreferences.getString(CACHED_ACCESS_TOKEN_KEY, accessToken);
        if (string != null) {
            try {
                accessToken = AccessToken.createFromJSONObject(new JSONObject(string));
                AppMethodBeat.m2505o(71546);
            } catch (JSONException e) {
                AppMethodBeat.m2505o(71546);
            }
        } else {
            AppMethodBeat.m2505o(71546);
        }
        return accessToken;
    }

    private boolean shouldCheckLegacyToken() {
        AppMethodBeat.m2504i(71547);
        boolean isLegacyTokenUpgradeSupported = FacebookSdk.isLegacyTokenUpgradeSupported();
        AppMethodBeat.m2505o(71547);
        return isLegacyTokenUpgradeSupported;
    }

    private AccessToken getLegacyAccessToken() {
        AppMethodBeat.m2504i(71548);
        AccessToken accessToken = null;
        Bundle load = getTokenCachingStrategy().load();
        if (load != null && LegacyTokenHelper.hasTokenInformation(load)) {
            accessToken = AccessToken.createFromLegacyCache(load);
        }
        AppMethodBeat.m2505o(71548);
        return accessToken;
    }

    private LegacyTokenHelper getTokenCachingStrategy() {
        AppMethodBeat.m2504i(71549);
        if (this.tokenCachingStrategy == null) {
            synchronized (this) {
                try {
                    if (this.tokenCachingStrategy == null) {
                        this.tokenCachingStrategy = this.tokenCachingStrategyFactory.create();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(71549);
                    }
                }
            }
        }
        LegacyTokenHelper legacyTokenHelper = this.tokenCachingStrategy;
        AppMethodBeat.m2505o(71549);
        return legacyTokenHelper;
    }
}
