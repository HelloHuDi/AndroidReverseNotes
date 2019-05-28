package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.d;
import com.facebook.AccessToken.AccessTokenRefreshCallback;
import com.facebook.GraphRequest.Callback;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AccessTokenManager {
    public static final String ACTION_CURRENT_ACCESS_TOKEN_CHANGED = "com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED";
    public static final String EXTRA_NEW_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN";
    public static final String EXTRA_OLD_ACCESS_TOKEN = "com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN";
    private static final String ME_PERMISSIONS_GRAPH_PATH = "me/permissions";
    public static final String SHARED_PREFERENCES_NAME = "com.facebook.AccessTokenManager.SharedPreferences";
    public static final String TAG = "AccessTokenManager";
    private static final String TOKEN_EXTEND_GRAPH_PATH = "oauth/access_token";
    private static final int TOKEN_EXTEND_RETRY_SECONDS = 3600;
    private static final int TOKEN_EXTEND_THRESHOLD_SECONDS = 86400;
    private static volatile AccessTokenManager instance;
    private final AccessTokenCache accessTokenCache;
    private AccessToken currentAccessToken;
    private Date lastAttemptedTokenExtendDate = new Date(0);
    private final d localBroadcastManager;
    private AtomicBoolean tokenRefreshInProgress = new AtomicBoolean(false);

    static class RefreshResult {
        public String accessToken;
        public Long dataAccessExpirationTime;
        public int expiresAt;

        private RefreshResult() {
        }

        /* synthetic */ RefreshResult(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static /* synthetic */ void access$000(AccessTokenManager accessTokenManager, AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(71568);
        accessTokenManager.refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
        AppMethodBeat.o(71568);
    }

    AccessTokenManager(d dVar, AccessTokenCache accessTokenCache) {
        AppMethodBeat.i(71554);
        Validate.notNull(dVar, "localBroadcastManager");
        Validate.notNull(accessTokenCache, "accessTokenCache");
        this.localBroadcastManager = dVar;
        this.accessTokenCache = accessTokenCache;
        AppMethodBeat.o(71554);
    }

    static AccessTokenManager getInstance() {
        AppMethodBeat.i(71555);
        if (instance == null) {
            synchronized (AccessTokenManager.class) {
                try {
                    if (instance == null) {
                        instance = new AccessTokenManager(d.S(FacebookSdk.getApplicationContext()), new AccessTokenCache());
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71555);
                    }
                }
            }
        }
        AccessTokenManager accessTokenManager = instance;
        AppMethodBeat.o(71555);
        return accessTokenManager;
    }

    /* Access modifiers changed, original: final */
    public final AccessToken getCurrentAccessToken() {
        return this.currentAccessToken;
    }

    /* Access modifiers changed, original: final */
    public final boolean loadCurrentAccessToken() {
        AppMethodBeat.i(71556);
        AccessToken load = this.accessTokenCache.load();
        if (load != null) {
            setCurrentAccessToken(load, false);
            AppMethodBeat.o(71556);
            return true;
        }
        AppMethodBeat.o(71556);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void setCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(71557);
        setCurrentAccessToken(accessToken, true);
        AppMethodBeat.o(71557);
    }

    private void setCurrentAccessToken(AccessToken accessToken, boolean z) {
        AppMethodBeat.i(71558);
        AccessToken accessToken2 = this.currentAccessToken;
        this.currentAccessToken = accessToken;
        this.tokenRefreshInProgress.set(false);
        this.lastAttemptedTokenExtendDate = new Date(0);
        if (z) {
            if (accessToken != null) {
                this.accessTokenCache.save(accessToken);
            } else {
                this.accessTokenCache.clear();
                Utility.clearFacebookCookies(FacebookSdk.getApplicationContext());
            }
        }
        if (!Utility.areObjectsEqual(accessToken2, accessToken)) {
            sendCurrentAccessTokenChangedBroadcastIntent(accessToken2, accessToken);
            setTokenExpirationBroadcastAlarm();
        }
        AppMethodBeat.o(71558);
    }

    /* Access modifiers changed, original: final */
    public final void currentAccessTokenChanged() {
        AppMethodBeat.i(71559);
        sendCurrentAccessTokenChangedBroadcastIntent(this.currentAccessToken, this.currentAccessToken);
        AppMethodBeat.o(71559);
    }

    private void sendCurrentAccessTokenChangedBroadcastIntent(AccessToken accessToken, AccessToken accessToken2) {
        AppMethodBeat.i(71560);
        Intent intent = new Intent(FacebookSdk.getApplicationContext(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        intent.putExtra(EXTRA_OLD_ACCESS_TOKEN, accessToken);
        intent.putExtra(EXTRA_NEW_ACCESS_TOKEN, accessToken2);
        this.localBroadcastManager.c(intent);
        AppMethodBeat.o(71560);
    }

    private void setTokenExpirationBroadcastAlarm() {
        AppMethodBeat.i(71561);
        Context applicationContext = FacebookSdk.getApplicationContext();
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AlarmManager alarmManager = (AlarmManager) applicationContext.getSystemService("alarm");
        if (!AccessToken.isCurrentAccessTokenActive() || currentAccessToken.getExpires() == null || alarmManager == null) {
            AppMethodBeat.o(71561);
            return;
        }
        Intent intent = new Intent(applicationContext, CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction(ACTION_CURRENT_ACCESS_TOKEN_CHANGED);
        alarmManager.set(1, currentAccessToken.getExpires().getTime(), PendingIntent.getBroadcast(applicationContext, 0, intent, 0));
        AppMethodBeat.o(71561);
    }

    /* Access modifiers changed, original: final */
    public final void extendAccessTokenIfNeeded() {
        AppMethodBeat.i(71562);
        if (shouldExtendAccessToken()) {
            refreshCurrentAccessToken(null);
            AppMethodBeat.o(71562);
            return;
        }
        AppMethodBeat.o(71562);
    }

    private boolean shouldExtendAccessToken() {
        AppMethodBeat.i(71563);
        if (this.currentAccessToken == null) {
            AppMethodBeat.o(71563);
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        if (!this.currentAccessToken.getSource().canExtendToken() || valueOf.longValue() - this.lastAttemptedTokenExtendDate.getTime() <= 3600000 || valueOf.longValue() - this.currentAccessToken.getLastRefresh().getTime() <= 86400000) {
            AppMethodBeat.o(71563);
            return false;
        }
        AppMethodBeat.o(71563);
        return true;
    }

    private static GraphRequest createGrantedPermissionsRequest(AccessToken accessToken, Callback callback) {
        AppMethodBeat.i(71564);
        AccessToken accessToken2 = accessToken;
        GraphRequest graphRequest = new GraphRequest(accessToken2, ME_PERMISSIONS_GRAPH_PATH, new Bundle(), HttpMethod.GET, callback);
        AppMethodBeat.o(71564);
        return graphRequest;
    }

    private static GraphRequest createExtendAccessTokenRequest(AccessToken accessToken, Callback callback) {
        AppMethodBeat.i(71565);
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        GraphRequest graphRequest = new GraphRequest(accessToken, TOKEN_EXTEND_GRAPH_PATH, bundle, HttpMethod.GET, callback);
        AppMethodBeat.o(71565);
        return graphRequest;
    }

    /* Access modifiers changed, original: final */
    public final void refreshCurrentAccessToken(final AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(71566);
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            refreshCurrentAccessTokenImpl(accessTokenRefreshCallback);
            AppMethodBeat.o(71566);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                AppMethodBeat.i(71550);
                AccessTokenManager.access$000(AccessTokenManager.this, accessTokenRefreshCallback);
                AppMethodBeat.o(71550);
            }
        });
        AppMethodBeat.o(71566);
    }

    private void refreshCurrentAccessTokenImpl(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.i(71567);
        final AccessToken accessToken = this.currentAccessToken;
        if (accessToken == null) {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
            }
            AppMethodBeat.o(71567);
        } else if (this.tokenRefreshInProgress.compareAndSet(false, true)) {
            this.lastAttemptedTokenExtendDate = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final RefreshResult refreshResult = new RefreshResult();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(createGrantedPermissionsRequest(accessToken, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(71551);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        AppMethodBeat.o(71551);
                        return;
                    }
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray == null) {
                        AppMethodBeat.o(71551);
                        return;
                    }
                    atomicBoolean.set(true);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("permission");
                            String optString2 = optJSONObject.optString("status");
                            if (!(Utility.isNullOrEmpty(optString) || Utility.isNullOrEmpty(optString2))) {
                                optString2 = optString2.toLowerCase(Locale.US);
                                if (optString2.equals("granted")) {
                                    hashSet.add(optString);
                                } else if (optString2.equals("declined")) {
                                    hashSet2.add(optString);
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(71551);
                }
            }), createExtendAccessTokenRequest(accessToken, new Callback() {
                public void onCompleted(GraphResponse graphResponse) {
                    AppMethodBeat.i(71552);
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    if (jSONObject == null) {
                        AppMethodBeat.o(71552);
                        return;
                    }
                    refreshResult.accessToken = jSONObject.optString("access_token");
                    refreshResult.expiresAt = jSONObject.optInt("expires_at");
                    refreshResult.dataAccessExpirationTime = Long.valueOf(jSONObject.optLong(AccessToken.DATA_ACCESS_EXPIRATION_TIME));
                    AppMethodBeat.o(71552);
                }
            }));
            final AccessTokenRefreshCallback accessTokenRefreshCallback2 = accessTokenRefreshCallback;
            graphRequestBatch.addCallback(new GraphRequestBatch.Callback() {
                public void onBatchCompleted(GraphRequestBatch graphRequestBatch) {
                    Throwable th;
                    AccessToken accessToken;
                    AppMethodBeat.i(71553);
                    try {
                        if (AccessTokenManager.getInstance().getCurrentAccessToken() == null || AccessTokenManager.getInstance().getCurrentAccessToken().getUserId() != accessToken.getUserId()) {
                            if (accessTokenRefreshCallback2 != null) {
                                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("No current access token to refresh"));
                            }
                            AccessTokenManager.this.tokenRefreshInProgress.set(false);
                            AppMethodBeat.o(71553);
                        } else if (!atomicBoolean.get() && refreshResult.accessToken == null && refreshResult.expiresAt == 0) {
                            if (accessTokenRefreshCallback2 != null) {
                                accessTokenRefreshCallback2.OnTokenRefreshFailed(new FacebookException("Failed to refresh access token"));
                            }
                            AccessTokenManager.this.tokenRefreshInProgress.set(false);
                            AppMethodBeat.o(71553);
                        } else {
                            String str;
                            Collection collection;
                            Collection collection2;
                            Date date;
                            Date date2;
                            if (refreshResult.accessToken != null) {
                                str = refreshResult.accessToken;
                            } else {
                                str = accessToken.getToken();
                            }
                            String applicationId = accessToken.getApplicationId();
                            String userId = accessToken.getUserId();
                            if (atomicBoolean.get()) {
                                collection = hashSet;
                            } else {
                                collection = accessToken.getPermissions();
                            }
                            if (atomicBoolean.get()) {
                                collection2 = hashSet2;
                            } else {
                                collection2 = accessToken.getDeclinedPermissions();
                            }
                            AccessTokenSource source = accessToken.getSource();
                            if (refreshResult.expiresAt != 0) {
                                date = new Date(((long) refreshResult.expiresAt) * 1000);
                            } else {
                                date = accessToken.getExpires();
                            }
                            Date date3 = new Date();
                            if (refreshResult.dataAccessExpirationTime != null) {
                                date2 = new Date(refreshResult.dataAccessExpirationTime.longValue() * 1000);
                            } else {
                                date2 = accessToken.getDataAccessExpirationTime();
                            }
                            AccessToken accessToken2 = new AccessToken(str, applicationId, userId, collection, collection2, source, date, date3, date2);
                            try {
                                AccessTokenManager.getInstance().setCurrentAccessToken(accessToken2);
                                AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                if (accessTokenRefreshCallback2 != null) {
                                    accessTokenRefreshCallback2.OnTokenRefreshed(accessToken2);
                                    AppMethodBeat.o(71553);
                                    return;
                                }
                                AppMethodBeat.o(71553);
                            } catch (Throwable th2) {
                                th = th2;
                                accessToken = accessToken2;
                                AccessTokenManager.this.tokenRefreshInProgress.set(false);
                                if (!(accessTokenRefreshCallback2 == null || accessToken == null)) {
                                    accessTokenRefreshCallback2.OnTokenRefreshed(accessToken);
                                }
                                AppMethodBeat.o(71553);
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        accessToken = null;
                        AccessTokenManager.this.tokenRefreshInProgress.set(false);
                        accessTokenRefreshCallback2.OnTokenRefreshed(accessToken);
                        AppMethodBeat.o(71553);
                        throw th;
                    }
                }
            });
            graphRequestBatch.executeAsync();
            AppMethodBeat.o(71567);
        } else {
            if (accessTokenRefreshCallback != null) {
                accessTokenRefreshCallback.OnTokenRefreshFailed(new FacebookException("Refresh already in progress"));
            }
            AppMethodBeat.o(71567);
        }
    }
}
