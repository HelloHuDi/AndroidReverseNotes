package com.facebook.login;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.Fragment;
import android.support.p057v4.app.FragmentActivity;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class LoginClient implements Parcelable {
    public static final Creator<LoginClient> CREATOR = new C86101();
    BackgroundProcessingListener backgroundProcessingListener;
    boolean checkedInternetPermission;
    int currentHandler = -1;
    Map<String, String> extraData;
    Fragment fragment;
    LoginMethodHandler[] handlersToTry;
    Map<String, String> loggingExtras;
    private LoginLogger loginLogger;
    OnCompletedListener onCompletedListener;
    Request pendingRequest;

    /* renamed from: com.facebook.login.LoginClient$1 */
    static class C86101 implements Creator<LoginClient> {
        C86101() {
        }

        public final LoginClient createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(96789);
            LoginClient loginClient = new LoginClient(parcel);
            AppMethodBeat.m2505o(96789);
            return loginClient;
        }

        public final LoginClient[] newArray(int i) {
            return new LoginClient[i];
        }
    }

    interface BackgroundProcessingListener {
        void onBackgroundProcessingStarted();

        void onBackgroundProcessingStopped();
    }

    public interface OnCompletedListener {
        void onCompleted(Result result);
    }

    public static class Result implements Parcelable {
        public static final Creator<Result> CREATOR = new C176071();
        final Code code;
        final String errorCode;
        final String errorMessage;
        public Map<String, String> extraData;
        public Map<String, String> loggingExtras;
        final Request request;
        final AccessToken token;

        /* renamed from: com.facebook.login.LoginClient$Result$1 */
        static class C176071 implements Creator<Result> {
            C176071() {
            }

            public final Result createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(96801);
                Result result = new Result(parcel, null);
                AppMethodBeat.m2505o(96801);
                return result;
            }

            public final Result[] newArray(int i) {
                return new Result[i];
            }
        }

        enum Code {
            SUCCESS("success"),
            CANCEL("cancel"),
            ERROR("error");
            
            private final String loggingValue;

            static {
                AppMethodBeat.m2505o(96806);
            }

            private Code(String str) {
                this.loggingValue = str;
            }

            /* Access modifiers changed, original: final */
            public final String getLoggingValue() {
                return this.loggingValue;
            }
        }

        /* synthetic */ Result(Parcel parcel, C86101 c86101) {
            this(parcel);
        }

        Result(Request request, Code code, AccessToken accessToken, String str, String str2) {
            AppMethodBeat.m2504i(96807);
            Validate.notNull(code, TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            this.request = request;
            this.token = accessToken;
            this.errorMessage = str;
            this.code = code;
            this.errorCode = str2;
            AppMethodBeat.m2505o(96807);
        }

        static Result createTokenResult(Request request, AccessToken accessToken) {
            AppMethodBeat.m2504i(96808);
            Result result = new Result(request, Code.SUCCESS, accessToken, null, null);
            AppMethodBeat.m2505o(96808);
            return result;
        }

        static Result createCancelResult(Request request, String str) {
            AppMethodBeat.m2504i(96809);
            Result result = new Result(request, Code.CANCEL, null, str, null);
            AppMethodBeat.m2505o(96809);
            return result;
        }

        static Result createErrorResult(Request request, String str, String str2) {
            AppMethodBeat.m2504i(96810);
            Result createErrorResult = createErrorResult(request, str, str2, null);
            AppMethodBeat.m2505o(96810);
            return createErrorResult;
        }

        static Result createErrorResult(Request request, String str, String str2, String str3) {
            AppMethodBeat.m2504i(96811);
            String join = TextUtils.join(": ", Utility.asListNoNulls(str, str2));
            Result result = new Result(request, Code.ERROR, null, join, str3);
            AppMethodBeat.m2505o(96811);
            return result;
        }

        private Result(Parcel parcel) {
            AppMethodBeat.m2504i(96812);
            this.code = Code.valueOf(parcel.readString());
            this.token = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.errorMessage = parcel.readString();
            this.errorCode = parcel.readString();
            this.request = (Request) parcel.readParcelable(Request.class.getClassLoader());
            this.loggingExtras = Utility.readStringMapFromParcel(parcel);
            this.extraData = Utility.readStringMapFromParcel(parcel);
            AppMethodBeat.m2505o(96812);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(96813);
            parcel.writeString(this.code.name());
            parcel.writeParcelable(this.token, i);
            parcel.writeString(this.errorMessage);
            parcel.writeString(this.errorCode);
            parcel.writeParcelable(this.request, i);
            Utility.writeStringMapToParcel(parcel, this.loggingExtras);
            Utility.writeStringMapToParcel(parcel, this.extraData);
            AppMethodBeat.m2505o(96813);
        }

        static {
            AppMethodBeat.m2504i(96814);
            AppMethodBeat.m2505o(96814);
        }
    }

    public static class Request implements Parcelable {
        public static final Creator<Request> CREATOR = new C176081();
        private final String applicationId;
        private final String authId;
        private String authType;
        private final DefaultAudience defaultAudience;
        private String deviceAuthTargetUserId;
        private String deviceRedirectUriString;
        private boolean isRerequest;
        private final LoginBehavior loginBehavior;
        private Set<String> permissions;

        /* renamed from: com.facebook.login.LoginClient$Request$1 */
        static class C176081 implements Creator<Request> {
            C176081() {
            }

            public final Request createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(96792);
                Request request = new Request(parcel, null);
                AppMethodBeat.m2505o(96792);
                return request;
            }

            public final Request[] newArray(int i) {
                return new Request[i];
            }
        }

        /* synthetic */ Request(Parcel parcel, C86101 c86101) {
            this(parcel);
        }

        Request(LoginBehavior loginBehavior, Set<String> set, DefaultAudience defaultAudience, String str, String str2, String str3) {
            Set set2;
            AppMethodBeat.m2504i(96795);
            this.isRerequest = false;
            this.loginBehavior = loginBehavior;
            if (set2 == null) {
                set2 = new HashSet();
            }
            this.permissions = set2;
            this.defaultAudience = defaultAudience;
            this.authType = str;
            this.applicationId = str2;
            this.authId = str3;
            AppMethodBeat.m2505o(96795);
        }

        /* Access modifiers changed, original: 0000 */
        public Set<String> getPermissions() {
            return this.permissions;
        }

        /* Access modifiers changed, original: 0000 */
        public void setPermissions(Set<String> set) {
            AppMethodBeat.m2504i(96796);
            Validate.notNull(set, NativeProtocol.RESULT_ARGS_PERMISSIONS);
            this.permissions = set;
            AppMethodBeat.m2505o(96796);
        }

        /* Access modifiers changed, original: 0000 */
        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        /* Access modifiers changed, original: 0000 */
        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        /* Access modifiers changed, original: 0000 */
        public String getApplicationId() {
            return this.applicationId;
        }

        /* Access modifiers changed, original: 0000 */
        public String getAuthId() {
            return this.authId;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean isRerequest() {
            return this.isRerequest;
        }

        /* Access modifiers changed, original: 0000 */
        public void setRerequest(boolean z) {
            this.isRerequest = z;
        }

        /* Access modifiers changed, original: 0000 */
        public String getDeviceRedirectUriString() {
            return this.deviceRedirectUriString;
        }

        /* Access modifiers changed, original: 0000 */
        public void setDeviceRedirectUriString(String str) {
            this.deviceRedirectUriString = str;
        }

        /* Access modifiers changed, original: 0000 */
        public String getDeviceAuthTargetUserId() {
            return this.deviceAuthTargetUserId;
        }

        /* Access modifiers changed, original: 0000 */
        public void setDeviceAuthTargetUserId(String str) {
            this.deviceAuthTargetUserId = str;
        }

        /* Access modifiers changed, original: 0000 */
        public String getAuthType() {
            return this.authType;
        }

        /* Access modifiers changed, original: 0000 */
        public void setAuthType(String str) {
            this.authType = str;
        }

        /* Access modifiers changed, original: 0000 */
        public boolean hasPublishPermission() {
            AppMethodBeat.m2504i(96797);
            for (String isPublishPermission : this.permissions) {
                if (LoginManager.isPublishPermission(isPublishPermission)) {
                    AppMethodBeat.m2505o(96797);
                    return true;
                }
            }
            AppMethodBeat.m2505o(96797);
            return false;
        }

        private Request(Parcel parcel) {
            boolean z;
            DefaultAudience defaultAudience = null;
            AppMethodBeat.m2504i(96798);
            this.isRerequest = false;
            String readString = parcel.readString();
            this.loginBehavior = readString != null ? LoginBehavior.valueOf(readString) : null;
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.permissions = new HashSet(arrayList);
            readString = parcel.readString();
            if (readString != null) {
                defaultAudience = DefaultAudience.valueOf(readString);
            }
            this.defaultAudience = defaultAudience;
            this.applicationId = parcel.readString();
            this.authId = parcel.readString();
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.isRerequest = z;
            this.deviceRedirectUriString = parcel.readString();
            this.authType = parcel.readString();
            this.deviceAuthTargetUserId = parcel.readString();
            AppMethodBeat.m2505o(96798);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            String str = null;
            AppMethodBeat.m2504i(96799);
            parcel.writeString(this.loginBehavior != null ? this.loginBehavior.name() : null);
            parcel.writeStringList(new ArrayList(this.permissions));
            if (this.defaultAudience != null) {
                str = this.defaultAudience.name();
            }
            parcel.writeString(str);
            parcel.writeString(this.applicationId);
            parcel.writeString(this.authId);
            parcel.writeByte((byte) (this.isRerequest ? 1 : 0));
            parcel.writeString(this.deviceRedirectUriString);
            parcel.writeString(this.authType);
            parcel.writeString(this.deviceAuthTargetUserId);
            AppMethodBeat.m2505o(96799);
        }

        static {
            AppMethodBeat.m2504i(96800);
            AppMethodBeat.m2505o(96800);
        }
    }

    public LoginClient(Fragment fragment) {
        this.fragment = fragment;
    }

    public Fragment getFragment() {
        return this.fragment;
    }

    /* Access modifiers changed, original: 0000 */
    public void setFragment(Fragment fragment) {
        AppMethodBeat.m2504i(96815);
        if (this.fragment != null) {
            FacebookException facebookException = new FacebookException("Can't set fragment once it is already set.");
            AppMethodBeat.m2505o(96815);
            throw facebookException;
        }
        this.fragment = fragment;
        AppMethodBeat.m2505o(96815);
    }

    /* Access modifiers changed, original: 0000 */
    public FragmentActivity getActivity() {
        AppMethodBeat.m2504i(96816);
        FragmentActivity activity = this.fragment.getActivity();
        AppMethodBeat.m2505o(96816);
        return activity;
    }

    public Request getPendingRequest() {
        return this.pendingRequest;
    }

    public static int getLoginRequestCode() {
        AppMethodBeat.m2504i(96817);
        int toRequestCode = RequestCodeOffset.Login.toRequestCode();
        AppMethodBeat.m2505o(96817);
        return toRequestCode;
    }

    /* Access modifiers changed, original: 0000 */
    public void startOrContinueAuth(Request request) {
        AppMethodBeat.m2504i(96818);
        if (!getInProgress()) {
            authorize(request);
        }
        AppMethodBeat.m2505o(96818);
    }

    /* Access modifiers changed, original: 0000 */
    public void authorize(Request request) {
        AppMethodBeat.m2504i(96819);
        if (request == null) {
            AppMethodBeat.m2505o(96819);
        } else if (this.pendingRequest != null) {
            FacebookException facebookException = new FacebookException("Attempted to authorize while a request is pending.");
            AppMethodBeat.m2505o(96819);
            throw facebookException;
        } else if (!AccessToken.isCurrentAccessTokenActive() || checkInternetPermission()) {
            this.pendingRequest = request;
            this.handlersToTry = getHandlersToTry(request);
            tryNextHandler();
            AppMethodBeat.m2505o(96819);
        } else {
            AppMethodBeat.m2505o(96819);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean getInProgress() {
        return this.pendingRequest != null && this.currentHandler >= 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void cancelCurrentHandler() {
        AppMethodBeat.m2504i(96820);
        if (this.currentHandler >= 0) {
            getCurrentHandler().cancel();
        }
        AppMethodBeat.m2505o(96820);
    }

    /* Access modifiers changed, original: 0000 */
    public LoginMethodHandler getCurrentHandler() {
        if (this.currentHandler >= 0) {
            return this.handlersToTry[this.currentHandler];
        }
        return null;
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(96821);
        if (this.pendingRequest != null) {
            boolean onActivityResult = getCurrentHandler().onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(96821);
            return onActivityResult;
        }
        AppMethodBeat.m2505o(96821);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public LoginMethodHandler[] getHandlersToTry(Request request) {
        AppMethodBeat.m2504i(96822);
        ArrayList arrayList = new ArrayList();
        LoginBehavior loginBehavior = request.getLoginBehavior();
        if (loginBehavior.allowsGetTokenAuth()) {
            arrayList.add(new GetTokenLoginMethodHandler(this));
        }
        if (loginBehavior.allowsKatanaAuth()) {
            arrayList.add(new KatanaProxyLoginMethodHandler(this));
        }
        if (loginBehavior.allowsFacebookLiteAuth()) {
            arrayList.add(new FacebookLiteLoginMethodHandler(this));
        }
        if (loginBehavior.allowsCustomTabAuth()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (loginBehavior.allowsWebViewAuth()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (loginBehavior.allowsDeviceAuth()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        LoginMethodHandler[] loginMethodHandlerArr = new LoginMethodHandler[arrayList.size()];
        arrayList.toArray(loginMethodHandlerArr);
        AppMethodBeat.m2505o(96822);
        return loginMethodHandlerArr;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean checkInternetPermission() {
        AppMethodBeat.m2504i(96823);
        if (this.checkedInternetPermission) {
            AppMethodBeat.m2505o(96823);
            return true;
        } else if (checkPermission("android.permission.INTERNET") != 0) {
            FragmentActivity activity = getActivity();
            complete(Result.createErrorResult(this.pendingRequest, activity.getString(C25738R.string.f8616x), activity.getString(C25738R.string.f8615w)));
            AppMethodBeat.m2505o(96823);
            return false;
        } else {
            this.checkedInternetPermission = true;
            AppMethodBeat.m2505o(96823);
            return true;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void tryNextHandler() {
        AppMethodBeat.m2504i(96824);
        if (this.currentHandler >= 0) {
            logAuthorizationMethodComplete(getCurrentHandler().getNameForLogging(), "skipped", null, null, getCurrentHandler().methodLoggingExtras);
        }
        while (this.handlersToTry != null && this.currentHandler < this.handlersToTry.length - 1) {
            this.currentHandler++;
            if (tryCurrentHandler()) {
                AppMethodBeat.m2505o(96824);
                return;
            }
        }
        if (this.pendingRequest != null) {
            completeWithFailure();
        }
        AppMethodBeat.m2505o(96824);
    }

    private void completeWithFailure() {
        AppMethodBeat.m2504i(96825);
        complete(Result.createErrorResult(this.pendingRequest, "Login attempt failed.", null));
        AppMethodBeat.m2505o(96825);
    }

    private void addLoggingExtra(String str, String str2, boolean z) {
        Object str22;
        AppMethodBeat.m2504i(96826);
        if (this.loggingExtras == null) {
            this.loggingExtras = new HashMap();
        }
        if (this.loggingExtras.containsKey(str) && z) {
            str22 = ((String) this.loggingExtras.get(str)) + "," + str22;
        }
        this.loggingExtras.put(str, str22);
        AppMethodBeat.m2505o(96826);
    }

    /* Access modifiers changed, original: 0000 */
    public void addExtraData(String str, String str2, boolean z) {
        Object str22;
        AppMethodBeat.m2504i(96827);
        if (this.extraData == null) {
            this.extraData = new HashMap();
        }
        if (this.extraData.containsKey(str) && z) {
            str22 = ((String) this.extraData.get(str)) + "," + str22;
        }
        this.extraData.put(str, str22);
        AppMethodBeat.m2505o(96827);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean tryCurrentHandler() {
        boolean z = false;
        AppMethodBeat.m2504i(96828);
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (!currentHandler.needsInternetPermission() || checkInternetPermission()) {
            z = currentHandler.tryAuthorize(this.pendingRequest);
            if (z) {
                getLogger().logAuthorizationMethodStart(this.pendingRequest.getAuthId(), currentHandler.getNameForLogging());
            } else {
                getLogger().logAuthorizationMethodNotTried(this.pendingRequest.getAuthId(), currentHandler.getNameForLogging());
                addLoggingExtra("not_tried", currentHandler.getNameForLogging(), true);
            }
            AppMethodBeat.m2505o(96828);
        } else {
            addLoggingExtra("no_internet_permission", "1", false);
            AppMethodBeat.m2505o(96828);
        }
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public void completeAndValidate(Result result) {
        AppMethodBeat.m2504i(96829);
        if (result.token == null || !AccessToken.isCurrentAccessTokenActive()) {
            complete(result);
            AppMethodBeat.m2505o(96829);
            return;
        }
        validateSameFbidAndFinish(result);
        AppMethodBeat.m2505o(96829);
    }

    /* Access modifiers changed, original: 0000 */
    public void complete(Result result) {
        AppMethodBeat.m2504i(96830);
        LoginMethodHandler currentHandler = getCurrentHandler();
        if (currentHandler != null) {
            logAuthorizationMethodComplete(currentHandler.getNameForLogging(), result, currentHandler.methodLoggingExtras);
        }
        if (this.loggingExtras != null) {
            result.loggingExtras = this.loggingExtras;
        }
        if (this.extraData != null) {
            result.extraData = this.extraData;
        }
        this.handlersToTry = null;
        this.currentHandler = -1;
        this.pendingRequest = null;
        this.loggingExtras = null;
        notifyOnCompleteListener(result);
        AppMethodBeat.m2505o(96830);
    }

    /* Access modifiers changed, original: 0000 */
    public OnCompletedListener getOnCompletedListener() {
        return this.onCompletedListener;
    }

    /* Access modifiers changed, original: 0000 */
    public void setOnCompletedListener(OnCompletedListener onCompletedListener) {
        this.onCompletedListener = onCompletedListener;
    }

    /* Access modifiers changed, original: 0000 */
    public BackgroundProcessingListener getBackgroundProcessingListener() {
        return this.backgroundProcessingListener;
    }

    /* Access modifiers changed, original: 0000 */
    public void setBackgroundProcessingListener(BackgroundProcessingListener backgroundProcessingListener) {
        this.backgroundProcessingListener = backgroundProcessingListener;
    }

    /* Access modifiers changed, original: 0000 */
    public int checkPermission(String str) {
        AppMethodBeat.m2504i(96831);
        int checkCallingOrSelfPermission = getActivity().checkCallingOrSelfPermission(str);
        AppMethodBeat.m2505o(96831);
        return checkCallingOrSelfPermission;
    }

    /* Access modifiers changed, original: 0000 */
    public void validateSameFbidAndFinish(Result result) {
        AppMethodBeat.m2504i(96832);
        if (result.token == null) {
            FacebookException facebookException = new FacebookException("Can't validate without a token");
            AppMethodBeat.m2505o(96832);
            throw facebookException;
        }
        Result createTokenResult;
        AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
        AccessToken accessToken = result.token;
        if (!(currentAccessToken == null || accessToken == null)) {
            try {
                if (currentAccessToken.getUserId().equals(accessToken.getUserId())) {
                    createTokenResult = Result.createTokenResult(this.pendingRequest, result.token);
                    complete(createTokenResult);
                    AppMethodBeat.m2505o(96832);
                }
            } catch (Exception e) {
                complete(Result.createErrorResult(this.pendingRequest, "Caught exception", e.getMessage()));
                AppMethodBeat.m2505o(96832);
                return;
            }
        }
        createTokenResult = Result.createErrorResult(this.pendingRequest, "User logged in as different Facebook user.", null);
        complete(createTokenResult);
        AppMethodBeat.m2505o(96832);
    }

    private LoginLogger getLogger() {
        AppMethodBeat.m2504i(96833);
        if (this.loginLogger == null || !this.loginLogger.getApplicationId().equals(this.pendingRequest.getApplicationId())) {
            this.loginLogger = new LoginLogger(getActivity(), this.pendingRequest.getApplicationId());
        }
        LoginLogger loginLogger = this.loginLogger;
        AppMethodBeat.m2505o(96833);
        return loginLogger;
    }

    private void notifyOnCompleteListener(Result result) {
        AppMethodBeat.m2504i(96834);
        if (this.onCompletedListener != null) {
            this.onCompletedListener.onCompleted(result);
        }
        AppMethodBeat.m2505o(96834);
    }

    /* Access modifiers changed, original: 0000 */
    public void notifyBackgroundProcessingStart() {
        AppMethodBeat.m2504i(96835);
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStarted();
        }
        AppMethodBeat.m2505o(96835);
    }

    /* Access modifiers changed, original: 0000 */
    public void notifyBackgroundProcessingStop() {
        AppMethodBeat.m2504i(96836);
        if (this.backgroundProcessingListener != null) {
            this.backgroundProcessingListener.onBackgroundProcessingStopped();
        }
        AppMethodBeat.m2505o(96836);
    }

    private void logAuthorizationMethodComplete(String str, Result result, Map<String, String> map) {
        AppMethodBeat.m2504i(96837);
        logAuthorizationMethodComplete(str, result.code.getLoggingValue(), result.errorMessage, result.errorCode, map);
        AppMethodBeat.m2505o(96837);
    }

    private void logAuthorizationMethodComplete(String str, String str2, String str3, String str4, Map<String, String> map) {
        AppMethodBeat.m2504i(96838);
        if (this.pendingRequest == null) {
            getLogger().logUnexpectedError("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
            AppMethodBeat.m2505o(96838);
            return;
        }
        getLogger().logAuthorizationMethodComplete(this.pendingRequest.getAuthId(), str, str2, str3, str4, map);
        AppMethodBeat.m2505o(96838);
    }

    static String getE2E() {
        AppMethodBeat.m2504i(96839);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(96839);
        return jSONObject2;
    }

    public LoginClient(Parcel parcel) {
        AppMethodBeat.m2504i(96840);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        this.handlersToTry = new LoginMethodHandler[readParcelableArray.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < readParcelableArray.length) {
                this.handlersToTry[i2] = (LoginMethodHandler) readParcelableArray[i2];
                this.handlersToTry[i2].setLoginClient(this);
                i = i2 + 1;
            } else {
                this.currentHandler = parcel.readInt();
                this.pendingRequest = (Request) parcel.readParcelable(Request.class.getClassLoader());
                this.loggingExtras = Utility.readStringMapFromParcel(parcel);
                this.extraData = Utility.readStringMapFromParcel(parcel);
                AppMethodBeat.m2505o(96840);
                return;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(96841);
        parcel.writeParcelableArray(this.handlersToTry, i);
        parcel.writeInt(this.currentHandler);
        parcel.writeParcelable(this.pendingRequest, i);
        Utility.writeStringMapToParcel(parcel, this.loggingExtras);
        Utility.writeStringMapToParcel(parcel, this.extraData);
        AppMethodBeat.m2505o(96841);
    }

    static {
        AppMethodBeat.m2504i(96842);
        AppMethodBeat.m2505o(96842);
    }
}
