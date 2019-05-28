package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginClient.Request;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class LoginLogger {
    static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    static final String EVENT_EXTRAS_FAILURE = "failure";
    static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    static final String EVENT_PARAM_EXTRAS = "6_extras";
    static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    static final String EVENT_PARAM_METHOD = "3_method";
    static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private final AppEventsLogger appEventsLogger;
    private String applicationId;
    private String facebookVersion;

    LoginLogger(Context context, String str) {
        AppMethodBeat.m2504i(96857);
        this.applicationId = str;
        this.appEventsLogger = AppEventsLogger.newLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                PackageInfo packageInfo = packageManager.getPackageInfo(FACEBOOK_PACKAGE_NAME, 0);
                if (packageInfo != null) {
                    this.facebookVersion = packageInfo.versionName;
                }
            }
            AppMethodBeat.m2505o(96857);
        } catch (NameNotFoundException e) {
            AppMethodBeat.m2505o(96857);
        }
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    static Bundle newAuthorizationLoggingBundle(String str) {
        AppMethodBeat.m2504i(96858);
        Bundle bundle = new Bundle();
        bundle.putLong(EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        bundle.putString(EVENT_PARAM_AUTH_LOGGER_ID, str);
        bundle.putString(EVENT_PARAM_METHOD, "");
        bundle.putString(EVENT_PARAM_LOGIN_RESULT, "");
        bundle.putString(EVENT_PARAM_ERROR_MESSAGE, "");
        bundle.putString(EVENT_PARAM_ERROR_CODE, "");
        bundle.putString(EVENT_PARAM_EXTRAS, "");
        AppMethodBeat.m2505o(96858);
        return bundle;
    }

    public void logStartLogin(Request request) {
        AppMethodBeat.m2504i(96859);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(EVENT_EXTRAS_LOGIN_BEHAVIOR, request.getLoginBehavior().toString());
            jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, LoginClient.getLoginRequestCode());
            jSONObject.put("permissions", TextUtils.join(",", request.getPermissions()));
            jSONObject.put("default_audience", request.getDefaultAudience().toString());
            jSONObject.put(EVENT_EXTRAS_IS_REAUTHORIZE, request.isRerequest());
            if (this.facebookVersion != null) {
                jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, this.facebookVersion);
            }
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
        } catch (JSONException e) {
        }
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_START, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96859);
    }

    public void logCompleteLogin(String str, Map<String, String> map, Code code, Map<String, String> map2, Exception exception) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(96860);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (code != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
        }
        if (!(exception == null || exception.getMessage() == null)) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exception.getMessage());
        }
        if (map.isEmpty()) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject(map);
        }
        if (map2 != null) {
            JSONObject jSONObject2;
            if (jSONObject == null) {
                jSONObject2 = new JSONObject();
            } else {
                jSONObject2 = jSONObject;
            }
            try {
                for (Entry entry : map2.entrySet()) {
                    jSONObject2.put((String) entry.getKey(), entry.getValue());
                }
                jSONObject = jSONObject2;
            } catch (JSONException e) {
                jSONObject = jSONObject2;
            }
        }
        if (jSONObject != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, jSONObject.toString());
        }
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96860);
    }

    public void logAuthorizationMethodStart(String str, String str2) {
        AppMethodBeat.m2504i(96861);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_START, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96861);
    }

    public void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        AppMethodBeat.m2504i(96862);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        if (str3 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
        }
        if (str4 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
        }
        if (str5 != null) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
        }
        if (!(map == null || map.isEmpty())) {
            newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, new JSONObject(map).toString());
        }
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96862);
    }

    public void logAuthorizationMethodNotTried(String str, String str2) {
        AppMethodBeat.m2504i(96863);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_METHOD_NOT_TRIED, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96863);
    }

    public void logLoginStatusStart(String str) {
        AppMethodBeat.m2504i(96864);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_START, null, newAuthorizationLoggingBundle(str));
        AppMethodBeat.m2505o(96864);
    }

    public void logLoginStatusSuccess(String str) {
        AppMethodBeat.m2504i(96865);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, Code.SUCCESS.getLoggingValue());
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96865);
    }

    public void logLoginStatusFailure(String str) {
        AppMethodBeat.m2504i(96866);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, EVENT_EXTRAS_FAILURE);
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96866);
    }

    public void logLoginStatusError(String str, Exception exception) {
        AppMethodBeat.m2504i(96867);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle(str);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exception.toString());
        this.appEventsLogger.logSdkEvent(EVENT_NAME_LOGIN_STATUS_COMPLETE, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96867);
    }

    public void logUnexpectedError(String str, String str2) {
        AppMethodBeat.m2504i(96868);
        logUnexpectedError(str, str2, "");
        AppMethodBeat.m2505o(96868);
    }

    public void logUnexpectedError(String str, String str2, String str3) {
        AppMethodBeat.m2504i(96869);
        Bundle newAuthorizationLoggingBundle = newAuthorizationLoggingBundle("");
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, Code.ERROR.getLoggingValue());
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
        newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
        this.appEventsLogger.logSdkEvent(str, null, newAuthorizationLoggingBundle);
        AppMethodBeat.m2505o(96869);
    }
}
