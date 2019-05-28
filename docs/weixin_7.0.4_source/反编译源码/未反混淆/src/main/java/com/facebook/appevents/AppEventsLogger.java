package com.facebook.appevents;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.webkit.WebView;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.Callback;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEventsLogger {
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final String APP_EVENT_NAME_PUSH_OPENED = "fb_mobile_push_opened";
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String APP_EVENT_PUSH_PARAMETER_ACTION = "fb_push_action";
    private static final String APP_EVENT_PUSH_PARAMETER_CAMPAIGN = "fb_push_campaign";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_APP_SESSION_INFO_IN_SECONDS = 30;
    private static final String PUSH_PAYLOAD_CAMPAIGN_KEY = "campaign";
    private static final String PUSH_PAYLOAD_KEY = "fb_push_payload";
    private static final String SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT = "_fbSourceApplicationHasBeenSet";
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    private static String anonymousAppDeviceGUID;
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private static FlushBehavior flushBehavior = FlushBehavior.AUTO;
    private static boolean isActivateAppEventRequested;
    private static boolean isOpenedByAppLink;
    private static String pushNotificationsRegistrationId;
    private static String sourceApplication;
    private static Object staticLock = new Object();
    private final AccessTokenAppIdPair accessTokenAppId;
    private final String contextName;

    /* renamed from: com.facebook.appevents.AppEventsLogger$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ AppEventsLogger val$logger;

        AnonymousClass3(AppEventsLogger appEventsLogger) {
            this.val$logger = appEventsLogger;
        }

        public final void run() {
            AppMethodBeat.i(71908);
            Bundle bundle = new Bundle();
            try {
                Class.forName("com.facebook.core.Core");
                bundle.putInt("core_lib_included", 1);
            } catch (ClassNotFoundException e) {
            }
            try {
                Class.forName("com.facebook.login.Login");
                bundle.putInt("login_lib_included", 1);
            } catch (ClassNotFoundException e2) {
            }
            try {
                Class.forName("com.facebook.share.Share");
                bundle.putInt("share_lib_included", 1);
            } catch (ClassNotFoundException e3) {
            }
            try {
                Class.forName("com.facebook.places.Places");
                bundle.putInt("places_lib_included", 1);
            } catch (ClassNotFoundException e4) {
            }
            try {
                Class.forName("com.facebook.messenger.Messenger");
                bundle.putInt("messenger_lib_included", 1);
            } catch (ClassNotFoundException e5) {
            }
            try {
                Class.forName("com.facebook.applinks.AppLinks");
                bundle.putInt("applinks_lib_included", 1);
            } catch (ClassNotFoundException e6) {
            }
            try {
                Class.forName("com.facebook.marketing.Marketing");
                bundle.putInt("marketing_lib_included", 1);
            } catch (ClassNotFoundException e7) {
            }
            try {
                Class.forName("com.facebook.all.All");
                bundle.putInt("all_lib_included", 1);
            } catch (ClassNotFoundException e8) {
            }
            try {
                Class.forName("com.android.billingclient.api.BillingClient");
                bundle.putInt("billing_client_lib_included", 1);
            } catch (ClassNotFoundException e9) {
            }
            try {
                Class.forName("com.android.vending.billing.IInAppBillingService");
                bundle.putInt("billing_service_lib_included", 1);
            } catch (ClassNotFoundException e10) {
            }
            this.val$logger.logSdkEvent(AnalyticsEvents.EVENT_SDK_INITIALIZE, null, bundle);
            AppMethodBeat.o(71908);
        }
    }

    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED;

        static {
            AppMethodBeat.o(71927);
        }
    }

    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY;

        static {
            AppMethodBeat.o(71913);
        }
    }

    static class PersistedAppSessionInfo {
        private static final String PERSISTED_SESSION_INFO_FILENAME = "AppEventsLogger.persistedsessioninfo";
        private static final Runnable appSessionInfoFlushRunnable = new Runnable() {
            public final void run() {
                AppMethodBeat.i(71914);
                PersistedAppSessionInfo.saveAppSessionInformation(FacebookSdk.getApplicationContext());
                AppMethodBeat.o(71914);
            }
        };
        private static Map<AccessTokenAppIdPair, FacebookTimeSpentData> appSessionInfoMap;
        private static boolean hasChanges = false;
        private static boolean isLoaded = false;
        private static final Object staticLock = new Object();

        PersistedAppSessionInfo() {
        }

        static {
            AppMethodBeat.i(71921);
            AppMethodBeat.o(71921);
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae A:{Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x006e, all -> 0x009e, all -> 0x0068 }} */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A:{Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x006e, all -> 0x009e, all -> 0x0068 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0090 A:{Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x006e, all -> 0x009e, all -> 0x0068 }} */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00ae A:{Catch:{ FileNotFoundException -> 0x004c, Exception -> 0x006e, all -> 0x009e, all -> 0x0068 }} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void restoreAppSessionInformation(Context context) {
            Exception exception;
            Object obj;
            Closeable closeable;
            Throwable th;
            AppMethodBeat.i(71915);
            Closeable closeable2 = null;
            synchronized (staticLock) {
                try {
                    if (!isLoaded) {
                        ObjectInputStream objectInputStream = new ObjectInputStream(context.openFileInput(PERSISTED_SESSION_INFO_FILENAME));
                        try {
                            appSessionInfoMap = (HashMap) objectInputStream.readObject();
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info loaded");
                            Utility.closeQuietly(objectInputStream);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                        } catch (FileNotFoundException e) {
                            Object closeable22 = objectInputStream;
                            Utility.closeQuietly(closeable22);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                            AppMethodBeat.o(71915);
                        } catch (Exception e2) {
                            exception = e2;
                            obj = objectInputStream;
                            try {
                                AppEventsLogger.TAG;
                                new StringBuilder("Got unexpected exception restoring app session info: ").append(exception.toString());
                                Utility.closeQuietly(closeable);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                    appSessionInfoMap = new HashMap();
                                }
                                isLoaded = true;
                                hasChanges = false;
                                AppMethodBeat.o(71915);
                            } catch (Throwable th2) {
                                th = th2;
                                Utility.closeQuietly(closeable);
                                context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                                if (appSessionInfoMap == null) {
                                }
                                isLoaded = true;
                                hasChanges = false;
                                AppMethodBeat.o(71915);
                                throw th;
                            }
                        } catch (Throwable th22) {
                            th = th22;
                            obj = objectInputStream;
                            Utility.closeQuietly(closeable);
                            context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                            if (appSessionInfoMap == null) {
                                appSessionInfoMap = new HashMap();
                            }
                            isLoaded = true;
                            hasChanges = false;
                            AppMethodBeat.o(71915);
                            throw th;
                        }
                    }
                } catch (FileNotFoundException e3) {
                    Utility.closeQuietly(closeable22);
                    context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                    if (appSessionInfoMap == null) {
                    }
                    isLoaded = true;
                    hasChanges = false;
                    AppMethodBeat.o(71915);
                } catch (Exception e4) {
                    exception = e4;
                    closeable = null;
                    AppEventsLogger.TAG;
                    new StringBuilder("Got unexpected exception restoring app session info: ").append(exception.toString());
                    Utility.closeQuietly(closeable);
                    context.deleteFile(PERSISTED_SESSION_INFO_FILENAME);
                    if (appSessionInfoMap == null) {
                    }
                    isLoaded = true;
                    hasChanges = false;
                    AppMethodBeat.o(71915);
                } catch (Throwable th3) {
                    AppMethodBeat.o(71915);
                }
            }
            AppMethodBeat.o(71915);
        }

        static void saveAppSessionInformation(Context context) {
            Exception e;
            Throwable th;
            AppMethodBeat.i(71916);
            synchronized (staticLock) {
                try {
                    if (hasChanges) {
                        Closeable objectOutputStream;
                        try {
                            objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(PERSISTED_SESSION_INFO_FILENAME, 0)));
                            try {
                                objectOutputStream.writeObject(appSessionInfoMap);
                                hasChanges = false;
                                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "App session info saved");
                                Utility.closeQuietly(objectOutputStream);
                            } catch (Exception e2) {
                                e = e2;
                                try {
                                    AppEventsLogger.TAG;
                                    new StringBuilder("Got unexpected exception while writing app session info: ").append(e.toString());
                                    Utility.closeQuietly(objectOutputStream);
                                } catch (Throwable th2) {
                                    th = th2;
                                    Utility.closeQuietly(objectOutputStream);
                                    AppMethodBeat.o(71916);
                                    throw th;
                                }
                            }
                        } catch (Exception e3) {
                            e = e3;
                            objectOutputStream = null;
                            AppEventsLogger.TAG;
                            new StringBuilder("Got unexpected exception while writing app session info: ").append(e.toString());
                            Utility.closeQuietly(objectOutputStream);
                        } catch (Throwable th3) {
                            th = th3;
                            objectOutputStream = null;
                            Utility.closeQuietly(objectOutputStream);
                            AppMethodBeat.o(71916);
                            throw th;
                        }
                    }
                } finally {
                    AppMethodBeat.o(71916);
                }
            }
        }

        static void onResume(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j, String str) {
            AppMethodBeat.i(71917);
            synchronized (staticLock) {
                try {
                    getTimeSpentData(context, accessTokenAppIdPair).onResume(appEventsLogger, j, str);
                    onTimeSpentDataUpdate();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(71917);
                }
            }
        }

        static void onSuspend(Context context, AccessTokenAppIdPair accessTokenAppIdPair, AppEventsLogger appEventsLogger, long j) {
            AppMethodBeat.i(71918);
            synchronized (staticLock) {
                try {
                    getTimeSpentData(context, accessTokenAppIdPair).onSuspend(appEventsLogger, j);
                    onTimeSpentDataUpdate();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(71918);
                }
            }
        }

        private static FacebookTimeSpentData getTimeSpentData(Context context, AccessTokenAppIdPair accessTokenAppIdPair) {
            AppMethodBeat.i(71919);
            restoreAppSessionInformation(context);
            FacebookTimeSpentData facebookTimeSpentData = (FacebookTimeSpentData) appSessionInfoMap.get(accessTokenAppIdPair);
            if (facebookTimeSpentData == null) {
                facebookTimeSpentData = new FacebookTimeSpentData();
                appSessionInfoMap.put(accessTokenAppIdPair, facebookTimeSpentData);
            }
            AppMethodBeat.o(71919);
            return facebookTimeSpentData;
        }

        private static void onTimeSpentDataUpdate() {
            AppMethodBeat.i(71920);
            if (!hasChanges) {
                hasChanges = true;
                AppEventsLogger.backgroundExecutor.schedule(appSessionInfoFlushRunnable, 30, TimeUnit.SECONDS);
            }
            AppMethodBeat.o(71920);
        }
    }

    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED;

        static {
            AppMethodBeat.o(71924);
        }
    }

    static /* synthetic */ void access$000(AppEventsLogger appEventsLogger, long j, String str) {
        AppMethodBeat.i(71981);
        appEventsLogger.logAppSessionResumeEvent(j, str);
        AppMethodBeat.o(71981);
    }

    static /* synthetic */ void access$100(AppEventsLogger appEventsLogger, long j) {
        AppMethodBeat.i(71982);
        appEventsLogger.logAppSessionSuspendEvent(j);
        AppMethodBeat.o(71982);
    }

    static {
        AppMethodBeat.i(71983);
        AppMethodBeat.o(71983);
    }

    public static void activateApp(Application application) {
        AppMethodBeat.i(71928);
        activateApp(application, null);
        AppMethodBeat.o(71928);
    }

    public static void activateApp(Application application, String str) {
        AppMethodBeat.i(71929);
        if (FacebookSdk.isInitialized()) {
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (str == null) {
                str = FacebookSdk.getApplicationId();
            }
            FacebookSdk.publishInstallAsync(application, str);
            ActivityLifecycleTracker.startTracking(application, str);
            AppMethodBeat.o(71929);
            return;
        }
        FacebookException facebookException = new FacebookException("The Facebook sdk must be initialized before calling activateApp");
        AppMethodBeat.o(71929);
        throw facebookException;
    }

    @Deprecated
    public static void activateApp(Context context) {
        AppMethodBeat.i(71930);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(71930);
            return;
        }
        FacebookSdk.sdkInitialize(context);
        activateApp(context, Utility.getMetadataApplicationId(context));
        AppMethodBeat.o(71930);
    }

    @Deprecated
    public static void activateApp(Context context, String str) {
        AppMethodBeat.i(71931);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(71931);
        } else if (context == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
            AppMethodBeat.o(71931);
            throw illegalArgumentException;
        } else {
            AnalyticsUserIDStore.initStore();
            UserDataStore.initStore();
            if (context instanceof Activity) {
                setSourceApplication((Activity) context);
            } else {
                resetSourceApplication();
                Utility.logd(AppEventsLogger.class.getName(), "To set source application the context of activateApp must be an instance of Activity");
            }
            FacebookSdk.publishInstallAsync(context, str);
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, null);
            final long currentTimeMillis = System.currentTimeMillis();
            final String sourceApplication = getSourceApplication();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                public final void run() {
                    AppMethodBeat.i(71906);
                    AppEventsLogger.access$000(this.val$logger, currentTimeMillis, sourceApplication);
                    AppMethodBeat.o(71906);
                }
            });
            AppMethodBeat.o(71931);
        }
    }

    @Deprecated
    public static void deactivateApp(Context context) {
        AppMethodBeat.i(71932);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(71932);
            return;
        }
        deactivateApp(context, Utility.getMetadataApplicationId(context));
        AppMethodBeat.o(71932);
    }

    @Deprecated
    public static void deactivateApp(Context context, String str) {
        AppMethodBeat.i(71933);
        if (ActivityLifecycleTracker.isTracking()) {
            AppMethodBeat.o(71933);
        } else if (context == null || str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Both context and applicationId must be non-null");
            AppMethodBeat.o(71933);
            throw illegalArgumentException;
        } else {
            resetSourceApplication();
            AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, null);
            final long currentTimeMillis = System.currentTimeMillis();
            backgroundExecutor.execute(new Runnable(appEventsLogger) {
                final /* synthetic */ AppEventsLogger val$logger;

                public final void run() {
                    AppMethodBeat.i(71907);
                    AppEventsLogger.access$100(this.val$logger, currentTimeMillis);
                    AppMethodBeat.o(71907);
                }
            });
            AppMethodBeat.o(71933);
        }
    }

    private void logAppSessionResumeEvent(long j, String str) {
        AppMethodBeat.i(71934);
        PersistedAppSessionInfo.onResume(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j, str);
        AppMethodBeat.o(71934);
    }

    private void logAppSessionSuspendEvent(long j) {
        AppMethodBeat.i(71935);
        PersistedAppSessionInfo.onSuspend(FacebookSdk.getApplicationContext(), this.accessTokenAppId, this, j);
        AppMethodBeat.o(71935);
    }

    public static void initializeLib(Context context, String str) {
        AppMethodBeat.i(71936);
        if (FacebookSdk.getAutoLogAppEventsEnabled()) {
            backgroundExecutor.execute(new AnonymousClass3(new AppEventsLogger(context, str, null)));
            AppMethodBeat.o(71936);
            return;
        }
        AppMethodBeat.o(71936);
    }

    public static AppEventsLogger newLogger(Context context) {
        AppMethodBeat.i(71937);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, null, null);
        AppMethodBeat.o(71937);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, AccessToken accessToken) {
        AppMethodBeat.i(71938);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, null, accessToken);
        AppMethodBeat.o(71938);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, String str, AccessToken accessToken) {
        AppMethodBeat.i(71939);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, accessToken);
        AppMethodBeat.o(71939);
        return appEventsLogger;
    }

    public static AppEventsLogger newLogger(Context context, String str) {
        AppMethodBeat.i(71940);
        AppEventsLogger appEventsLogger = new AppEventsLogger(context, str, null);
        AppMethodBeat.o(71940);
        return appEventsLogger;
    }

    public static FlushBehavior getFlushBehavior() {
        FlushBehavior flushBehavior;
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
        return flushBehavior;
    }

    public static void setFlushBehavior(FlushBehavior flushBehavior) {
        synchronized (staticLock) {
            flushBehavior = flushBehavior;
        }
    }

    public void logEvent(String str) {
        AppMethodBeat.i(71941);
        logEvent(str, null);
        AppMethodBeat.o(71941);
    }

    public void logEvent(String str, double d) {
        AppMethodBeat.i(71942);
        logEvent(str, d, null);
        AppMethodBeat.o(71942);
    }

    public void logEvent(String str, Bundle bundle) {
        AppMethodBeat.i(71943);
        logEvent(str, null, bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(71943);
    }

    public void logEvent(String str, double d, Bundle bundle) {
        AppMethodBeat.i(71944);
        logEvent(str, Double.valueOf(d), bundle, false, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(71944);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency) {
        AppMethodBeat.i(71945);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, null, false);
        AppMethodBeat.o(71945);
    }

    public void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(71946);
        AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled();
        logPurchase(bigDecimal, currency, bundle, false);
        AppMethodBeat.o(71946);
    }

    @Deprecated
    public void logPurchaseImplicitly(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(71947);
        String str = "Function logPurchaseImplicitly() is deprecated and your purchase events cannot be logged with this function. ";
        if (AutomaticAnalyticsLogger.isImplicitPurchaseLoggingEnabled()) {
            new StringBuilder().append(str).append("Auto-logging of in-app purchase has been enabled in the SDK, so you don't have to manually log purchases");
            AppMethodBeat.o(71947);
            return;
        }
        new StringBuilder().append(str).append("Please use logPurchase() function instead.");
        AppMethodBeat.o(71947);
    }

    /* Access modifiers changed, original: protected */
    public void logPurchaseImplicitlyInternal(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(71948);
        logPurchase(bigDecimal, currency, bundle, true);
        AppMethodBeat.o(71948);
    }

    private void logPurchase(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        AppMethodBeat.i(71949);
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            AppMethodBeat.o(71949);
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            AppMethodBeat.o(71949);
        } else {
            Bundle bundle2;
            if (bundle == null) {
                bundle2 = new Bundle();
            } else {
                bundle2 = bundle;
            }
            bundle2.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, currency.getCurrencyCode());
            logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.getCurrentSessionGuid());
            eagerFlush();
            AppMethodBeat.o(71949);
        }
    }

    public void logPushNotificationOpen(Bundle bundle) {
        AppMethodBeat.i(71950);
        logPushNotificationOpen(bundle, null);
        AppMethodBeat.o(71950);
    }

    public void logPushNotificationOpen(Bundle bundle, String str) {
        AppMethodBeat.i(71951);
        String str2 = null;
        try {
            String string = bundle.getString(PUSH_PAYLOAD_KEY);
            if (Utility.isNullOrEmpty(string)) {
                AppMethodBeat.o(71951);
                return;
            }
            str2 = new JSONObject(string).getString("campaign");
            if (str2 == null) {
                Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Malformed payload specified for logging a push notification open.");
                AppMethodBeat.o(71951);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(APP_EVENT_PUSH_PARAMETER_CAMPAIGN, str2);
            if (str != null) {
                bundle2.putString(APP_EVENT_PUSH_PARAMETER_ACTION, str);
            }
            logEvent(APP_EVENT_NAME_PUSH_OPENED, bundle2);
            AppMethodBeat.o(71951);
        } catch (JSONException e) {
        }
    }

    public void logProductItem(String str, ProductAvailability productAvailability, ProductCondition productCondition, String str2, String str3, String str4, String str5, BigDecimal bigDecimal, Currency currency, String str6, String str7, String str8, Bundle bundle) {
        AppMethodBeat.i(71952);
        if (str == null) {
            notifyDeveloperError("itemID cannot be null");
            AppMethodBeat.o(71952);
        } else if (productAvailability == null) {
            notifyDeveloperError("availability cannot be null");
            AppMethodBeat.o(71952);
        } else if (productCondition == null) {
            notifyDeveloperError("condition cannot be null");
            AppMethodBeat.o(71952);
        } else if (str2 == null) {
            notifyDeveloperError("description cannot be null");
            AppMethodBeat.o(71952);
        } else if (str3 == null) {
            notifyDeveloperError("imageLink cannot be null");
            AppMethodBeat.o(71952);
        } else if (str4 == null) {
            notifyDeveloperError("link cannot be null");
            AppMethodBeat.o(71952);
        } else if (str5 == null) {
            notifyDeveloperError("title cannot be null");
            AppMethodBeat.o(71952);
        } else if (bigDecimal == null) {
            notifyDeveloperError("priceAmount cannot be null");
            AppMethodBeat.o(71952);
        } else if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            AppMethodBeat.o(71952);
        } else if (str6 == null && str7 == null && str8 == null) {
            notifyDeveloperError("Either gtin, mpn or brand is required");
            AppMethodBeat.o(71952);
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_ITEM_ID, str);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_AVAILABILITY, productAvailability.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_CONDITION, productCondition.name());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_DESCRIPTION, str2);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_IMAGE_LINK, str3);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_LINK, str4);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_TITLE, str5);
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_AMOUNT, bigDecimal.setScale(3, 4).toString());
            bundle.putString(Constants.EVENT_PARAM_PRODUCT_PRICE_CURRENCY, currency.getCurrencyCode());
            if (str6 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_GTIN, str6);
            }
            if (str7 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_MPN, str7);
            }
            if (str8 != null) {
                bundle.putString(Constants.EVENT_PARAM_PRODUCT_BRAND, str8);
            }
            logEvent(AppEventsConstants.EVENT_NAME_PRODUCT_CATALOG_UPDATE, bundle);
            eagerFlush();
            AppMethodBeat.o(71952);
        }
    }

    public void flush() {
        AppMethodBeat.i(71953);
        AppEventQueue.flush(FlushReason.EXPLICIT);
        AppMethodBeat.o(71953);
    }

    public static void onContextStop() {
        AppMethodBeat.i(71954);
        AppEventQueue.persistToDisk();
        AppMethodBeat.o(71954);
    }

    public boolean isValidForAccessToken(AccessToken accessToken) {
        AppMethodBeat.i(71955);
        boolean equals = this.accessTokenAppId.equals(new AccessTokenAppIdPair(accessToken));
        AppMethodBeat.o(71955);
        return equals;
    }

    public static void setPushNotificationsRegistrationId(String str) {
        AppMethodBeat.i(71956);
        synchronized (staticLock) {
            try {
                if (!Utility.stringsEqualOrEmpty(pushNotificationsRegistrationId, str)) {
                    pushNotificationsRegistrationId = str;
                    AppEventsLogger newLogger = newLogger(FacebookSdk.getApplicationContext());
                    newLogger.logEvent(AppEventsConstants.EVENT_NAME_PUSH_TOKEN_OBTAINED);
                    if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        newLogger.flush();
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71956);
            }
        }
    }

    static String getPushNotificationsRegistrationId() {
        String str;
        synchronized (staticLock) {
            str = pushNotificationsRegistrationId;
        }
        return str;
    }

    public static void augmentWebView(WebView webView, Context context) {
        int i = 0;
        AppMethodBeat.i(71957);
        String[] split = VERSION.RELEASE.split("\\.");
        int parseInt = split.length > 0 ? Integer.parseInt(split[0]) : 0;
        if (split.length > 1) {
            i = Integer.parseInt(split[1]);
        }
        if (VERSION.SDK_INT < 17 || parseInt < 4 || (parseInt == 4 && i <= 1)) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "augmentWebView is only available for Android SDK version >= 17 on devices running Android >= 4.2");
            AppMethodBeat.o(71957);
            return;
        }
        webView.addJavascriptInterface(new FacebookSDKJSInterface(context), "fbmq_" + FacebookSdk.getApplicationId());
        AppMethodBeat.o(71957);
    }

    public static void setUserID(String str) {
        AppMethodBeat.i(71958);
        AnalyticsUserIDStore.setUserID(str);
        AppMethodBeat.o(71958);
    }

    public static String getUserID() {
        AppMethodBeat.i(71959);
        String userID = AnalyticsUserIDStore.getUserID();
        AppMethodBeat.o(71959);
        return userID;
    }

    public static void clearUserID() {
        AppMethodBeat.i(71960);
        AnalyticsUserIDStore.setUserID(null);
        AppMethodBeat.o(71960);
    }

    @Deprecated
    public static void setUserData(Bundle bundle) {
        AppMethodBeat.i(71961);
        UserDataStore.setUserDataAndHash(bundle);
        AppMethodBeat.o(71961);
    }

    public static void setUserData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        AppMethodBeat.i(71962);
        UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        AppMethodBeat.o(71962);
    }

    public static String getUserData() {
        AppMethodBeat.i(71963);
        String hashedUserData = UserDataStore.getHashedUserData();
        AppMethodBeat.o(71963);
        return hashedUserData;
    }

    public static void clearUserData() {
        AppMethodBeat.i(71964);
        UserDataStore.setUserDataAndHash(null);
        AppMethodBeat.o(71964);
    }

    public static void updateUserProperties(Bundle bundle, Callback callback) {
        AppMethodBeat.i(71965);
        updateUserProperties(bundle, FacebookSdk.getApplicationId(), callback);
        AppMethodBeat.o(71965);
    }

    public static void updateUserProperties(final Bundle bundle, final String str, final Callback callback) {
        AppMethodBeat.i(71966);
        getAnalyticsExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(71909);
                String userID = AppEventsLogger.getUserID();
                if (userID == null || userID.isEmpty()) {
                    Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "AppEventsLogger userID cannot be null or empty");
                    AppMethodBeat.o(71909);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("user_unique_id", userID);
                bundle.putBundle("custom_data", bundle);
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
                    bundle.putString("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
                }
                Bundle bundle2 = new Bundle();
                try {
                    JSONObject convertToJSON = BundleJSONConverter.convertToJSON(bundle);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(convertToJSON);
                    bundle2.putString("data", jSONArray.toString());
                    GraphRequest graphRequest = new GraphRequest(AccessToken.getCurrentAccessToken(), String.format(Locale.US, "%s/user_properties", new Object[]{str}), bundle2, HttpMethod.POST, callback);
                    graphRequest.setSkipClientToken(true);
                    graphRequest.executeAsync();
                    AppMethodBeat.o(71909);
                } catch (JSONException e) {
                    FacebookException facebookException = new FacebookException("Failed to construct request", e);
                    AppMethodBeat.o(71909);
                    throw facebookException;
                }
            }
        });
        AppMethodBeat.o(71966);
    }

    public void logSdkEvent(String str, Double d, Bundle bundle) {
        AppMethodBeat.i(71967);
        logEvent(str, d, bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(71967);
    }

    public String getApplicationId() {
        AppMethodBeat.i(71968);
        String applicationId = this.accessTokenAppId.getApplicationId();
        AppMethodBeat.o(71968);
        return applicationId;
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this(Utility.getActivityName(context), str, accessToken);
        AppMethodBeat.i(71969);
        AppMethodBeat.o(71969);
    }

    protected AppEventsLogger(String str, String str2, AccessToken accessToken) {
        AppMethodBeat.i(71970);
        Validate.sdkInitialized();
        this.contextName = str;
        if (accessToken == null) {
            accessToken = AccessToken.getCurrentAccessToken();
        }
        if (AccessToken.isCurrentAccessTokenActive() && (str2 == null || str2.equals(accessToken.getApplicationId()))) {
            this.accessTokenAppId = new AccessTokenAppIdPair(accessToken);
        } else {
            if (str2 == null) {
                str2 = Utility.getMetadataApplicationId(FacebookSdk.getApplicationContext());
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(null, str2);
        }
        initializeTimersIfNeeded();
        AppMethodBeat.o(71970);
    }

    private static void initializeTimersIfNeeded() {
        AppMethodBeat.i(71971);
        synchronized (staticLock) {
            try {
                if (backgroundExecutor != null) {
                } else {
                    backgroundExecutor = new ScheduledThreadPoolExecutor(1);
                    backgroundExecutor.scheduleAtFixedRate(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(71910);
                            HashSet<String> hashSet = new HashSet();
                            for (AccessTokenAppIdPair applicationId : AppEventQueue.getKeySet()) {
                                hashSet.add(applicationId.getApplicationId());
                            }
                            for (String queryAppSettings : hashSet) {
                                FetchedAppSettingsManager.queryAppSettings(queryAppSettings, true);
                            }
                            AppMethodBeat.o(71910);
                        }
                    }, 0, TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC, TimeUnit.SECONDS);
                    AppMethodBeat.o(71971);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(71971);
            }
        }
    }

    /* Access modifiers changed, original: protected */
    public void logEventImplicitly(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        AppMethodBeat.i(71972);
        logEvent(str, Double.valueOf(bigDecimal.doubleValue()), bundle, true, ActivityLifecycleTracker.getCurrentSessionGuid());
        AppMethodBeat.o(71972);
    }

    private void logEvent(String str, Double d, Bundle bundle, boolean z, UUID uuid) {
        AppMethodBeat.i(71973);
        try {
            logEvent(new AppEvent(this.contextName, str, d, bundle, z, uuid), this.accessTokenAppId);
            AppMethodBeat.o(71973);
        } catch (JSONException e) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e.toString());
            AppMethodBeat.o(71973);
        } catch (FacebookException e2) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e2.toString());
            AppMethodBeat.o(71973);
        }
    }

    private static void logEvent(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        AppMethodBeat.i(71974);
        AppEventQueue.add(accessTokenAppIdPair, appEvent);
        if (!(appEvent.getIsImplicit() || isActivateAppEventRequested)) {
            if (appEvent.getName().equals(AppEventsConstants.EVENT_NAME_ACTIVATED_APP)) {
                isActivateAppEventRequested = true;
                AppMethodBeat.o(71974);
                return;
            }
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
        }
        AppMethodBeat.o(71974);
    }

    static void eagerFlush() {
        AppMethodBeat.i(71975);
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
        AppMethodBeat.o(71975);
    }

    private static void notifyDeveloperError(String str) {
        AppMethodBeat.i(71976);
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
        AppMethodBeat.o(71976);
    }

    private static void setSourceApplication(Activity activity) {
        AppMethodBeat.i(71977);
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            String packageName = callingActivity.getPackageName();
            if (packageName.equals(activity.getPackageName())) {
                resetSourceApplication();
                AppMethodBeat.o(71977);
                return;
            }
            sourceApplication = packageName;
        }
        Intent intent = activity.getIntent();
        if (intent == null || intent.getBooleanExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, false)) {
            resetSourceApplication();
            AppMethodBeat.o(71977);
            return;
        }
        Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        if (bundleExtra == null) {
            resetSourceApplication();
            AppMethodBeat.o(71977);
            return;
        }
        isOpenedByAppLink = true;
        bundleExtra = bundleExtra.getBundle("referer_app_link");
        if (bundleExtra == null) {
            sourceApplication = null;
            AppMethodBeat.o(71977);
            return;
        }
        sourceApplication = bundleExtra.getString("package");
        intent.putExtra(SOURCE_APPLICATION_HAS_BEEN_SET_BY_THIS_INTENT, true);
        AppMethodBeat.o(71977);
    }

    static void setSourceApplication(String str, boolean z) {
        sourceApplication = str;
        isOpenedByAppLink = z;
    }

    static String getSourceApplication() {
        AppMethodBeat.i(71978);
        String str = "Unclassified";
        if (isOpenedByAppLink) {
            str = "Applink";
        }
        if (sourceApplication != null) {
            str = str + "(" + sourceApplication + ")";
            AppMethodBeat.o(71978);
            return str;
        }
        AppMethodBeat.o(71978);
        return str;
    }

    static void resetSourceApplication() {
        sourceApplication = null;
        isOpenedByAppLink = false;
    }

    static Executor getAnalyticsExecutor() {
        AppMethodBeat.i(71979);
        if (backgroundExecutor == null) {
            initializeTimersIfNeeded();
        }
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = backgroundExecutor;
        AppMethodBeat.o(71979);
        return scheduledThreadPoolExecutor;
    }

    public static String getAnonymousAppDeviceGUID(Context context) {
        String string;
        AppMethodBeat.i(71980);
        if (anonymousAppDeviceGUID == null) {
            synchronized (staticLock) {
                try {
                    if (anonymousAppDeviceGUID == null) {
                        string = context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getString("anonymousAppDeviceGUID", null);
                        anonymousAppDeviceGUID = string;
                        if (string == null) {
                            anonymousAppDeviceGUID = "XZ" + UUID.randomUUID().toString();
                            context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putString("anonymousAppDeviceGUID", anonymousAppDeviceGUID).apply();
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(71980);
                    }
                }
            }
        }
        string = anonymousAppDeviceGUID;
        AppMethodBeat.o(71980);
        return string;
    }
}
