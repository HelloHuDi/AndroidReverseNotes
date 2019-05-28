package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient.Request;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

abstract class LoginMethodHandler implements Parcelable {
    protected LoginClient loginClient;
    Map<String, String> methodLoggingExtras;

    public abstract String getNameForLogging();

    public abstract boolean tryAuthorize(Request request);

    LoginMethodHandler(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    LoginMethodHandler(Parcel parcel) {
        this.methodLoggingExtras = Utility.readStringMapFromParcel(parcel);
    }

    /* Access modifiers changed, original: 0000 */
    public void setLoginClient(LoginClient loginClient) {
        if (this.loginClient != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.loginClient = loginClient;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean onActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean needsInternetPermission() {
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public void cancel() {
    }

    /* Access modifiers changed, original: 0000 */
    public void putChallengeParam(JSONObject jSONObject) {
    }

    /* Access modifiers changed, original: protected */
    public String getClientState(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", getNameForLogging());
            putChallengeParam(jSONObject);
        } catch (JSONException e) {
            new StringBuilder("Error creating client state json: ").append(e.getMessage());
        }
        return jSONObject.toString();
    }

    /* Access modifiers changed, original: protected */
    public void addLoggingExtra(String str, Object obj) {
        if (this.methodLoggingExtras == null) {
            this.methodLoggingExtras = new HashMap();
        }
        this.methodLoggingExtras.put(str, obj == null ? null : obj.toString());
    }

    /* Access modifiers changed, original: protected */
    public void logWebLoginCompleted(String str) {
        String applicationId = this.loginClient.getPendingRequest().getApplicationId();
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.loginClient.getActivity(), applicationId);
        Bundle bundle = new Bundle();
        bundle.putString(AnalyticsEvents.PARAMETER_WEB_LOGIN_E2E, str);
        bundle.putLong(AnalyticsEvents.PARAMETER_WEB_LOGIN_SWITCHBACK_TIME, System.currentTimeMillis());
        bundle.putString("app_id", applicationId);
        newLogger.logSdkEvent(AnalyticsEvents.EVENT_WEB_LOGIN_COMPLETE, null, bundle);
    }

    static AccessToken createAccessTokenFromNativeLogin(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
        ArrayList stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
        String string = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString(NativeProtocol.EXTRA_USER_ID), stringArrayList, null, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
    }

    public static AccessToken createAccessTokenFromWebBundle(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Collection arrayList;
        Collection collection2;
        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, AccessToken.EXPIRES_IN_KEY, new Date());
        String string = bundle.getString("access_token");
        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, AccessToken.DATA_ACCESS_EXPIRATION_TIME, new Date(0));
        String string2 = bundle.getString("granted_scopes");
        if (Utility.isNullOrEmpty(string2)) {
            Collection<String> arrayList2 = collection;
        } else {
            arrayList2 = new ArrayList(Arrays.asList(string2.split(",")));
        }
        string2 = bundle.getString("denied_scopes");
        if (Utility.isNullOrEmpty(string2)) {
            collection2 = null;
        } else {
            collection2 = new ArrayList(Arrays.asList(string2.split(",")));
        }
        if (Utility.isNullOrEmpty(string)) {
            return null;
        }
        return new AccessToken(string, str, getUserIDFromSignedRequest(bundle.getString("signed_request")), arrayList2, collection2, accessTokenSource, bundleLongAsDate, new Date(), bundleLongAsDate2);
    }

    static String getUserIDFromSignedRequest(String str) {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString(AccessToken.USER_ID_KEY);
            }
        } catch (UnsupportedEncodingException | JSONException e) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Utility.writeStringMapToParcel(parcel, this.methodLoggingExtras);
    }
}
