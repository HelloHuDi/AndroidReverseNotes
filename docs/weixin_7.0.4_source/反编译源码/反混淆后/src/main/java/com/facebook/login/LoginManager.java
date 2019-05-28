package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.p057v4.app.Fragment;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookActivity;
import com.facebook.FacebookAuthorizationException;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphResponse;
import com.facebook.LoginStatusCallback;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.CallbackManagerImpl.RequestCodeOffset;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient.Request;
import com.facebook.login.LoginClient.Result;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class LoginManager {
    private static final String EXPRESS_LOGIN_ALLOWED = "express_login_allowed";
    private static final String MANAGE_PERMISSION_PREFIX = "manage";
    private static final Set<String> OTHER_PUBLISH_PERMISSIONS = getOtherPublishPermissions();
    private static final String PREFERENCE_LOGIN_MANAGER = "com.facebook.loginManager";
    private static final String PUBLISH_PERMISSION_PREFIX = "publish";
    private static volatile LoginManager instance;
    private String authType = ServerProtocol.DIALOG_REREQUEST_AUTH_TYPE;
    private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
    private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
    private final SharedPreferences sharedPreferences;

    static class ActivityStartActivityDelegate implements StartActivityDelegate {
        private final Activity activity;

        ActivityStartActivityDelegate(Activity activity) {
            AppMethodBeat.m2504i(96874);
            Validate.notNull(activity, "activity");
            this.activity = activity;
            AppMethodBeat.m2505o(96874);
        }

        public void startActivityForResult(Intent intent, int i) {
            AppMethodBeat.m2504i(96875);
            this.activity.startActivityForResult(intent, i);
            AppMethodBeat.m2505o(96875);
        }

        public Activity getActivityContext() {
            return this.activity;
        }
    }

    static class FragmentStartActivityDelegate implements StartActivityDelegate {
        private final FragmentWrapper fragment;

        FragmentStartActivityDelegate(FragmentWrapper fragmentWrapper) {
            AppMethodBeat.m2504i(96876);
            Validate.notNull(fragmentWrapper, "fragment");
            this.fragment = fragmentWrapper;
            AppMethodBeat.m2505o(96876);
        }

        public void startActivityForResult(Intent intent, int i) {
            AppMethodBeat.m2504i(96877);
            this.fragment.startActivityForResult(intent, i);
            AppMethodBeat.m2505o(96877);
        }

        public Activity getActivityContext() {
            AppMethodBeat.m2504i(96878);
            Activity activity = this.fragment.getActivity();
            AppMethodBeat.m2505o(96878);
            return activity;
        }
    }

    /* renamed from: com.facebook.login.LoginManager$2 */
    static class C320022 extends HashSet<String> {
        C320022() {
            AppMethodBeat.m2504i(96871);
            add("ads_management");
            add("create_event");
            add("rsvp_event");
            AppMethodBeat.m2505o(96871);
        }
    }

    /* renamed from: com.facebook.login.LoginManager$3 */
    class C320033 implements Callback {
        C320033() {
        }

        public boolean onActivityResult(int i, Intent intent) {
            AppMethodBeat.m2504i(96872);
            boolean onActivityResult = LoginManager.this.onActivityResult(i, intent);
            AppMethodBeat.m2505o(96872);
            return onActivityResult;
        }
    }

    static class LoginLoggerHolder {
        private static LoginLogger logger;

        private LoginLoggerHolder() {
        }

        static /* synthetic */ LoginLogger access$000(Context context) {
            AppMethodBeat.m2504i(96880);
            LoginLogger logger = getLogger(context);
            AppMethodBeat.m2505o(96880);
            return logger;
        }

        private static synchronized LoginLogger getLogger(Context context) {
            LoginLogger loginLogger;
            synchronized (LoginLoggerHolder.class) {
                AppMethodBeat.m2504i(96879);
                if (context == null) {
                    context = FacebookSdk.getApplicationContext();
                }
                if (context == null) {
                    loginLogger = null;
                    AppMethodBeat.m2505o(96879);
                } else {
                    if (logger == null) {
                        logger = new LoginLogger(context, FacebookSdk.getApplicationId());
                    }
                    loginLogger = logger;
                    AppMethodBeat.m2505o(96879);
                }
            }
            return loginLogger;
        }
    }

    static /* synthetic */ void access$100(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.m2504i(96926);
        handleLoginStatusError(str, str2, str3, loginLogger, loginStatusCallback);
        AppMethodBeat.m2505o(96926);
    }

    static /* synthetic */ Profile access$200(Bundle bundle) {
        AppMethodBeat.m2504i(96927);
        Profile profileFromBundle = getProfileFromBundle(bundle);
        AppMethodBeat.m2505o(96927);
        return profileFromBundle;
    }

    static {
        AppMethodBeat.m2504i(96928);
        AppMethodBeat.m2505o(96928);
    }

    LoginManager() {
        AppMethodBeat.m2504i(96881);
        Validate.sdkInitialized();
        this.sharedPreferences = FacebookSdk.getApplicationContext().getSharedPreferences(PREFERENCE_LOGIN_MANAGER, 0);
        AppMethodBeat.m2505o(96881);
    }

    public static LoginManager getInstance() {
        AppMethodBeat.m2504i(96882);
        if (instance == null) {
            synchronized (LoginManager.class) {
                try {
                    if (instance == null) {
                        instance = new LoginManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(96882);
                    }
                }
            }
        }
        LoginManager loginManager = instance;
        AppMethodBeat.m2505o(96882);
        return loginManager;
    }

    public void resolveError(Activity activity, GraphResponse graphResponse) {
        AppMethodBeat.m2504i(96883);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequestFromResponse(graphResponse));
        AppMethodBeat.m2505o(96883);
    }

    public void resolveError(Fragment fragment, GraphResponse graphResponse) {
        AppMethodBeat.m2504i(96884);
        resolveError(new FragmentWrapper(fragment), graphResponse);
        AppMethodBeat.m2505o(96884);
    }

    public void resolveError(android.app.Fragment fragment, GraphResponse graphResponse) {
        AppMethodBeat.m2504i(96885);
        resolveError(new FragmentWrapper(fragment), graphResponse);
        AppMethodBeat.m2505o(96885);
    }

    private void resolveError(FragmentWrapper fragmentWrapper, GraphResponse graphResponse) {
        AppMethodBeat.m2504i(96886);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequestFromResponse(graphResponse));
        AppMethodBeat.m2505o(96886);
    }

    private Request createLoginRequestFromResponse(GraphResponse graphResponse) {
        AppMethodBeat.m2504i(96887);
        Validate.notNull(graphResponse, "response");
        AccessToken accessToken = graphResponse.getRequest().getAccessToken();
        Request createLoginRequest = createLoginRequest(accessToken != null ? accessToken.getPermissions() : null);
        AppMethodBeat.m2505o(96887);
        return createLoginRequest;
    }

    public void registerCallback(CallbackManager callbackManager, final FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.m2504i(96888);
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).registerCallback(RequestCodeOffset.Login.toRequestCode(), new Callback() {
                public boolean onActivityResult(int i, Intent intent) {
                    AppMethodBeat.m2504i(96870);
                    boolean onActivityResult = LoginManager.this.onActivityResult(i, intent, facebookCallback);
                    AppMethodBeat.m2505o(96870);
                    return onActivityResult;
                }
            });
            AppMethodBeat.m2505o(96888);
            return;
        }
        FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        AppMethodBeat.m2505o(96888);
        throw facebookException;
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        AppMethodBeat.m2504i(96889);
        if (callbackManager instanceof CallbackManagerImpl) {
            ((CallbackManagerImpl) callbackManager).unregisterCallback(RequestCodeOffset.Login.toRequestCode());
            AppMethodBeat.m2505o(96889);
            return;
        }
        FacebookException facebookException = new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
        AppMethodBeat.m2505o(96889);
        throw facebookException;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean onActivityResult(int i, Intent intent) {
        AppMethodBeat.m2504i(96890);
        boolean onActivityResult = onActivityResult(i, intent, null);
        AppMethodBeat.m2505o(96890);
        return onActivityResult;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean onActivityResult(int i, Intent intent, FacebookCallback<LoginResult> facebookCallback) {
        boolean z;
        AccessToken accessToken;
        Exception facebookException;
        AppMethodBeat.m2504i(96891);
        Exception exception = null;
        Code code = Code.ERROR;
        Map map = null;
        Request request = null;
        boolean z2 = false;
        if (intent != null) {
            Request request2;
            Map map2;
            Code code2;
            AccessToken accessToken2;
            Result result = (Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (result != null) {
                AccessToken accessToken3;
                Exception exception2;
                request = result.request;
                Code code3 = result.code;
                if (i == -1) {
                    if (result.code == Code.SUCCESS) {
                        accessToken3 = result.token;
                        exception2 = null;
                    } else {
                        exception2 = new FacebookAuthorizationException(result.errorMessage);
                        accessToken3 = null;
                    }
                } else if (i == 0) {
                    z2 = true;
                    accessToken3 = null;
                    exception2 = null;
                } else {
                    accessToken3 = null;
                    exception2 = null;
                }
                Map map3 = result.loggingExtras;
                request2 = request;
                map2 = map3;
                code2 = code3;
                accessToken2 = accessToken3;
                exception = exception2;
            } else {
                request2 = null;
                map2 = null;
                code2 = code;
                accessToken2 = null;
            }
            z = z2;
            request = request2;
            map = map2;
            code = code2;
            accessToken = accessToken2;
        } else if (i == 0) {
            code = Code.CANCEL;
            z = true;
            accessToken = null;
        } else {
            z = false;
            accessToken = null;
        }
        if (exception == null && accessToken == null && !z) {
            facebookException = new FacebookException("Unexpected call to LoginManager.onActivityResult");
        } else {
            facebookException = exception;
        }
        logCompleteLogin(null, code, map, facebookException, true, request);
        finishLogin(accessToken, request, facebookException, z, facebookCallback);
        AppMethodBeat.m2505o(96891);
        return true;
    }

    static Map<String, String> getExtraDataFromIntent(Intent intent) {
        AppMethodBeat.m2504i(96892);
        if (intent == null) {
            AppMethodBeat.m2505o(96892);
            return null;
        }
        Result result = (Result) intent.getParcelableExtra("com.facebook.LoginFragment:Result");
        if (result == null) {
            AppMethodBeat.m2505o(96892);
            return null;
        }
        Map<String, String> map = result.extraData;
        AppMethodBeat.m2505o(96892);
        return map;
    }

    public LoginBehavior getLoginBehavior() {
        return this.loginBehavior;
    }

    public LoginManager setLoginBehavior(LoginBehavior loginBehavior) {
        this.loginBehavior = loginBehavior;
        return this;
    }

    public DefaultAudience getDefaultAudience() {
        return this.defaultAudience;
    }

    public LoginManager setDefaultAudience(DefaultAudience defaultAudience) {
        this.defaultAudience = defaultAudience;
        return this;
    }

    public String getAuthType() {
        return this.authType;
    }

    public LoginManager setAuthType(String str) {
        this.authType = str;
        return this;
    }

    public void logOut() {
        AppMethodBeat.m2504i(96893);
        AccessToken.setCurrentAccessToken(null);
        Profile.setCurrentProfile(null);
        setExpressLoginStatus(false);
        AppMethodBeat.m2505o(96893);
    }

    public void retrieveLoginStatus(Context context, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.m2504i(96894);
        retrieveLoginStatus(context, 5000, loginStatusCallback);
        AppMethodBeat.m2505o(96894);
    }

    public void retrieveLoginStatus(Context context, long j, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.m2504i(96895);
        retrieveLoginStatusImpl(context, loginStatusCallback, j);
        AppMethodBeat.m2505o(96895);
    }

    public void logInWithReadPermissions(Fragment fragment, Collection<String> collection) {
        AppMethodBeat.m2504i(96896);
        logInWithReadPermissions(new FragmentWrapper(fragment), (Collection) collection);
        AppMethodBeat.m2505o(96896);
    }

    public void logInWithReadPermissions(android.app.Fragment fragment, Collection<String> collection) {
        AppMethodBeat.m2504i(96897);
        logInWithReadPermissions(new FragmentWrapper(fragment), (Collection) collection);
        AppMethodBeat.m2505o(96897);
    }

    private void logInWithReadPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        AppMethodBeat.m2504i(96898);
        validateReadPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequest(collection));
        AppMethodBeat.m2505o(96898);
    }

    public void logInWithReadPermissions(Activity activity, Collection<String> collection) {
        AppMethodBeat.m2504i(96899);
        validateReadPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
        AppMethodBeat.m2505o(96899);
    }

    public void reauthorizeDataAccess(Activity activity) {
        AppMethodBeat.m2504i(96900);
        startLogin(new ActivityStartActivityDelegate(activity), createReauthorizeRequest());
        AppMethodBeat.m2505o(96900);
    }

    public void reauthorizeDataAccess(Fragment fragment) {
        AppMethodBeat.m2504i(96901);
        reauthorizeDataAccess(new FragmentWrapper(fragment));
        AppMethodBeat.m2505o(96901);
    }

    private void reauthorizeDataAccess(FragmentWrapper fragmentWrapper) {
        AppMethodBeat.m2504i(96902);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createReauthorizeRequest());
        AppMethodBeat.m2505o(96902);
    }

    public void logInWithPublishPermissions(Fragment fragment, Collection<String> collection) {
        AppMethodBeat.m2504i(96903);
        logInWithPublishPermissions(new FragmentWrapper(fragment), (Collection) collection);
        AppMethodBeat.m2505o(96903);
    }

    public void logInWithPublishPermissions(android.app.Fragment fragment, Collection<String> collection) {
        AppMethodBeat.m2504i(96904);
        logInWithPublishPermissions(new FragmentWrapper(fragment), (Collection) collection);
        AppMethodBeat.m2505o(96904);
    }

    private void logInWithPublishPermissions(FragmentWrapper fragmentWrapper, Collection<String> collection) {
        AppMethodBeat.m2504i(96905);
        validatePublishPermissions(collection);
        startLogin(new FragmentStartActivityDelegate(fragmentWrapper), createLoginRequest(collection));
        AppMethodBeat.m2505o(96905);
    }

    public void logInWithPublishPermissions(Activity activity, Collection<String> collection) {
        AppMethodBeat.m2504i(96906);
        validatePublishPermissions(collection);
        startLogin(new ActivityStartActivityDelegate(activity), createLoginRequest(collection));
        AppMethodBeat.m2505o(96906);
    }

    private void validateReadPermissions(Collection<String> collection) {
        AppMethodBeat.m2504i(96907);
        if (collection == null) {
            AppMethodBeat.m2505o(96907);
            return;
        }
        for (String isPublishPermission : collection) {
            if (isPublishPermission(isPublishPermission)) {
                FacebookException facebookException = new FacebookException(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[]{(String) r1.next()}));
                AppMethodBeat.m2505o(96907);
                throw facebookException;
            }
        }
        AppMethodBeat.m2505o(96907);
    }

    private void validatePublishPermissions(Collection<String> collection) {
        AppMethodBeat.m2504i(96908);
        if (collection == null) {
            AppMethodBeat.m2505o(96908);
            return;
        }
        for (String isPublishPermission : collection) {
            if (!isPublishPermission(isPublishPermission)) {
                FacebookException facebookException = new FacebookException(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[]{(String) r1.next()}));
                AppMethodBeat.m2505o(96908);
                throw facebookException;
            }
        }
        AppMethodBeat.m2505o(96908);
    }

    static boolean isPublishPermission(String str) {
        AppMethodBeat.m2504i(96909);
        if (str == null || !(str.startsWith(PUBLISH_PERMISSION_PREFIX) || str.startsWith(MANAGE_PERMISSION_PREFIX) || OTHER_PUBLISH_PERMISSIONS.contains(str))) {
            AppMethodBeat.m2505o(96909);
            return false;
        }
        AppMethodBeat.m2505o(96909);
        return true;
    }

    private static Set<String> getOtherPublishPermissions() {
        AppMethodBeat.m2504i(96910);
        Set unmodifiableSet = Collections.unmodifiableSet(new C320022());
        AppMethodBeat.m2505o(96910);
        return unmodifiableSet;
    }

    /* Access modifiers changed, original: protected */
    public Request createLoginRequest(Collection<String> collection) {
        AppMethodBeat.m2504i(96911);
        Request request = new Request(this.loginBehavior, Collections.unmodifiableSet(collection != null ? new HashSet(collection) : new HashSet()), this.defaultAudience, this.authType, FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        request.setRerequest(AccessToken.isCurrentAccessTokenActive());
        AppMethodBeat.m2505o(96911);
        return request;
    }

    /* Access modifiers changed, original: protected */
    public Request createReauthorizeRequest() {
        AppMethodBeat.m2504i(96912);
        Request request = new Request(LoginBehavior.DIALOG_ONLY, new HashSet(), this.defaultAudience, "reauthorize", FacebookSdk.getApplicationId(), UUID.randomUUID().toString());
        AppMethodBeat.m2505o(96912);
        return request;
    }

    private void startLogin(StartActivityDelegate startActivityDelegate, Request request) {
        AppMethodBeat.m2504i(96913);
        logStartLogin(startActivityDelegate.getActivityContext(), request);
        CallbackManagerImpl.registerStaticCallback(RequestCodeOffset.Login.toRequestCode(), new C320033());
        if (tryFacebookActivity(startActivityDelegate, request)) {
            AppMethodBeat.m2505o(96913);
            return;
        }
        FacebookException facebookException = new FacebookException("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
        logCompleteLogin(startActivityDelegate.getActivityContext(), Code.ERROR, null, facebookException, false, request);
        AppMethodBeat.m2505o(96913);
        throw facebookException;
    }

    private void logStartLogin(Context context, Request request) {
        AppMethodBeat.m2504i(96914);
        LoginLogger access$000 = LoginLoggerHolder.access$000(context);
        if (!(access$000 == null || request == null)) {
            access$000.logStartLogin(request);
        }
        AppMethodBeat.m2505o(96914);
    }

    private void logCompleteLogin(Context context, Code code, Map<String, String> map, Exception exception, boolean z, Request request) {
        AppMethodBeat.m2504i(96915);
        LoginLogger access$000 = LoginLoggerHolder.access$000(context);
        if (access$000 == null) {
            AppMethodBeat.m2505o(96915);
        } else if (request == null) {
            access$000.logUnexpectedError("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            AppMethodBeat.m2505o(96915);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("try_login_activity", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            access$000.logCompleteLogin(request.getAuthId(), hashMap, code, map, exception);
            AppMethodBeat.m2505o(96915);
        }
    }

    private boolean tryFacebookActivity(StartActivityDelegate startActivityDelegate, Request request) {
        AppMethodBeat.m2504i(96916);
        Intent facebookActivityIntent = getFacebookActivityIntent(request);
        if (resolveIntent(facebookActivityIntent)) {
            try {
                startActivityDelegate.startActivityForResult(facebookActivityIntent, LoginClient.getLoginRequestCode());
                AppMethodBeat.m2505o(96916);
                return true;
            } catch (ActivityNotFoundException e) {
                AppMethodBeat.m2505o(96916);
                return false;
            }
        }
        AppMethodBeat.m2505o(96916);
        return false;
    }

    private boolean resolveIntent(Intent intent) {
        AppMethodBeat.m2504i(96917);
        if (FacebookSdk.getApplicationContext().getPackageManager().resolveActivity(intent, 0) != null) {
            AppMethodBeat.m2505o(96917);
            return true;
        }
        AppMethodBeat.m2505o(96917);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public Intent getFacebookActivityIntent(Request request) {
        AppMethodBeat.m2504i(96918);
        Intent intent = new Intent();
        intent.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
        intent.setAction(request.getLoginBehavior().toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, request);
        intent.putExtra("com.facebook.LoginFragment:Request", bundle);
        AppMethodBeat.m2505o(96918);
        return intent;
    }

    static LoginResult computeLoginResult(Request request, AccessToken accessToken) {
        AppMethodBeat.m2504i(96919);
        Set permissions = request.getPermissions();
        HashSet hashSet = new HashSet(accessToken.getPermissions());
        if (request.isRerequest()) {
            hashSet.retainAll(permissions);
        }
        HashSet hashSet2 = new HashSet(permissions);
        hashSet2.removeAll(hashSet);
        LoginResult loginResult = new LoginResult(accessToken, hashSet, hashSet2);
        AppMethodBeat.m2505o(96919);
        return loginResult;
    }

    private void finishLogin(AccessToken accessToken, Request request, FacebookException facebookException, boolean z, FacebookCallback<LoginResult> facebookCallback) {
        AppMethodBeat.m2504i(96920);
        if (accessToken != null) {
            AccessToken.setCurrentAccessToken(accessToken);
            Profile.fetchProfileForCurrentAccessToken();
        }
        if (facebookCallback != null) {
            LoginResult computeLoginResult = accessToken != null ? computeLoginResult(request, accessToken) : null;
            if (z || (computeLoginResult != null && computeLoginResult.getRecentlyGrantedPermissions().size() == 0)) {
                facebookCallback.onCancel();
                AppMethodBeat.m2505o(96920);
                return;
            } else if (facebookException != null) {
                facebookCallback.onError(facebookException);
                AppMethodBeat.m2505o(96920);
                return;
            } else if (accessToken != null) {
                setExpressLoginStatus(true);
                facebookCallback.onSuccess(computeLoginResult);
            }
        }
        AppMethodBeat.m2505o(96920);
    }

    private void retrieveLoginStatusImpl(Context context, LoginStatusCallback loginStatusCallback, long j) {
        AppMethodBeat.m2504i(96921);
        String applicationId = FacebookSdk.getApplicationId();
        String uuid = UUID.randomUUID().toString();
        final LoginLogger loginLogger = new LoginLogger(context, applicationId);
        if (isExpressLoginAllowed()) {
            LoginStatusClient loginStatusClient = new LoginStatusClient(context, applicationId, uuid, FacebookSdk.getGraphApiVersion(), j);
            final String str = uuid;
            final LoginStatusCallback loginStatusCallback2 = loginStatusCallback;
            final String str2 = applicationId;
            loginStatusClient.setCompletedListener(new CompletedListener() {
                public void completed(Bundle bundle) {
                    AppMethodBeat.m2504i(96873);
                    if (bundle != null) {
                        String string = bundle.getString(NativeProtocol.STATUS_ERROR_TYPE);
                        String string2 = bundle.getString(NativeProtocol.STATUS_ERROR_DESCRIPTION);
                        if (string != null) {
                            LoginManager.access$100(string, string2, str, loginLogger, loginStatusCallback2);
                            AppMethodBeat.m2505o(96873);
                            return;
                        }
                        String str;
                        string2 = bundle.getString(NativeProtocol.EXTRA_ACCESS_TOKEN);
                        Date bundleLongAsDate = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_EXPIRES_SECONDS_SINCE_EPOCH, new Date(0));
                        ArrayList stringArrayList = bundle.getStringArrayList(NativeProtocol.EXTRA_PERMISSIONS);
                        string = bundle.getString(NativeProtocol.RESULT_ARGS_SIGNED_REQUEST);
                        Date bundleLongAsDate2 = Utility.getBundleLongAsDate(bundle, NativeProtocol.EXTRA_DATA_ACCESS_EXPIRATION_TIME, new Date(0));
                        if (Utility.isNullOrEmpty(string)) {
                            str = null;
                        } else {
                            str = LoginMethodHandler.getUserIDFromSignedRequest(string);
                        }
                        if (Utility.isNullOrEmpty(string2) || stringArrayList == null || stringArrayList.isEmpty() || Utility.isNullOrEmpty(str)) {
                            loginLogger.logLoginStatusFailure(str);
                            loginStatusCallback2.onFailure();
                            AppMethodBeat.m2505o(96873);
                            return;
                        }
                        AccessToken accessToken = new AccessToken(string2, str2, str, stringArrayList, null, null, bundleLongAsDate, null, bundleLongAsDate2);
                        AccessToken.setCurrentAccessToken(accessToken);
                        Profile access$200 = LoginManager.access$200(bundle);
                        if (access$200 != null) {
                            Profile.setCurrentProfile(access$200);
                        } else {
                            Profile.fetchProfileForCurrentAccessToken();
                        }
                        loginLogger.logLoginStatusSuccess(str);
                        loginStatusCallback2.onCompleted(accessToken);
                        AppMethodBeat.m2505o(96873);
                        return;
                    }
                    loginLogger.logLoginStatusFailure(str);
                    loginStatusCallback2.onFailure();
                    AppMethodBeat.m2505o(96873);
                }
            });
            loginLogger.logLoginStatusStart(uuid);
            if (!loginStatusClient.start()) {
                loginLogger.logLoginStatusFailure(uuid);
                loginStatusCallback.onFailure();
            }
            AppMethodBeat.m2505o(96921);
            return;
        }
        loginLogger.logLoginStatusFailure(uuid);
        loginStatusCallback.onFailure();
        AppMethodBeat.m2505o(96921);
    }

    private void setExpressLoginStatus(boolean z) {
        AppMethodBeat.m2504i(96922);
        Editor edit = this.sharedPreferences.edit();
        edit.putBoolean(EXPRESS_LOGIN_ALLOWED, z);
        edit.apply();
        AppMethodBeat.m2505o(96922);
    }

    private boolean isExpressLoginAllowed() {
        AppMethodBeat.m2504i(96923);
        boolean z = this.sharedPreferences.getBoolean(EXPRESS_LOGIN_ALLOWED, true);
        AppMethodBeat.m2505o(96923);
        return z;
    }

    private static Profile getProfileFromBundle(Bundle bundle) {
        AppMethodBeat.m2504i(96924);
        String string = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_NAME);
        String string2 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_FIRST_NAME);
        String string3 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_MIDDLE_NAME);
        String string4 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_LAST_NAME);
        String string5 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_LINK);
        String string6 = bundle.getString(NativeProtocol.EXTRA_ARGS_PROFILE_USER_ID);
        if (string == null || string2 == null || string3 == null || string4 == null || string5 == null || string6 == null) {
            AppMethodBeat.m2505o(96924);
            return null;
        }
        Profile profile = new Profile(string6, string2, string3, string4, string, Uri.parse(string5));
        AppMethodBeat.m2505o(96924);
        return profile;
    }

    private static void handleLoginStatusError(String str, String str2, String str3, LoginLogger loginLogger, LoginStatusCallback loginStatusCallback) {
        AppMethodBeat.m2504i(96925);
        FacebookException facebookException = new FacebookException(str + ": " + str2);
        loginLogger.logLoginStatusError(str3, facebookException);
        loginStatusCallback.onError(facebookException);
        AppMethodBeat.m2505o(96925);
    }
}
