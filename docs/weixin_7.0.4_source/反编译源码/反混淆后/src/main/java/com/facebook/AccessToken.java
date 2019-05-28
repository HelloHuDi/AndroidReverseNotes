package com.facebook;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.facebook.internal.Utility.GraphMeRequestWithCacheCallback;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AccessToken implements Parcelable {
    public static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String APPLICATION_ID_KEY = "application_id";
    public static final Creator<AccessToken> CREATOR = new C254722();
    private static final int CURRENT_JSON_FORMAT = 1;
    public static final String DATA_ACCESS_EXPIRATION_TIME = "data_access_expiration_time";
    private static final String DECLINED_PERMISSIONS_KEY = "declined_permissions";
    private static final AccessTokenSource DEFAULT_ACCESS_TOKEN_SOURCE = AccessTokenSource.FACEBOOK_APPLICATION_WEB;
    private static final Date DEFAULT_EXPIRATION_TIME;
    private static final Date DEFAULT_LAST_REFRESH_TIME = new Date();
    private static final String EXPIRES_AT_KEY = "expires_at";
    public static final String EXPIRES_IN_KEY = "expires_in";
    private static final String LAST_REFRESH_KEY = "last_refresh";
    private static final Date MAX_DATE;
    private static final String PERMISSIONS_KEY = "permissions";
    private static final String SOURCE_KEY = "source";
    private static final String TOKEN_KEY = "token";
    public static final String USER_ID_KEY = "user_id";
    private static final String VERSION_KEY = "version";
    private final String applicationId;
    private final Date dataAccessExpirationTime;
    private final Set<String> declinedPermissions;
    private final Date expires;
    private final Date lastRefresh;
    private final Set<String> permissions;
    private final AccessTokenSource source;
    private final String token;
    private final String userId;

    public interface AccessTokenCreationCallback {
        void onError(FacebookException facebookException);

        void onSuccess(AccessToken accessToken);
    }

    /* renamed from: com.facebook.AccessToken$2 */
    static class C254722 implements Creator {
        C254722() {
        }

        public final AccessToken createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(71510);
            AccessToken accessToken = new AccessToken(parcel);
            AppMethodBeat.m2505o(71510);
            return accessToken;
        }

        public final AccessToken[] newArray(int i) {
            return new AccessToken[i];
        }
    }

    public interface AccessTokenRefreshCallback {
        void OnTokenRefreshFailed(FacebookException facebookException);

        void OnTokenRefreshed(AccessToken accessToken);
    }

    static /* synthetic */ AccessToken access$000(List list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        AppMethodBeat.m2504i(71538);
        AccessToken createFromBundle = createFromBundle(list, bundle, accessTokenSource, date, str);
        AppMethodBeat.m2505o(71538);
        return createFromBundle;
    }

    static {
        AppMethodBeat.m2504i(71539);
        Date date = new Date(Long.MAX_VALUE);
        MAX_DATE = date;
        DEFAULT_EXPIRATION_TIME = date;
        AppMethodBeat.m2505o(71539);
    }

    public AccessToken(String str, String str2, String str3, Collection<String> collection, Collection<String> collection2, AccessTokenSource accessTokenSource, Date date, Date date2, Date date3) {
        AppMethodBeat.m2504i(71513);
        Validate.notNullOrEmpty(str, "accessToken");
        Validate.notNullOrEmpty(str2, "applicationId");
        Validate.notNullOrEmpty(str3, "userId");
        if (date == null) {
            date = DEFAULT_EXPIRATION_TIME;
        }
        this.expires = date;
        this.permissions = Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet());
        this.declinedPermissions = Collections.unmodifiableSet(collection2 != null ? new HashSet(collection2) : new HashSet());
        this.token = str;
        if (accessTokenSource == null) {
            accessTokenSource = DEFAULT_ACCESS_TOKEN_SOURCE;
        }
        this.source = accessTokenSource;
        if (date2 == null) {
            date2 = DEFAULT_LAST_REFRESH_TIME;
        }
        this.lastRefresh = date2;
        this.applicationId = str2;
        this.userId = str3;
        if (date3 == null || date3.getTime() == 0) {
            date3 = DEFAULT_EXPIRATION_TIME;
        }
        this.dataAccessExpirationTime = date3;
        AppMethodBeat.m2505o(71513);
    }

    public static AccessToken getCurrentAccessToken() {
        AppMethodBeat.m2504i(71514);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        AppMethodBeat.m2505o(71514);
        return currentAccessToken;
    }

    public static boolean isCurrentAccessTokenActive() {
        AppMethodBeat.m2504i(71515);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isExpired()) {
            AppMethodBeat.m2505o(71515);
            return false;
        }
        AppMethodBeat.m2505o(71515);
        return true;
    }

    public static boolean isDataAccessActive() {
        AppMethodBeat.m2504i(71516);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken == null || currentAccessToken.isDataAccessExpired()) {
            AppMethodBeat.m2505o(71516);
            return false;
        }
        AppMethodBeat.m2505o(71516);
        return true;
    }

    static void expireCurrentAccessToken() {
        AppMethodBeat.m2504i(71517);
        AccessToken currentAccessToken = AccessTokenManager.getInstance().getCurrentAccessToken();
        if (currentAccessToken != null) {
            setCurrentAccessToken(createExpired(currentAccessToken));
        }
        AppMethodBeat.m2505o(71517);
    }

    public static void setCurrentAccessToken(AccessToken accessToken) {
        AppMethodBeat.m2504i(71518);
        AccessTokenManager.getInstance().setCurrentAccessToken(accessToken);
        AppMethodBeat.m2505o(71518);
    }

    public static void refreshCurrentAccessTokenAsync() {
        AppMethodBeat.m2504i(71519);
        AccessTokenManager.getInstance().refreshCurrentAccessToken(null);
        AppMethodBeat.m2505o(71519);
    }

    public static void refreshCurrentAccessTokenAsync(AccessTokenRefreshCallback accessTokenRefreshCallback) {
        AppMethodBeat.m2504i(71520);
        AccessTokenManager.getInstance().refreshCurrentAccessToken(accessTokenRefreshCallback);
        AppMethodBeat.m2505o(71520);
    }

    public final String getToken() {
        return this.token;
    }

    public final Date getExpires() {
        return this.expires;
    }

    public final Date getDataAccessExpirationTime() {
        return this.dataAccessExpirationTime;
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    public final Set<String> getDeclinedPermissions() {
        return this.declinedPermissions;
    }

    public final AccessTokenSource getSource() {
        return this.source;
    }

    public final Date getLastRefresh() {
        return this.lastRefresh;
    }

    public final String getApplicationId() {
        return this.applicationId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public static void createFromNativeLinkingIntent(Intent intent, final String str, final AccessTokenCreationCallback accessTokenCreationCallback) {
        AppMethodBeat.m2504i(71521);
        Validate.notNull(intent, "intent");
        if (intent.getExtras() == null) {
            accessTokenCreationCallback.onError(new FacebookException("No extras found on intent"));
            AppMethodBeat.m2505o(71521);
            return;
        }
        final Bundle bundle = new Bundle(intent.getExtras());
        String string = bundle.getString("access_token");
        if (string == null || string.isEmpty()) {
            accessTokenCreationCallback.onError(new FacebookException("No access token found on intent"));
            AppMethodBeat.m2505o(71521);
            return;
        }
        String string2 = bundle.getString(USER_ID_KEY);
        if (string2 == null || string2.isEmpty()) {
            Utility.getGraphMeRequestWithCacheAsync(string, new GraphMeRequestWithCacheCallback() {
                public final void onSuccess(JSONObject jSONObject) {
                    AppMethodBeat.m2504i(71508);
                    try {
                        bundle.putString(AccessToken.USER_ID_KEY, jSONObject.getString("id"));
                        accessTokenCreationCallback.onSuccess(AccessToken.access$000(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
                        AppMethodBeat.m2505o(71508);
                    } catch (JSONException e) {
                        accessTokenCreationCallback.onError(new FacebookException("Unable to generate access token due to missing user id"));
                        AppMethodBeat.m2505o(71508);
                    }
                }

                public final void onFailure(FacebookException facebookException) {
                    AppMethodBeat.m2504i(71509);
                    accessTokenCreationCallback.onError(facebookException);
                    AppMethodBeat.m2505o(71509);
                }
            });
            AppMethodBeat.m2505o(71521);
            return;
        }
        accessTokenCreationCallback.onSuccess(createFromBundle(null, bundle, AccessTokenSource.FACEBOOK_APPLICATION_WEB, new Date(), str));
        AppMethodBeat.m2505o(71521);
    }

    public final String toString() {
        AppMethodBeat.m2504i(71522);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{AccessToken");
        stringBuilder.append(" token:").append(tokenToString());
        appendPermissions(stringBuilder);
        stringBuilder.append("}");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(71522);
        return stringBuilder2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(71523);
        if (this == obj) {
            AppMethodBeat.m2505o(71523);
            return true;
        } else if (obj instanceof AccessToken) {
            AccessToken accessToken = (AccessToken) obj;
            if (this.expires.equals(accessToken.expires) && this.permissions.equals(accessToken.permissions) && this.declinedPermissions.equals(accessToken.declinedPermissions) && this.token.equals(accessToken.token) && this.source == accessToken.source && this.lastRefresh.equals(accessToken.lastRefresh) && (!this.applicationId != null ? accessToken.applicationId == null : this.applicationId.equals(accessToken.applicationId)) && this.userId.equals(accessToken.userId) && this.dataAccessExpirationTime.equals(accessToken.dataAccessExpirationTime)) {
                AppMethodBeat.m2505o(71523);
                return true;
            }
            AppMethodBeat.m2505o(71523);
            return false;
        } else {
            AppMethodBeat.m2505o(71523);
            return false;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(71524);
        int hashCode = (((((this.applicationId == null ? 0 : this.applicationId.hashCode()) + ((((((((((((this.expires.hashCode() + JsApiGetABTestConfig.CTRL_INDEX) * 31) + this.permissions.hashCode()) * 31) + this.declinedPermissions.hashCode()) * 31) + this.token.hashCode()) * 31) + this.source.hashCode()) * 31) + this.lastRefresh.hashCode()) * 31)) * 31) + this.userId.hashCode()) * 31) + this.dataAccessExpirationTime.hashCode();
        AppMethodBeat.m2505o(71524);
        return hashCode;
    }

    @SuppressLint({"FieldGetter"})
    static AccessToken createFromRefresh(AccessToken accessToken, Bundle bundle) {
        AppMethodBeat.m2504i(71525);
        if (accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_WEB || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_NATIVE || accessToken.source == AccessTokenSource.FACEBOOK_APPLICATION_SERVICE) {
            Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, EXPIRES_IN_KEY, new Date(0));
            String string = bundle.getString("access_token");
            Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
            if (Utility.isNullOrEmpty(string)) {
                AppMethodBeat.m2505o(71525);
                return null;
            }
            AccessToken accessToken2 = new AccessToken(string, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.source, bundleLongAsDate, new Date(), bundleLongAsDate2);
            AppMethodBeat.m2505o(71525);
            return accessToken2;
        }
        FacebookException facebookException = new FacebookException("Invalid token source: " + accessToken.source);
        AppMethodBeat.m2505o(71525);
        throw facebookException;
    }

    static AccessToken createExpired(AccessToken accessToken) {
        AppMethodBeat.m2504i(71526);
        AccessToken accessToken2 = new AccessToken(accessToken.token, accessToken.applicationId, accessToken.getUserId(), accessToken.getPermissions(), accessToken.getDeclinedPermissions(), accessToken.source, new Date(), new Date(), accessToken.dataAccessExpirationTime);
        AppMethodBeat.m2505o(71526);
        return accessToken2;
    }

    static AccessToken createFromLegacyCache(Bundle bundle) {
        AppMethodBeat.m2504i(71527);
        List permissionsFromBundle = getPermissionsFromBundle(bundle, LegacyTokenHelper.PERMISSIONS_KEY);
        List permissionsFromBundle2 = getPermissionsFromBundle(bundle, LegacyTokenHelper.DECLINED_PERMISSIONS_KEY);
        String applicationId = LegacyTokenHelper.getApplicationId(bundle);
        if (Utility.isNullOrEmpty(applicationId)) {
            applicationId = FacebookSdk.getApplicationId();
        }
        String token = LegacyTokenHelper.getToken(bundle);
        try {
            AccessToken accessToken = new AccessToken(token, applicationId, Utility.awaitGetGraphMeRequestWithCache(token).getString("id"), permissionsFromBundle, permissionsFromBundle2, LegacyTokenHelper.getSource(bundle), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.EXPIRATION_DATE_KEY), LegacyTokenHelper.getDate(bundle, LegacyTokenHelper.LAST_REFRESH_DATE_KEY), null);
            AppMethodBeat.m2505o(71527);
            return accessToken;
        } catch (JSONException e) {
            AppMethodBeat.m2505o(71527);
            return null;
        }
    }

    static List<String> getPermissionsFromBundle(Bundle bundle, String str) {
        List<String> emptyList;
        AppMethodBeat.m2504i(71528);
        ArrayList stringArrayList = bundle.getStringArrayList(str);
        if (stringArrayList == null) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = Collections.unmodifiableList(new ArrayList(stringArrayList));
        }
        AppMethodBeat.m2505o(71528);
        return emptyList;
    }

    public final boolean isExpired() {
        AppMethodBeat.m2504i(71529);
        boolean after = new Date().after(this.expires);
        AppMethodBeat.m2505o(71529);
        return after;
    }

    public final boolean isDataAccessExpired() {
        AppMethodBeat.m2504i(71530);
        boolean after = new Date().after(this.dataAccessExpirationTime);
        AppMethodBeat.m2505o(71530);
        return after;
    }

    /* Access modifiers changed, original: final */
    public final JSONObject toJSONObject() {
        AppMethodBeat.m2504i(71531);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 1);
        jSONObject.put(TOKEN_KEY, this.token);
        jSONObject.put(EXPIRES_AT_KEY, this.expires.getTime());
        jSONObject.put("permissions", new JSONArray(this.permissions));
        jSONObject.put(DECLINED_PERMISSIONS_KEY, new JSONArray(this.declinedPermissions));
        jSONObject.put(LAST_REFRESH_KEY, this.lastRefresh.getTime());
        jSONObject.put("source", this.source.name());
        jSONObject.put(APPLICATION_ID_KEY, this.applicationId);
        jSONObject.put(USER_ID_KEY, this.userId);
        jSONObject.put(DATA_ACCESS_EXPIRATION_TIME, this.dataAccessExpirationTime.getTime());
        AppMethodBeat.m2505o(71531);
        return jSONObject;
    }

    static AccessToken createFromJSONObject(JSONObject jSONObject) {
        AppMethodBeat.m2504i(71532);
        if (jSONObject.getInt("version") > 1) {
            FacebookException facebookException = new FacebookException("Unknown AccessToken serialization format.");
            AppMethodBeat.m2505o(71532);
            throw facebookException;
        }
        String string = jSONObject.getString(TOKEN_KEY);
        Date date = new Date(jSONObject.getLong(EXPIRES_AT_KEY));
        JSONArray jSONArray = jSONObject.getJSONArray("permissions");
        JSONArray jSONArray2 = jSONObject.getJSONArray(DECLINED_PERMISSIONS_KEY);
        Date date2 = new Date(jSONObject.getLong(LAST_REFRESH_KEY));
        AccessTokenSource valueOf = AccessTokenSource.valueOf(jSONObject.getString("source"));
        AccessToken accessToken = new AccessToken(string, jSONObject.getString(APPLICATION_ID_KEY), jSONObject.getString(USER_ID_KEY), Utility.jsonArrayToStringList(jSONArray), Utility.jsonArrayToStringList(jSONArray2), valueOf, date, date2, new Date(jSONObject.getLong(DATA_ACCESS_EXPIRATION_TIME)));
        AppMethodBeat.m2505o(71532);
        return accessToken;
    }

    private static AccessToken createFromBundle(List<String> list, Bundle bundle, AccessTokenSource accessTokenSource, Date date, String str) {
        AppMethodBeat.m2504i(71533);
        String string = bundle.getString("access_token");
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, EXPIRES_IN_KEY, date);
        String string2 = bundle.getString(USER_ID_KEY);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string) || bundleLongAsDate == null) {
            AppMethodBeat.m2505o(71533);
            return null;
        }
        AccessToken accessToken = new AccessToken(string, str, string2, list, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
        AppMethodBeat.m2505o(71533);
        return accessToken;
    }

    private String tokenToString() {
        AppMethodBeat.m2504i(71534);
        String str;
        if (this.token == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(71534);
            return str;
        } else if (FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
            str = this.token;
            AppMethodBeat.m2505o(71534);
            return str;
        } else {
            str = "ACCESS_TOKEN_REMOVED";
            AppMethodBeat.m2505o(71534);
            return str;
        }
    }

    private void appendPermissions(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(71535);
        stringBuilder.append(" permissions:");
        if (this.permissions == null) {
            stringBuilder.append(BuildConfig.COMMAND);
            AppMethodBeat.m2505o(71535);
            return;
        }
        stringBuilder.append("[");
        stringBuilder.append(TextUtils.join(", ", this.permissions));
        stringBuilder.append("]");
        AppMethodBeat.m2505o(71535);
    }

    AccessToken(Parcel parcel) {
        AppMethodBeat.m2504i(71536);
        this.expires = new Date(parcel.readLong());
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        this.permissions = Collections.unmodifiableSet(new HashSet(arrayList));
        arrayList.clear();
        parcel.readStringList(arrayList);
        this.declinedPermissions = Collections.unmodifiableSet(new HashSet(arrayList));
        this.token = parcel.readString();
        this.source = AccessTokenSource.valueOf(parcel.readString());
        this.lastRefresh = new Date(parcel.readLong());
        this.applicationId = parcel.readString();
        this.userId = parcel.readString();
        this.dataAccessExpirationTime = new Date(parcel.readLong());
        AppMethodBeat.m2505o(71536);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71537);
        parcel.writeLong(this.expires.getTime());
        parcel.writeStringList(new ArrayList(this.permissions));
        parcel.writeStringList(new ArrayList(this.declinedPermissions));
        parcel.writeString(this.token);
        parcel.writeString(this.source.name());
        parcel.writeLong(this.lastRefresh.getTime());
        parcel.writeString(this.applicationId);
        parcel.writeString(this.userId);
        parcel.writeLong(this.dataAccessExpirationTime.getTime());
        AppMethodBeat.m2505o(71537);
    }
}
