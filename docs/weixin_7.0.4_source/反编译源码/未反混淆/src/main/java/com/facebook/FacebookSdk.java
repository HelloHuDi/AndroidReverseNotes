package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.util.Base64;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.internal.AppEventsLoggerUtility.GraphAPIActivityType;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BoltsMeasurementEventListener;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.FetchedAppSettingsManager.FetchedAppSettingsCallback;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

public final class FacebookSdk {
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY = new ThreadFactory() {
        private final AtomicInteger counter = new AtomicInteger(0);

        {
            AppMethodBeat.i(71597);
            AppMethodBeat.o(71597);
        }

        public final Thread newThread(Runnable runnable) {
            AppMethodBeat.i(71598);
            Thread thread = new Thread(runnable, "FacebookSdk #" + this.counter.incrementAndGet());
            AppMethodBeat.o(71598);
            return thread;
        }
    };
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE = new LinkedBlockingQueue(10);
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK = new Object();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    private static volatile String appClientToken;
    private static Context applicationContext;
    private static volatile String applicationId;
    private static volatile String applicationName;
    private static volatile Boolean autoLogAppEventsEnabled;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    private static volatile Boolean codelessDebugLogEnabled;
    private static Executor executor;
    private static volatile String facebookDomain = FACEBOOK_COM;
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    private static volatile boolean isDebugEnabled = false;
    private static boolean isLegacyTokenUpgradeSupported = false;
    private static final HashSet<LoggingBehavior> loggingBehaviors = new HashSet(Arrays.asList(new LoggingBehavior[]{LoggingBehavior.DEVELOPER_ERRORS}));
    private static AtomicLong onProgressThreshold = new AtomicLong(65536);
    private static Boolean sdkInitialized = Boolean.FALSE;

    public interface InitializeCallback {
        void onInitialized();
    }

    static {
        AppMethodBeat.i(71638);
        AppMethodBeat.o(71638);
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(71605);
            sdkInitialize(context, i, null);
            AppMethodBeat.o(71605);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context, int i, InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(71606);
            FacebookException facebookException;
            if (sdkInitialized.booleanValue() && i != callbackRequestCodeOffset) {
                facebookException = new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                AppMethodBeat.o(71606);
                throw facebookException;
            } else if (i < 0) {
                facebookException = new FacebookException(CALLBACK_OFFSET_NEGATIVE);
                AppMethodBeat.o(71606);
                throw facebookException;
            } else {
                callbackRequestCodeOffset = i;
                sdkInitialize(context, initializeCallback);
                AppMethodBeat.o(71606);
            }
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(Context context) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(71607);
            sdkInitialize(context, null);
            AppMethodBeat.o(71607);
        }
    }

    @Deprecated
    public static synchronized void sdkInitialize(final Context context, final InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(71608);
            if (sdkInitialized.booleanValue()) {
                if (initializeCallback != null) {
                    initializeCallback.onInitialized();
                }
                AppMethodBeat.o(71608);
            } else {
                Validate.notNull(context, "applicationContext");
                Validate.hasFacebookActivity(context, false);
                Validate.hasInternetPermissions(context, false);
                Context applicationContext = context.getApplicationContext();
                applicationContext = applicationContext;
                loadDefaultsFromMetadata(applicationContext);
                if (Utility.isNullOrEmpty(applicationId)) {
                    FacebookException facebookException = new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
                    AppMethodBeat.o(71608);
                    throw facebookException;
                }
                if ((applicationContext instanceof Application) && autoLogAppEventsEnabled.booleanValue()) {
                    ActivityLifecycleTracker.startTracking((Application) applicationContext, applicationId);
                }
                sdkInitialized = Boolean.TRUE;
                FetchedAppSettingsManager.getAppSettingsAsync(new FetchedAppSettingsCallback() {
                    public final void onSuccess(FetchedAppSettings fetchedAppSettings) {
                        AppMethodBeat.i(71599);
                        FetchedAppGateKeepersManager.loadAppGateKeepersAsync();
                        AppMethodBeat.o(71599);
                    }

                    public final void onError() {
                    }
                });
                NativeProtocol.updateAllAvailableProtocolVersionsAsync();
                BoltsMeasurementEventListener.getInstance(applicationContext);
                cacheDir = new LockOnGetVariable(new Callable<File>() {
                    public final File call() {
                        AppMethodBeat.i(71600);
                        File cacheDir = FacebookSdk.applicationContext.getCacheDir();
                        AppMethodBeat.o(71600);
                        return cacheDir;
                    }
                });
                getExecutor().execute(new FutureTask(new Callable<Void>() {
                    public final Void call() {
                        AppMethodBeat.i(71602);
                        AccessTokenManager.getInstance().loadCurrentAccessToken();
                        ProfileManager.getInstance().loadCurrentProfile();
                        if (AccessToken.isCurrentAccessTokenActive() && Profile.getCurrentProfile() == null) {
                            Profile.fetchProfileForCurrentAccessToken();
                        }
                        if (initializeCallback != null) {
                            initializeCallback.onInitialized();
                        }
                        AppEventsLogger.initializeLib(FacebookSdk.applicationContext, FacebookSdk.applicationId);
                        AppEventsLogger.newLogger(context.getApplicationContext()).flush();
                        AppMethodBeat.o(71602);
                        return null;
                    }
                }));
                AppMethodBeat.o(71608);
            }
        }
    }

    public static synchronized boolean isInitialized() {
        boolean booleanValue;
        synchronized (FacebookSdk.class) {
            AppMethodBeat.i(71609);
            booleanValue = sdkInitialized.booleanValue();
            AppMethodBeat.o(71609);
        }
        return booleanValue;
    }

    public static Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        AppMethodBeat.i(71610);
        synchronized (loggingBehaviors) {
            try {
                unmodifiableSet = Collections.unmodifiableSet(new HashSet(loggingBehaviors));
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71610);
            }
        }
        return unmodifiableSet;
    }

    public static void addLoggingBehavior(LoggingBehavior loggingBehavior) {
        AppMethodBeat.i(71611);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.add(loggingBehavior);
                updateGraphDebugBehavior();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71611);
            }
        }
    }

    public static void removeLoggingBehavior(LoggingBehavior loggingBehavior) {
        AppMethodBeat.i(71612);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.remove(loggingBehavior);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71612);
            }
        }
    }

    public static void clearLoggingBehaviors() {
        AppMethodBeat.i(71613);
        synchronized (loggingBehaviors) {
            try {
                loggingBehaviors.clear();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71613);
            }
        }
    }

    public static boolean isLoggingBehaviorEnabled(LoggingBehavior loggingBehavior) {
        boolean z;
        AppMethodBeat.i(71614);
        synchronized (loggingBehaviors) {
            try {
                z = isDebugEnabled() && loggingBehaviors.contains(loggingBehavior);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71614);
            }
        }
        return z;
    }

    public static boolean isDebugEnabled() {
        return isDebugEnabled;
    }

    public static void setIsDebugEnabled(boolean z) {
        isDebugEnabled = z;
    }

    public static boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    private static void updateGraphDebugBehavior() {
        AppMethodBeat.i(71615);
        if (loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO) && !loggingBehaviors.contains(LoggingBehavior.GRAPH_API_DEBUG_WARNING)) {
            loggingBehaviors.add(LoggingBehavior.GRAPH_API_DEBUG_WARNING);
        }
        AppMethodBeat.o(71615);
    }

    public static void setLegacyTokenUpgradeSupported(boolean z) {
        isLegacyTokenUpgradeSupported = z;
    }

    public static Executor getExecutor() {
        synchronized (LOCK) {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
        }
        return executor;
    }

    public static void setExecutor(Executor executor) {
        AppMethodBeat.i(71616);
        Validate.notNull(executor, "executor");
        synchronized (LOCK) {
            try {
                executor = executor;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71616);
            }
        }
    }

    public static String getFacebookDomain() {
        return facebookDomain;
    }

    public static void setFacebookDomain(String str) {
        facebookDomain = str;
    }

    public static Context getApplicationContext() {
        AppMethodBeat.i(71617);
        Validate.sdkInitialized();
        Context context = applicationContext;
        AppMethodBeat.o(71617);
        return context;
    }

    public static void setGraphApiVersion(String str) {
        AppMethodBeat.i(71618);
        if (!(Utility.isNullOrEmpty(str) || graphApiVersion.equals(str))) {
            graphApiVersion = str;
        }
        AppMethodBeat.o(71618);
    }

    public static String getGraphApiVersion() {
        AppMethodBeat.i(71619);
        Utility.logd(TAG, String.format("getGraphApiVersion: %s", new Object[]{graphApiVersion}));
        String str = graphApiVersion;
        AppMethodBeat.o(71619);
        return str;
    }

    public static void publishInstallAsync(Context context, final String str) {
        AppMethodBeat.i(71620);
        final Context applicationContext = context.getApplicationContext();
        getExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71604);
                FacebookSdk.publishInstallAndWaitForResponse(applicationContext, str);
                AppMethodBeat.o(71604);
            }
        });
        AppMethodBeat.o(71620);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:3:0x000c, B:10:0x004c] */
    /* JADX WARNING: Missing block: B:6:0x001b, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:7:0x001c, code skipped:
            com.facebook.internal.Utility.logd("Facebook-publish", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(71621);
     */
    /* JADX WARNING: Missing block: B:17:0x0086, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:19:?, code skipped:
            r1 = new com.facebook.FacebookException("An error occurred while publishing install.", r0);
            com.tencent.matrix.trace.core.AppMethodBeat.o(71621);
     */
    /* JADX WARNING: Missing block: B:20:0x0095, code skipped:
            throw r1;
     */
    /* JADX WARNING: Missing block: B:21:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void publishInstallAndWaitForResponse(Context context, String str) {
        AppMethodBeat.i(71621);
        if (context == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
            AppMethodBeat.o(71621);
            throw illegalArgumentException;
        }
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
        String str2 = str + "ping";
        long j = sharedPreferences.getLong(str2, 0);
        JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(PUBLISH_ACTIVITY_PATH, new Object[]{str}), jSONObjectForGraphAPICall, null);
        if (j == 0) {
            newPostRequest.executeAndWait();
            Editor edit = sharedPreferences.edit();
            edit.putLong(str2, System.currentTimeMillis());
            edit.apply();
        }
        AppMethodBeat.o(71621);
    }

    public static String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    public static boolean getLimitEventAndDataUsage(Context context) {
        AppMethodBeat.i(71622);
        Validate.sdkInitialized();
        boolean z = context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
        AppMethodBeat.o(71622);
        return z;
    }

    public static void setLimitEventAndDataUsage(Context context, boolean z) {
        AppMethodBeat.i(71623);
        context.getSharedPreferences(AppEventsLogger.APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z).apply();
        AppMethodBeat.o(71623);
    }

    public static long getOnProgressThreshold() {
        AppMethodBeat.i(71624);
        Validate.sdkInitialized();
        long j = onProgressThreshold.get();
        AppMethodBeat.o(71624);
        return j;
    }

    public static void setOnProgressThreshold(long j) {
        AppMethodBeat.i(71625);
        onProgressThreshold.set(j);
        AppMethodBeat.o(71625);
    }

    static void loadDefaultsFromMetadata(Context context) {
        AppMethodBeat.i(71626);
        if (context == null) {
            AppMethodBeat.o(71626);
            return;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                AppMethodBeat.o(71626);
                return;
            }
            if (applicationId == null) {
                Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.toLowerCase(Locale.ROOT).startsWith("fb")) {
                        applicationId = str.substring(2);
                    } else {
                        applicationId = str;
                    }
                } else if (obj instanceof Integer) {
                    FacebookException facebookException = new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                    AppMethodBeat.o(71626);
                    throw facebookException;
                }
            }
            if (applicationName == null) {
                applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
            }
            if (appClientToken == null) {
                appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
            }
            if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
            }
            if (autoLogAppEventsEnabled == null) {
                autoLogAppEventsEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY, true));
            }
            if (codelessDebugLogEnabled == null) {
                codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
            }
            AppMethodBeat.o(71626);
        } catch (NameNotFoundException e) {
            AppMethodBeat.o(71626);
        }
    }

    public static String getApplicationSignature(Context context) {
        String str = null;
        AppMethodBeat.i(71627);
        Validate.sdkInitialized();
        if (context == null) {
            AppMethodBeat.o(71627);
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            AppMethodBeat.o(71627);
            return str;
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length == 0) {
                AppMethodBeat.o(71627);
                return str;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(packageInfo.signatures[0].toByteArray());
                str = Base64.encodeToString(instance.digest(), 9);
                AppMethodBeat.o(71627);
                return str;
            } catch (NoSuchAlgorithmException e) {
                AppMethodBeat.o(71627);
                return str;
            }
        } catch (NameNotFoundException e2) {
            AppMethodBeat.o(71627);
            return str;
        }
    }

    public static String getApplicationId() {
        AppMethodBeat.i(71628);
        Validate.sdkInitialized();
        String str = applicationId;
        AppMethodBeat.o(71628);
        return str;
    }

    public static void setApplicationId(String str) {
        applicationId = str;
    }

    public static String getApplicationName() {
        AppMethodBeat.i(71629);
        Validate.sdkInitialized();
        String str = applicationName;
        AppMethodBeat.o(71629);
        return str;
    }

    public static void setApplicationName(String str) {
        applicationName = str;
    }

    public static String getClientToken() {
        AppMethodBeat.i(71630);
        Validate.sdkInitialized();
        String str = appClientToken;
        AppMethodBeat.o(71630);
        return str;
    }

    public static void setClientToken(String str) {
        appClientToken = str;
    }

    public static boolean getAutoLogAppEventsEnabled() {
        AppMethodBeat.i(71631);
        Validate.sdkInitialized();
        boolean booleanValue = autoLogAppEventsEnabled.booleanValue();
        AppMethodBeat.o(71631);
        return booleanValue;
    }

    public static void setAutoLogAppEventsEnabled(boolean z) {
        AppMethodBeat.i(71632);
        autoLogAppEventsEnabled = Boolean.valueOf(z);
        AppMethodBeat.o(71632);
    }

    public static boolean getCodelessDebugLogEnabled() {
        AppMethodBeat.i(71633);
        Validate.sdkInitialized();
        boolean booleanValue = codelessDebugLogEnabled.booleanValue();
        AppMethodBeat.o(71633);
        return booleanValue;
    }

    public static void setCodelessDebugLogEnabled(boolean z) {
        AppMethodBeat.i(71634);
        codelessDebugLogEnabled = Boolean.valueOf(z);
        AppMethodBeat.o(71634);
    }

    public static File getCacheDir() {
        AppMethodBeat.i(71635);
        Validate.sdkInitialized();
        File file = (File) cacheDir.getValue();
        AppMethodBeat.o(71635);
        return file;
    }

    public static void setCacheDir(File file) {
        AppMethodBeat.i(71636);
        cacheDir = new LockOnGetVariable((Object) file);
        AppMethodBeat.o(71636);
    }

    public static int getCallbackRequestCodeOffset() {
        AppMethodBeat.i(71637);
        Validate.sdkInitialized();
        int i = callbackRequestCodeOffset;
        AppMethodBeat.o(71637);
        return i;
    }

    public static boolean isFacebookRequestCode(int i) {
        return i >= callbackRequestCodeOffset && i < callbackRequestCodeOffset + 100;
    }
}
