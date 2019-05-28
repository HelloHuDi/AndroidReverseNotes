package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public final class FacebookRequestError implements Parcelable {
    private static final String BODY_KEY = "body";
    private static final String CODE_KEY = "code";
    public static final Creator<FacebookRequestError> CREATOR = new Creator<FacebookRequestError>() {
        public final FacebookRequestError createFromParcel(Parcel parcel) {
            AppMethodBeat.i(71582);
            FacebookRequestError facebookRequestError = new FacebookRequestError(parcel, null);
            AppMethodBeat.o(71582);
            return facebookRequestError;
        }

        public final FacebookRequestError[] newArray(int i) {
            return new FacebookRequestError[i];
        }
    };
    private static final String ERROR_CODE_FIELD_KEY = "code";
    private static final String ERROR_CODE_KEY = "error_code";
    private static final String ERROR_IS_TRANSIENT_KEY = "is_transient";
    private static final String ERROR_KEY = "error";
    private static final String ERROR_MESSAGE_FIELD_KEY = "message";
    private static final String ERROR_MSG_KEY = "error_msg";
    private static final String ERROR_REASON_KEY = "error_reason";
    private static final String ERROR_SUB_CODE_KEY = "error_subcode";
    private static final String ERROR_TYPE_FIELD_KEY = "type";
    private static final String ERROR_USER_MSG_KEY = "error_user_msg";
    private static final String ERROR_USER_TITLE_KEY = "error_user_title";
    static final Range HTTP_RANGE_SUCCESS = new Range(200, 299, null);
    public static final int INVALID_ERROR_CODE = -1;
    public static final int INVALID_HTTP_STATUS_CODE = -1;
    private final Object batchRequestResult;
    private final Category category;
    private final HttpURLConnection connection;
    private final int errorCode;
    private final String errorMessage;
    private final String errorRecoveryMessage;
    private final String errorType;
    private final String errorUserMessage;
    private final String errorUserTitle;
    private final FacebookException exception;
    private final JSONObject requestResult;
    private final JSONObject requestResultBody;
    private final int requestStatusCode;
    private final int subErrorCode;

    public enum Category {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        static {
            AppMethodBeat.o(71587);
        }
    }

    static class Range {
        private final int end;
        private final int start;

        /* synthetic */ Range(int i, int i2, AnonymousClass1 anonymousClass1) {
            this(i, i2);
        }

        private Range(int i, int i2) {
            this.start = i;
            this.end = i2;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean contains(int i) {
            return this.start <= i && i <= this.end;
        }
    }

    static {
        AppMethodBeat.i(71596);
        AppMethodBeat.o(71596);
    }

    private FacebookRequestError(int i, int i2, int i3, String str, String str2, String str3, String str4, boolean z, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException) {
        Category category;
        AppMethodBeat.i(71588);
        this.requestStatusCode = i;
        this.errorCode = i2;
        this.subErrorCode = i3;
        this.errorType = str;
        this.errorMessage = str2;
        this.requestResultBody = jSONObject;
        this.requestResult = jSONObject2;
        this.batchRequestResult = obj;
        this.connection = httpURLConnection;
        this.errorUserTitle = str3;
        this.errorUserMessage = str4;
        Object obj2 = null;
        if (facebookException != null) {
            this.exception = facebookException;
            obj2 = 1;
        } else {
            this.exception = new FacebookServiceException(this, str2);
        }
        FacebookRequestErrorClassification errorClassification = getErrorClassification();
        if (obj2 != null) {
            category = Category.OTHER;
        } else {
            category = errorClassification.classify(i2, i3, z);
        }
        this.category = category;
        this.errorRecoveryMessage = errorClassification.getRecoveryMessage(this.category);
        AppMethodBeat.o(71588);
    }

    FacebookRequestError(HttpURLConnection httpURLConnection, Exception exception) {
        FacebookException facebookException;
        if (exception instanceof FacebookException) {
            facebookException = (FacebookException) exception;
        } else {
            facebookException = new FacebookException((Throwable) exception);
        }
        this(-1, -1, -1, null, null, null, null, false, null, null, null, httpURLConnection, facebookException);
        AppMethodBeat.i(71589);
        AppMethodBeat.o(71589);
    }

    public FacebookRequestError(int i, String str, String str2) {
        this(-1, i, -1, str, str2, null, null, false, null, null, null, null, null);
    }

    public final Category getCategory() {
        return this.category;
    }

    public final int getRequestStatusCode() {
        return this.requestStatusCode;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getSubErrorCode() {
        return this.subErrorCode;
    }

    public final String getErrorType() {
        return this.errorType;
    }

    public final String getErrorMessage() {
        AppMethodBeat.i(71590);
        String str;
        if (this.errorMessage != null) {
            str = this.errorMessage;
            AppMethodBeat.o(71590);
            return str;
        }
        str = this.exception.getLocalizedMessage();
        AppMethodBeat.o(71590);
        return str;
    }

    public final String getErrorRecoveryMessage() {
        return this.errorRecoveryMessage;
    }

    public final String getErrorUserMessage() {
        return this.errorUserMessage;
    }

    public final String getErrorUserTitle() {
        return this.errorUserTitle;
    }

    public final JSONObject getRequestResultBody() {
        return this.requestResultBody;
    }

    public final JSONObject getRequestResult() {
        return this.requestResult;
    }

    public final Object getBatchRequestResult() {
        return this.batchRequestResult;
    }

    public final HttpURLConnection getConnection() {
        return this.connection;
    }

    public final FacebookException getException() {
        return this.exception;
    }

    public final String toString() {
        AppMethodBeat.i(71591);
        String str = "{HttpStatus: " + this.requestStatusCode + ", errorCode: " + this.errorCode + ", subErrorCode: " + this.subErrorCode + ", errorType: " + this.errorType + ", errorMessage: " + getErrorMessage() + "}";
        AppMethodBeat.o(71591);
        return str;
    }

    static FacebookRequestError checkResponseAndCreateError(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
        AppMethodBeat.i(71592);
        try {
            if (jSONObject.has(TMQQDownloaderOpenSDKConst.UINTYPE_CODE)) {
                JSONObject jSONObject2;
                FacebookRequestError facebookRequestError;
                int i = jSONObject.getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                Object stringPropertyAsJSON = Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                if (stringPropertyAsJSON != null && (stringPropertyAsJSON instanceof JSONObject)) {
                    jSONObject2 = (JSONObject) stringPropertyAsJSON;
                    String str = null;
                    String str2 = null;
                    String str3 = null;
                    String str4 = null;
                    boolean z = false;
                    int i2 = 0;
                    int i3 = 0;
                    Object obj2 = null;
                    if (jSONObject2.has("error")) {
                        JSONObject jSONObject3 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject2, "error", null);
                        str = jSONObject3.optString("type", null);
                        str2 = jSONObject3.optString("message", null);
                        i2 = jSONObject3.optInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, -1);
                        i3 = jSONObject3.optInt("error_subcode", -1);
                        str3 = jSONObject3.optString(ERROR_USER_MSG_KEY, null);
                        str4 = jSONObject3.optString(ERROR_USER_TITLE_KEY, null);
                        z = jSONObject3.optBoolean(ERROR_IS_TRANSIENT_KEY, false);
                        obj2 = 1;
                    } else if (jSONObject2.has("error_code") || jSONObject2.has(ERROR_MSG_KEY) || jSONObject2.has(ERROR_REASON_KEY)) {
                        str = jSONObject2.optString(ERROR_REASON_KEY, null);
                        str2 = jSONObject2.optString(ERROR_MSG_KEY, null);
                        i2 = jSONObject2.optInt("error_code", -1);
                        i3 = jSONObject2.optInt("error_subcode", -1);
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        facebookRequestError = new FacebookRequestError(i, i2, i3, str, str2, str4, str3, z, jSONObject2, jSONObject, obj, httpURLConnection, null);
                        AppMethodBeat.o(71592);
                        return facebookRequestError;
                    }
                }
                if (!HTTP_RANGE_SUCCESS.contains(i)) {
                    if (jSONObject.has(BODY_KEY)) {
                        jSONObject2 = (JSONObject) Utility.getStringPropertyAsJSON(jSONObject, BODY_KEY, GraphResponse.NON_JSON_RESPONSE_PROPERTY);
                    } else {
                        jSONObject2 = null;
                    }
                    facebookRequestError = new FacebookRequestError(i, -1, -1, null, null, null, null, false, jSONObject2, jSONObject, obj, httpURLConnection, null);
                    AppMethodBeat.o(71592);
                    return facebookRequestError;
                }
            }
        } catch (JSONException e) {
        }
        AppMethodBeat.o(71592);
        return null;
    }

    static synchronized FacebookRequestErrorClassification getErrorClassification() {
        FacebookRequestErrorClassification defaultErrorClassification;
        synchronized (FacebookRequestError.class) {
            AppMethodBeat.i(71593);
            FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
            if (appSettingsWithoutQuery == null) {
                defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
                AppMethodBeat.o(71593);
            } else {
                defaultErrorClassification = appSettingsWithoutQuery.getErrorClassification();
                AppMethodBeat.o(71593);
            }
        }
        return defaultErrorClassification;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71594);
        parcel.writeInt(this.requestStatusCode);
        parcel.writeInt(this.errorCode);
        parcel.writeInt(this.subErrorCode);
        parcel.writeString(this.errorType);
        parcel.writeString(this.errorMessage);
        parcel.writeString(this.errorUserTitle);
        parcel.writeString(this.errorUserMessage);
        AppMethodBeat.o(71594);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), false, null, null, null, null, null);
        AppMethodBeat.i(71595);
        AppMethodBeat.o(71595);
    }

    public final int describeContents() {
        return 0;
    }
}
