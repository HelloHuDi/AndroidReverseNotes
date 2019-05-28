package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookSdk;
import com.facebook.login.DefaultAudience;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

public final class NativeProtocol {
    public static final String ACTION_APPINVITE_DIALOG = "com.facebook.platform.action.request.APPINVITES_DIALOG";
    public static final String ACTION_CAMERA_EFFECT = "com.facebook.platform.action.request.CAMERA_EFFECT";
    public static final String ACTION_FEED_DIALOG = "com.facebook.platform.action.request.FEED_DIALOG";
    public static final String ACTION_LIKE_DIALOG = "com.facebook.platform.action.request.LIKE_DIALOG";
    public static final String ACTION_MESSAGE_DIALOG = "com.facebook.platform.action.request.MESSAGE_DIALOG";
    public static final String ACTION_OGACTIONPUBLISH_DIALOG = "com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG";
    public static final String ACTION_OGMESSAGEPUBLISH_DIALOG = "com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG";
    public static final String ACTION_SHARE_STORY = "com.facebook.platform.action.request.SHARE_STORY";
    public static final String AUDIENCE_EVERYONE = "everyone";
    public static final String AUDIENCE_FRIENDS = "friends";
    public static final String AUDIENCE_ME = "only_me";
    public static final String BRIDGE_ARG_ACTION_ID_STRING = "action_id";
    public static final String BRIDGE_ARG_APP_NAME_STRING = "app_name";
    public static final String BRIDGE_ARG_ERROR_BUNDLE = "error";
    public static final String BRIDGE_ARG_ERROR_CODE = "error_code";
    public static final String BRIDGE_ARG_ERROR_DESCRIPTION = "error_description";
    public static final String BRIDGE_ARG_ERROR_JSON = "error_json";
    public static final String BRIDGE_ARG_ERROR_SUBCODE = "error_subcode";
    public static final String BRIDGE_ARG_ERROR_TYPE = "error_type";
    private static final String CONTENT_SCHEME = "content://";
    public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
    public static final String ERROR_NETWORK_ERROR = "NetworkError";
    public static final String ERROR_PERMISSION_DENIED = "PermissionDenied";
    public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
    public static final String ERROR_SERVICE_DISABLED = "ServiceDisabled";
    public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_USER_CANCELED = "UserCanceled";
    public static final String EXTRA_ACCESS_TOKEN = "com.facebook.platform.extra.ACCESS_TOKEN";
    public static final String EXTRA_APPLICATION_ID = "com.facebook.platform.extra.APPLICATION_ID";
    public static final String EXTRA_APPLICATION_NAME = "com.facebook.platform.extra.APPLICATION_NAME";
    public static final String EXTRA_ARGS_PROFILE = "com.facebook.platform.extra.PROFILE";
    public static final String EXTRA_ARGS_PROFILE_FIRST_NAME = "com.facebook.platform.extra.PROFILE_FIRST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LAST_NAME = "com.facebook.platform.extra.PROFILE_LAST_NAME";
    public static final String EXTRA_ARGS_PROFILE_LINK = "com.facebook.platform.extra.PROFILE_LINK";
    public static final String EXTRA_ARGS_PROFILE_MIDDLE_NAME = "com.facebook.platform.extra.PROFILE_MIDDLE_NAME";
    public static final String EXTRA_ARGS_PROFILE_NAME = "com.facebook.platform.extra.PROFILE_NAME";
    public static final String EXTRA_ARGS_PROFILE_USER_ID = "com.facebook.platform.extra.PROFILE_USER_ID";
    public static final String EXTRA_DATA_ACCESS_EXPIRATION_TIME = "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME";
    public static final String EXTRA_DIALOG_COMPLETE_KEY = "com.facebook.platform.extra.DID_COMPLETE";
    public static final String EXTRA_DIALOG_COMPLETION_GESTURE_KEY = "com.facebook.platform.extra.COMPLETION_GESTURE";
    public static final String EXTRA_EXPIRES_SECONDS_SINCE_EPOCH = "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH";
    public static final String EXTRA_GET_INSTALL_DATA_PACKAGE = "com.facebook.platform.extra.INSTALLDATA_PACKAGE";
    public static final String EXTRA_GRAPH_API_VERSION = "com.facebook.platform.extra.GRAPH_API_VERSION";
    public static final String EXTRA_LOGGER_REF = "com.facebook.platform.extra.LOGGER_REF";
    public static final String EXTRA_PERMISSIONS = "com.facebook.platform.extra.PERMISSIONS";
    public static final String EXTRA_PROTOCOL_ACTION = "com.facebook.platform.protocol.PROTOCOL_ACTION";
    public static final String EXTRA_PROTOCOL_BRIDGE_ARGS = "com.facebook.platform.protocol.BRIDGE_ARGS";
    public static final String EXTRA_PROTOCOL_CALL_ID = "com.facebook.platform.protocol.CALL_ID";
    public static final String EXTRA_PROTOCOL_METHOD_ARGS = "com.facebook.platform.protocol.METHOD_ARGS";
    public static final String EXTRA_PROTOCOL_METHOD_RESULTS = "com.facebook.platform.protocol.RESULT_ARGS";
    public static final String EXTRA_PROTOCOL_VERSION = "com.facebook.platform.protocol.PROTOCOL_VERSION";
    static final String EXTRA_PROTOCOL_VERSIONS = "com.facebook.platform.extra.PROTOCOL_VERSIONS";
    public static final String EXTRA_TOAST_DURATION_MS = "com.facebook.platform.extra.EXTRA_TOAST_DURATION_MS";
    public static final String EXTRA_USER_ID = "com.facebook.platform.extra.USER_ID";
    private static final String FACEBOOK_PROXY_AUTH_ACTIVITY = "com.facebook.katana.ProxyAuth";
    public static final String FACEBOOK_PROXY_AUTH_APP_ID_KEY = "client_id";
    public static final String FACEBOOK_PROXY_AUTH_E2E_KEY = "e2e";
    public static final String FACEBOOK_PROXY_AUTH_PERMISSIONS_KEY = "scope";
    public static final String FACEBOOK_SDK_VERSION_KEY = "facebook_sdk_version";
    private static final String FACEBOOK_TOKEN_REFRESH_ACTIVITY = "com.facebook.katana.platform.TokenRefreshService";
    public static final String IMAGE_URL_KEY = "url";
    public static final String IMAGE_USER_GENERATED_KEY = "user_generated";
    static final String INTENT_ACTION_PLATFORM_ACTIVITY = "com.facebook.platform.PLATFORM_ACTIVITY";
    static final String INTENT_ACTION_PLATFORM_SERVICE = "com.facebook.platform.PLATFORM_SERVICE";
    private static final List<Integer> KNOWN_PROTOCOL_VERSIONS = Arrays.asList(new Integer[]{Integer.valueOf(PROTOCOL_VERSION_20170417), Integer.valueOf(PROTOCOL_VERSION_20160327), Integer.valueOf(PROTOCOL_VERSION_20141218), Integer.valueOf(PROTOCOL_VERSION_20141107), Integer.valueOf(PROTOCOL_VERSION_20141028), Integer.valueOf(PROTOCOL_VERSION_20141001), Integer.valueOf(PROTOCOL_VERSION_20140701), Integer.valueOf(PROTOCOL_VERSION_20140324), Integer.valueOf(PROTOCOL_VERSION_20140204), Integer.valueOf(PROTOCOL_VERSION_20131107), Integer.valueOf(PROTOCOL_VERSION_20130618), Integer.valueOf(PROTOCOL_VERSION_20130502), Integer.valueOf(PROTOCOL_VERSION_20121101)});
    public static final int MESSAGE_GET_ACCESS_TOKEN_REPLY = 65537;
    public static final int MESSAGE_GET_ACCESS_TOKEN_REQUEST = 65536;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REPLY = 65545;
    public static final int MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST = 65544;
    public static final int MESSAGE_GET_INSTALL_DATA_REPLY = 65541;
    public static final int MESSAGE_GET_INSTALL_DATA_REQUEST = 65540;
    public static final int MESSAGE_GET_LIKE_STATUS_REPLY = 65543;
    public static final int MESSAGE_GET_LIKE_STATUS_REQUEST = 65542;
    public static final int MESSAGE_GET_LOGIN_STATUS_REPLY = 65547;
    public static final int MESSAGE_GET_LOGIN_STATUS_REQUEST = 65546;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REPLY = 65539;
    static final int MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST = 65538;
    public static final int NO_PROTOCOL_AVAILABLE = -1;
    public static final String OPEN_GRAPH_CREATE_OBJECT_KEY = "fbsdk:create_object";
    private static final String PLATFORM_PROVIDER = ".provider.PlatformProvider";
    private static final String PLATFORM_PROVIDER_VERSIONS = ".provider.PlatformProvider/versions";
    private static final String PLATFORM_PROVIDER_VERSION_COLUMN = "version";
    public static final int PROTOCOL_VERSION_20121101 = 20121101;
    public static final int PROTOCOL_VERSION_20130502 = 20130502;
    public static final int PROTOCOL_VERSION_20130618 = 20130618;
    public static final int PROTOCOL_VERSION_20131107 = 20131107;
    public static final int PROTOCOL_VERSION_20140204 = 20140204;
    public static final int PROTOCOL_VERSION_20140324 = 20140324;
    public static final int PROTOCOL_VERSION_20140701 = 20140701;
    public static final int PROTOCOL_VERSION_20141001 = 20141001;
    public static final int PROTOCOL_VERSION_20141028 = 20141028;
    public static final int PROTOCOL_VERSION_20141107 = 20141107;
    public static final int PROTOCOL_VERSION_20141218 = 20141218;
    public static final int PROTOCOL_VERSION_20160327 = 20160327;
    public static final int PROTOCOL_VERSION_20170213 = 20170213;
    public static final int PROTOCOL_VERSION_20170411 = 20170411;
    public static final int PROTOCOL_VERSION_20170417 = 20170417;
    public static final int PROTOCOL_VERSION_20171115 = 20171115;
    public static final String RESULT_ARGS_ACCESS_TOKEN = "access_token";
    public static final String RESULT_ARGS_DIALOG_COMPLETE_KEY = "didComplete";
    public static final String RESULT_ARGS_DIALOG_COMPLETION_GESTURE_KEY = "completionGesture";
    public static final String RESULT_ARGS_EXPIRES_SECONDS_SINCE_EPOCH = "expires_seconds_since_epoch";
    public static final String RESULT_ARGS_PERMISSIONS = "permissions";
    public static final String RESULT_ARGS_SIGNED_REQUEST = "signed request";
    public static final String STATUS_ERROR_CODE = "com.facebook.platform.status.ERROR_CODE";
    public static final String STATUS_ERROR_DESCRIPTION = "com.facebook.platform.status.ERROR_DESCRIPTION";
    public static final String STATUS_ERROR_JSON = "com.facebook.platform.status.ERROR_JSON";
    public static final String STATUS_ERROR_SUBCODE = "com.facebook.platform.status.ERROR_SUBCODE";
    public static final String STATUS_ERROR_TYPE = "com.facebook.platform.status.ERROR_TYPE";
    private static final String TAG = NativeProtocol.class.getName();
    public static final String WEB_DIALOG_ACTION = "action";
    public static final String WEB_DIALOG_IS_FALLBACK = "is_fallback";
    public static final String WEB_DIALOG_PARAMS = "params";
    public static final String WEB_DIALOG_URL = "url";
    private static final Map<String, List<NativeAppInfo>> actionToAppInfoMap = buildActionToAppInfoMap();
    private static final List<NativeAppInfo> effectCameraAppInfoList = buildEffectCameraAppInfoList();
    private static final List<NativeAppInfo> facebookAppInfoList = buildFacebookAppList();
    private static final AtomicBoolean protocolVersionsAsyncUpdating = new AtomicBoolean(false);

    /* renamed from: com.facebook.internal.NativeProtocol$1 */
    static class C175961 implements Runnable {
        C175961() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72437);
            try {
                for (NativeAppInfo access$1000 : NativeProtocol.facebookAppInfoList) {
                    access$1000.fetchAvailableVersions(true);
                }
            } finally {
                NativeProtocol.protocolVersionsAsyncUpdating.set(false);
                AppMethodBeat.m2505o(72437);
            }
        }
    }

    static class MessengerAppInfo extends NativeAppInfo {
        static final String MESSENGER_PACKAGE = "com.facebook.orca";

        private MessengerAppInfo() {
            super();
        }

        /* synthetic */ MessengerAppInfo(C175961 c175961) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public String getPackage() {
            return MESSENGER_PACKAGE;
        }

        /* Access modifiers changed, original: protected */
        public String getLoginActivity() {
            return null;
        }
    }

    static class KatanaAppInfo extends NativeAppInfo {
        static final String KATANA_PACKAGE = "com.facebook.katana";

        private KatanaAppInfo() {
            super();
        }

        /* synthetic */ KatanaAppInfo(C175961 c175961) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public String getPackage() {
            return KATANA_PACKAGE;
        }

        /* Access modifiers changed, original: protected */
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }
    }

    static class WakizashiAppInfo extends NativeAppInfo {
        static final String WAKIZASHI_PACKAGE = "com.facebook.wakizashi";

        private WakizashiAppInfo() {
            super();
        }

        /* synthetic */ WakizashiAppInfo(C175961 c175961) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public String getPackage() {
            return WAKIZASHI_PACKAGE;
        }

        /* Access modifiers changed, original: protected */
        public String getLoginActivity() {
            return NativeProtocol.FACEBOOK_PROXY_AUTH_ACTIVITY;
        }
    }

    public static class ProtocolVersionQueryResult {
        private NativeAppInfo nativeAppInfo;
        private int protocolVersion;

        public static ProtocolVersionQueryResult create(NativeAppInfo nativeAppInfo, int i) {
            AppMethodBeat.m2504i(72438);
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.nativeAppInfo = nativeAppInfo;
            protocolVersionQueryResult.protocolVersion = i;
            AppMethodBeat.m2505o(72438);
            return protocolVersionQueryResult;
        }

        public static ProtocolVersionQueryResult createEmpty() {
            AppMethodBeat.m2504i(72439);
            ProtocolVersionQueryResult protocolVersionQueryResult = new ProtocolVersionQueryResult();
            protocolVersionQueryResult.protocolVersion = -1;
            AppMethodBeat.m2505o(72439);
            return protocolVersionQueryResult;
        }

        private ProtocolVersionQueryResult() {
        }

        public NativeAppInfo getAppInfo() {
            return this.nativeAppInfo;
        }

        public int getProtocolVersion() {
            return this.protocolVersion;
        }
    }

    static class EffectTestAppInfo extends NativeAppInfo {
        static final String EFFECT_TEST_APP_PACKAGE = "com.facebook.arstudio.player";

        private EffectTestAppInfo() {
            super();
        }

        /* synthetic */ EffectTestAppInfo(C175961 c175961) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public String getPackage() {
            return EFFECT_TEST_APP_PACKAGE;
        }

        /* Access modifiers changed, original: protected */
        public String getLoginActivity() {
            return null;
        }
    }

    static class FBLiteAppInfo extends NativeAppInfo {
        static final String FACEBOOK_LITE_ACTIVITY = "com.facebook.lite.platform.LoginGDPDialogActivity";
        static final String FBLITE_PACKAGE = "com.facebook.lite";

        private FBLiteAppInfo() {
            super();
        }

        /* synthetic */ FBLiteAppInfo(C175961 c175961) {
            this();
        }

        /* Access modifiers changed, original: protected */
        public String getPackage() {
            return FBLITE_PACKAGE;
        }

        /* Access modifiers changed, original: protected */
        public String getLoginActivity() {
            return FACEBOOK_LITE_ACTIVITY;
        }
    }

    static abstract class NativeAppInfo {
        private TreeSet<Integer> availableVersions;

        public abstract String getLoginActivity();

        public abstract String getPackage();

        private NativeAppInfo() {
        }

        /* synthetic */ NativeAppInfo(C175961 c175961) {
            this();
        }

        public TreeSet<Integer> getAvailableVersions() {
            if (this.availableVersions == null) {
                fetchAvailableVersions(false);
            }
            return this.availableVersions;
        }

        /* JADX WARNING: Missing block: B:4:0x0005, code skipped:
            if (r1.availableVersions == null) goto L_0x0007;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private synchronized void fetchAvailableVersions(boolean z) {
            if (!z) {
            }
            this.availableVersions = NativeProtocol.access$000(this);
        }
    }

    static /* synthetic */ TreeSet access$000(NativeAppInfo nativeAppInfo) {
        AppMethodBeat.m2504i(72471);
        TreeSet fetchAllAvailableProtocolVersionsForAppInfo = fetchAllAvailableProtocolVersionsForAppInfo(nativeAppInfo);
        AppMethodBeat.m2505o(72471);
        return fetchAllAvailableProtocolVersionsForAppInfo;
    }

    static {
        AppMethodBeat.m2504i(72472);
        AppMethodBeat.m2505o(72472);
    }

    private static List<NativeAppInfo> buildFacebookAppList() {
        AppMethodBeat.m2504i(72440);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KatanaAppInfo());
        arrayList.add(new WakizashiAppInfo());
        AppMethodBeat.m2505o(72440);
        return arrayList;
    }

    private static List<NativeAppInfo> buildEffectCameraAppInfoList() {
        AppMethodBeat.m2504i(72441);
        ArrayList arrayList = new ArrayList(buildFacebookAppList());
        arrayList.add(0, new EffectTestAppInfo());
        AppMethodBeat.m2505o(72441);
        return arrayList;
    }

    private static Map<String, List<NativeAppInfo>> buildActionToAppInfoMap() {
        AppMethodBeat.m2504i(72442);
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new MessengerAppInfo());
        hashMap.put(ACTION_OGACTIONPUBLISH_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_FEED_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_LIKE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_APPINVITE_DIALOG, facebookAppInfoList);
        hashMap.put(ACTION_MESSAGE_DIALOG, arrayList);
        hashMap.put(ACTION_OGMESSAGEPUBLISH_DIALOG, arrayList);
        hashMap.put(ACTION_CAMERA_EFFECT, effectCameraAppInfoList);
        hashMap.put(ACTION_SHARE_STORY, facebookAppInfoList);
        AppMethodBeat.m2505o(72442);
        return hashMap;
    }

    static Intent validateActivityIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        AppMethodBeat.m2504i(72443);
        if (intent == null) {
            AppMethodBeat.m2505o(72443);
            return null;
        }
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            AppMethodBeat.m2505o(72443);
            return null;
        } else if (FacebookSignatureValidator.validateSignature(context, resolveActivity.activityInfo.packageName)) {
            AppMethodBeat.m2505o(72443);
            return intent;
        } else {
            AppMethodBeat.m2505o(72443);
            return null;
        }
    }

    static Intent validateServiceIntent(Context context, Intent intent, NativeAppInfo nativeAppInfo) {
        AppMethodBeat.m2504i(72444);
        if (intent == null) {
            AppMethodBeat.m2505o(72444);
            return null;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService == null) {
            AppMethodBeat.m2505o(72444);
            return null;
        } else if (FacebookSignatureValidator.validateSignature(context, resolveService.serviceInfo.packageName)) {
            AppMethodBeat.m2505o(72444);
            return intent;
        } else {
            AppMethodBeat.m2505o(72444);
            return null;
        }
    }

    public static Intent createFacebookLiteIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.m2504i(72445);
        FBLiteAppInfo fBLiteAppInfo = new FBLiteAppInfo();
        Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(fBLiteAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), fBLiteAppInfo);
        AppMethodBeat.m2505o(72445);
        return validateActivityIntent;
    }

    private static Intent createNativeAppIntent(NativeAppInfo nativeAppInfo, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.m2504i(72446);
        String loginActivity = nativeAppInfo.getLoginActivity();
        if (loginActivity == null) {
            AppMethodBeat.m2505o(72446);
            return null;
        }
        Intent putExtra = new Intent().setClassName(nativeAppInfo.getPackage(), loginActivity).putExtra("client_id", str);
        putExtra.putExtra(FACEBOOK_SDK_VERSION_KEY, FacebookSdk.getSdkVersion());
        if (!Utility.isNullOrEmpty((Collection) collection)) {
            putExtra.putExtra("scope", TextUtils.join(",", collection));
        }
        if (!Utility.isNullOrEmpty(str2)) {
            putExtra.putExtra("e2e", str2);
        }
        putExtra.putExtra("state", str3);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, ServerProtocol.DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST);
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_RETURN_SCOPES, "true");
        if (z2) {
            putExtra.putExtra(ServerProtocol.DIALOG_PARAM_DEFAULT_AUDIENCE, defaultAudience.getNativeProtocolAudience());
        }
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_LEGACY_OVERRIDE, FacebookSdk.getGraphApiVersion());
        putExtra.putExtra(ServerProtocol.DIALOG_PARAM_AUTH_TYPE, str4);
        AppMethodBeat.m2505o(72446);
        return putExtra;
    }

    public static Intent createProxyAuthIntent(Context context, String str, Collection<String> collection, String str2, boolean z, boolean z2, DefaultAudience defaultAudience, String str3, String str4) {
        AppMethodBeat.m2504i(72447);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateActivityIntent = validateActivityIntent(context, createNativeAppIntent(nativeAppInfo, str, collection, str2, z, z2, defaultAudience, str3, str4), nativeAppInfo);
            if (validateActivityIntent != null) {
                AppMethodBeat.m2505o(72447);
                return validateActivityIntent;
            }
        }
        AppMethodBeat.m2505o(72447);
        return null;
    }

    public static Intent createTokenRefreshIntent(Context context) {
        AppMethodBeat.m2504i(72448);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent().setClassName(nativeAppInfo.getPackage(), FACEBOOK_TOKEN_REFRESH_ACTIVITY), nativeAppInfo);
            if (validateServiceIntent != null) {
                AppMethodBeat.m2505o(72448);
                return validateServiceIntent;
            }
        }
        AppMethodBeat.m2505o(72448);
        return null;
    }

    public static final int getLatestKnownVersion() {
        AppMethodBeat.m2504i(72449);
        int intValue = ((Integer) KNOWN_PROTOCOL_VERSIONS.get(0)).intValue();
        AppMethodBeat.m2505o(72449);
        return intValue;
    }

    public static boolean isVersionCompatibleWithBucketedIntent(int i) {
        AppMethodBeat.m2504i(72450);
        if (!KNOWN_PROTOCOL_VERSIONS.contains(Integer.valueOf(i)) || i < PROTOCOL_VERSION_20140701) {
            AppMethodBeat.m2505o(72450);
            return false;
        }
        AppMethodBeat.m2505o(72450);
        return true;
    }

    public static Intent createPlatformActivityIntent(Context context, String str, String str2, ProtocolVersionQueryResult protocolVersionQueryResult, Bundle bundle) {
        AppMethodBeat.m2504i(72451);
        if (protocolVersionQueryResult == null) {
            AppMethodBeat.m2505o(72451);
            return null;
        }
        NativeAppInfo access$700 = protocolVersionQueryResult.nativeAppInfo;
        if (access$700 == null) {
            AppMethodBeat.m2505o(72451);
            return null;
        }
        Intent validateActivityIntent = validateActivityIntent(context, new Intent().setAction(INTENT_ACTION_PLATFORM_ACTIVITY).setPackage(access$700.getPackage()).addCategory("android.intent.category.DEFAULT"), access$700);
        if (validateActivityIntent == null) {
            AppMethodBeat.m2505o(72451);
            return null;
        }
        setupProtocolRequestIntent(validateActivityIntent, str, str2, protocolVersionQueryResult.protocolVersion, bundle);
        AppMethodBeat.m2505o(72451);
        return validateActivityIntent;
    }

    public static void setupProtocolRequestIntent(Intent intent, String str, String str2, int i, Bundle bundle) {
        AppMethodBeat.m2504i(72452);
        String applicationId = FacebookSdk.getApplicationId();
        String applicationName = FacebookSdk.getApplicationName();
        intent.putExtra(EXTRA_PROTOCOL_VERSION, i).putExtra(EXTRA_PROTOCOL_ACTION, str2).putExtra(EXTRA_APPLICATION_ID, applicationId);
        if (isVersionCompatibleWithBucketedIntent(i)) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("action_id", str);
            Utility.putNonEmptyString(bundle2, BRIDGE_ARG_APP_NAME_STRING, applicationName);
            intent.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
            if (bundle == null) {
                bundle = new Bundle();
            }
            intent.putExtra(EXTRA_PROTOCOL_METHOD_ARGS, bundle);
            AppMethodBeat.m2505o(72452);
            return;
        }
        intent.putExtra(EXTRA_PROTOCOL_CALL_ID, str);
        if (!Utility.isNullOrEmpty(applicationName)) {
            intent.putExtra(EXTRA_APPLICATION_NAME, applicationName);
        }
        intent.putExtras(bundle);
        AppMethodBeat.m2505o(72452);
    }

    public static Intent createProtocolResultIntent(Intent intent, Bundle bundle, FacebookException facebookException) {
        AppMethodBeat.m2504i(72453);
        UUID callIdFromIntent = getCallIdFromIntent(intent);
        if (callIdFromIntent == null) {
            AppMethodBeat.m2505o(72453);
            return null;
        }
        Intent intent2 = new Intent();
        intent2.putExtra(EXTRA_PROTOCOL_VERSION, getProtocolVersionFromIntent(intent));
        Bundle bundle2 = new Bundle();
        bundle2.putString("action_id", callIdFromIntent.toString());
        if (facebookException != null) {
            bundle2.putBundle("error", createBundleForException(facebookException));
        }
        intent2.putExtra(EXTRA_PROTOCOL_BRIDGE_ARGS, bundle2);
        if (bundle != null) {
            intent2.putExtra(EXTRA_PROTOCOL_METHOD_RESULTS, bundle);
        }
        AppMethodBeat.m2505o(72453);
        return intent2;
    }

    public static Intent createPlatformServiceIntent(Context context) {
        AppMethodBeat.m2504i(72454);
        for (NativeAppInfo nativeAppInfo : facebookAppInfoList) {
            Intent validateServiceIntent = validateServiceIntent(context, new Intent(INTENT_ACTION_PLATFORM_SERVICE).setPackage(nativeAppInfo.getPackage()).addCategory("android.intent.category.DEFAULT"), nativeAppInfo);
            if (validateServiceIntent != null) {
                AppMethodBeat.m2505o(72454);
                return validateServiceIntent;
            }
        }
        AppMethodBeat.m2505o(72454);
        return null;
    }

    public static int getProtocolVersionFromIntent(Intent intent) {
        AppMethodBeat.m2504i(72455);
        int intExtra = intent.getIntExtra(EXTRA_PROTOCOL_VERSION, 0);
        AppMethodBeat.m2505o(72455);
        return intExtra;
    }

    public static UUID getCallIdFromIntent(Intent intent) {
        UUID uuid = null;
        AppMethodBeat.m2504i(72456);
        if (intent == null) {
            AppMethodBeat.m2505o(72456);
        } else {
            String string;
            if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
                Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
                if (bundleExtra != null) {
                    string = bundleExtra.getString("action_id");
                } else {
                    Object string2 = uuid;
                }
            } else {
                string2 = intent.getStringExtra(EXTRA_PROTOCOL_CALL_ID);
            }
            if (string2 != null) {
                try {
                    uuid = UUID.fromString(string2);
                } catch (IllegalArgumentException e) {
                }
            }
            AppMethodBeat.m2505o(72456);
        }
        return uuid;
    }

    public static Bundle getBridgeArgumentsFromIntent(Intent intent) {
        AppMethodBeat.m2504i(72457);
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            Bundle bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_BRIDGE_ARGS);
            AppMethodBeat.m2505o(72457);
            return bundleExtra;
        }
        AppMethodBeat.m2505o(72457);
        return null;
    }

    public static Bundle getMethodArgumentsFromIntent(Intent intent) {
        AppMethodBeat.m2504i(72458);
        Bundle bundleExtra;
        if (isVersionCompatibleWithBucketedIntent(getProtocolVersionFromIntent(intent))) {
            bundleExtra = intent.getBundleExtra(EXTRA_PROTOCOL_METHOD_ARGS);
            AppMethodBeat.m2505o(72458);
            return bundleExtra;
        }
        bundleExtra = intent.getExtras();
        AppMethodBeat.m2505o(72458);
        return bundleExtra;
    }

    public static Bundle getSuccessResultsFromIntent(Intent intent) {
        AppMethodBeat.m2504i(72459);
        int protocolVersionFromIntent = getProtocolVersionFromIntent(intent);
        Bundle extras = intent.getExtras();
        if (!isVersionCompatibleWithBucketedIntent(protocolVersionFromIntent) || extras == null) {
            AppMethodBeat.m2505o(72459);
            return extras;
        }
        extras = extras.getBundle(EXTRA_PROTOCOL_METHOD_RESULTS);
        AppMethodBeat.m2505o(72459);
        return extras;
    }

    public static boolean isErrorResult(Intent intent) {
        AppMethodBeat.m2504i(72460);
        Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
        boolean containsKey;
        if (bridgeArgumentsFromIntent != null) {
            containsKey = bridgeArgumentsFromIntent.containsKey("error");
            AppMethodBeat.m2505o(72460);
            return containsKey;
        }
        containsKey = intent.hasExtra(STATUS_ERROR_TYPE);
        AppMethodBeat.m2505o(72460);
        return containsKey;
    }

    public static Bundle getErrorDataFromResultIntent(Intent intent) {
        AppMethodBeat.m2504i(72461);
        if (isErrorResult(intent)) {
            Bundle bridgeArgumentsFromIntent = getBridgeArgumentsFromIntent(intent);
            if (bridgeArgumentsFromIntent != null) {
                bridgeArgumentsFromIntent = bridgeArgumentsFromIntent.getBundle("error");
                AppMethodBeat.m2505o(72461);
                return bridgeArgumentsFromIntent;
            }
            bridgeArgumentsFromIntent = intent.getExtras();
            AppMethodBeat.m2505o(72461);
            return bridgeArgumentsFromIntent;
        }
        AppMethodBeat.m2505o(72461);
        return null;
    }

    public static FacebookException getExceptionFromErrorData(Bundle bundle) {
        AppMethodBeat.m2504i(72462);
        if (bundle == null) {
            AppMethodBeat.m2505o(72462);
            return null;
        }
        String string = bundle.getString(BRIDGE_ARG_ERROR_TYPE);
        if (string == null) {
            string = bundle.getString(STATUS_ERROR_TYPE);
        }
        String string2 = bundle.getString(BRIDGE_ARG_ERROR_DESCRIPTION);
        if (string2 == null) {
            string2 = bundle.getString(STATUS_ERROR_DESCRIPTION);
        }
        FacebookException facebookException;
        if (string == null || !string.equalsIgnoreCase(ERROR_USER_CANCELED)) {
            facebookException = new FacebookException(string2);
            AppMethodBeat.m2505o(72462);
            return facebookException;
        }
        facebookException = new FacebookOperationCanceledException(string2);
        AppMethodBeat.m2505o(72462);
        return facebookException;
    }

    public static Bundle createBundleForException(FacebookException facebookException) {
        AppMethodBeat.m2504i(72463);
        if (facebookException == null) {
            AppMethodBeat.m2505o(72463);
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString(BRIDGE_ARG_ERROR_DESCRIPTION, facebookException.toString());
        if (facebookException instanceof FacebookOperationCanceledException) {
            bundle.putString(BRIDGE_ARG_ERROR_TYPE, ERROR_USER_CANCELED);
        }
        AppMethodBeat.m2505o(72463);
        return bundle;
    }

    public static int getLatestAvailableProtocolVersionForService(int i) {
        AppMethodBeat.m2504i(72464);
        int protocolVersion = getLatestAvailableProtocolVersionForAppInfoList(facebookAppInfoList, new int[]{i}).getProtocolVersion();
        AppMethodBeat.m2505o(72464);
        return protocolVersion;
    }

    public static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAction(String str, int[] iArr) {
        AppMethodBeat.m2504i(72465);
        ProtocolVersionQueryResult latestAvailableProtocolVersionForAppInfoList = getLatestAvailableProtocolVersionForAppInfoList((List) actionToAppInfoMap.get(str), iArr);
        AppMethodBeat.m2505o(72465);
        return latestAvailableProtocolVersionForAppInfoList;
    }

    private static ProtocolVersionQueryResult getLatestAvailableProtocolVersionForAppInfoList(List<NativeAppInfo> list, int[] iArr) {
        AppMethodBeat.m2504i(72466);
        updateAllAvailableProtocolVersionsAsync();
        ProtocolVersionQueryResult createEmpty;
        if (list == null) {
            createEmpty = ProtocolVersionQueryResult.createEmpty();
            AppMethodBeat.m2505o(72466);
            return createEmpty;
        }
        for (NativeAppInfo nativeAppInfo : list) {
            int computeLatestAvailableVersionFromVersionSpec = computeLatestAvailableVersionFromVersionSpec(nativeAppInfo.getAvailableVersions(), getLatestKnownVersion(), iArr);
            if (computeLatestAvailableVersionFromVersionSpec != -1) {
                createEmpty = ProtocolVersionQueryResult.create(nativeAppInfo, computeLatestAvailableVersionFromVersionSpec);
                AppMethodBeat.m2505o(72466);
                return createEmpty;
            }
        }
        createEmpty = ProtocolVersionQueryResult.createEmpty();
        AppMethodBeat.m2505o(72466);
        return createEmpty;
    }

    public static void updateAllAvailableProtocolVersionsAsync() {
        AppMethodBeat.m2504i(72467);
        if (protocolVersionsAsyncUpdating.compareAndSet(false, true)) {
            FacebookSdk.getExecutor().execute(new C175961());
            AppMethodBeat.m2505o(72467);
            return;
        }
        AppMethodBeat.m2505o(72467);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static TreeSet<Integer> fetchAllAvailableProtocolVersionsForAppInfo(NativeAppInfo nativeAppInfo) {
        Throwable th;
        AppMethodBeat.m2504i(72468);
        TreeSet treeSet = new TreeSet();
        ContentResolver contentResolver = FacebookSdk.getApplicationContext().getContentResolver();
        String[] strArr = new String[]{"version"};
        Uri buildPlatformProviderVersionURI = buildPlatformProviderVersionURI(nativeAppInfo);
        Cursor query;
        try {
            ProviderInfo resolveContentProvider;
            try {
                resolveContentProvider = FacebookSdk.getApplicationContext().getPackageManager().resolveContentProvider(nativeAppInfo.getPackage() + PLATFORM_PROVIDER, 0);
            } catch (RuntimeException e) {
                resolveContentProvider = null;
            }
            if (resolveContentProvider != null) {
                try {
                    query = contentResolver.query(buildPlatformProviderVersionURI, strArr, null, null, null);
                } catch (IllegalArgumentException | NullPointerException | SecurityException e2) {
                    query = null;
                }
                if (query != null) {
                    while (query.moveToNext()) {
                        try {
                            treeSet.add(Integer.valueOf(query.getInt(query.getColumnIndex("version"))));
                        } catch (Throwable th2) {
                            th = th2;
                            if (query != null) {
                            }
                            AppMethodBeat.m2505o(72468);
                            throw th;
                        }
                    }
                }
            }
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(72468);
            return treeSet;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(72468);
            throw th;
        }
    }

    public static int computeLatestAvailableVersionFromVersionSpec(TreeSet<Integer> treeSet, int i, int[] iArr) {
        AppMethodBeat.m2504i(72469);
        int length = iArr.length - 1;
        Iterator descendingIterator = treeSet.descendingIterator();
        int i2 = -1;
        int i3 = length;
        while (descendingIterator.hasNext()) {
            int intValue = ((Integer) descendingIterator.next()).intValue();
            length = Math.max(i2, intValue);
            while (i3 >= 0 && iArr[i3] > intValue) {
                i3--;
            }
            if (i3 < 0) {
                AppMethodBeat.m2505o(72469);
                return -1;
            } else if (iArr[i3] != intValue) {
                i2 = length;
            } else if (i3 % 2 == 0) {
                int min = Math.min(length, i);
                AppMethodBeat.m2505o(72469);
                return min;
            } else {
                AppMethodBeat.m2505o(72469);
                return -1;
            }
        }
        AppMethodBeat.m2505o(72469);
        return -1;
    }

    private static Uri buildPlatformProviderVersionURI(NativeAppInfo nativeAppInfo) {
        AppMethodBeat.m2504i(72470);
        Uri parse = Uri.parse(new StringBuilder(CONTENT_SCHEME).append(nativeAppInfo.getPackage()).append(PLATFORM_PROVIDER_VERSIONS).toString());
        AppMethodBeat.m2505o(72470);
        return parse;
    }
}
