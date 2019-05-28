package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessMatcher;
import com.facebook.appevents.codeless.ViewIndexer;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.codeless.ViewIndexingTrigger.OnShakeListener;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.internal.SourceApplicationInfo.Factory;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityLifecycleTracker {
    private static final String INCORRECT_IMPL_WARNING = "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method";
    private static final long INTERRUPTION_THRESHOLD_MILLISECONDS = 1000;
    private static final String TAG = ActivityLifecycleTracker.class.getCanonicalName();
    private static String appId;
    private static final CodelessMatcher codelessMatcher = new CodelessMatcher();
    private static long currentActivityAppearTime;
    private static volatile ScheduledFuture currentFuture;
    private static final Object currentFutureLock = new Object();
    private static volatile SessionInfo currentSession;
    private static String deviceSessionID = null;
    private static AtomicInteger foregroundActivityCount = new AtomicInteger(0);
    private static Boolean isAppIndexingEnabled = Boolean.FALSE;
    private static volatile Boolean isCheckingSession = Boolean.FALSE;
    private static SensorManager sensorManager;
    private static final ScheduledExecutorService singleThreadExecutor = Executors.newSingleThreadScheduledExecutor();
    private static AtomicBoolean tracking = new AtomicBoolean(false);
    private static ViewIndexer viewIndexer;
    private static final ViewIndexingTrigger viewIndexingTrigger = new ViewIndexingTrigger();

    static /* synthetic */ void access$100(Activity activity) {
        AppMethodBeat.i(72157);
        onActivityPaused(activity);
        AppMethodBeat.o(72157);
    }

    static /* synthetic */ int access$400() {
        AppMethodBeat.i(72158);
        int sessionTimeoutInSeconds = getSessionTimeoutInSeconds();
        AppMethodBeat.o(72158);
        return sessionTimeoutInSeconds;
    }

    static {
        AppMethodBeat.i(72159);
        AppMethodBeat.o(72159);
    }

    public static void startTracking(Application application, String str) {
        AppMethodBeat.i(72146);
        if (tracking.compareAndSet(false, true)) {
            appId = str;
            application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
                public final void onActivityCreated(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(72133);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityCreated(activity);
                    AppMethodBeat.o(72133);
                }

                public final void onActivityStarted(Activity activity) {
                    AppMethodBeat.i(72134);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
                    AppMethodBeat.o(72134);
                }

                public final void onActivityResumed(Activity activity) {
                    AppMethodBeat.i(72135);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.onActivityResumed(activity);
                    AppMethodBeat.o(72135);
                }

                public final void onActivityPaused(Activity activity) {
                    AppMethodBeat.i(72136);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
                    AppEventUtility.assertIsMainThread();
                    ActivityLifecycleTracker.access$100(activity);
                    AppMethodBeat.o(72136);
                }

                public final void onActivityStopped(Activity activity) {
                    AppMethodBeat.i(72137);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
                    AppEventsLogger.onContextStop();
                    AppMethodBeat.o(72137);
                }

                public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    AppMethodBeat.i(72138);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
                    AppMethodBeat.o(72138);
                }

                public final void onActivityDestroyed(Activity activity) {
                    AppMethodBeat.i(72139);
                    Logger.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
                    AppMethodBeat.o(72139);
                }
            });
            AppMethodBeat.o(72146);
            return;
        }
        AppMethodBeat.o(72146);
    }

    public static boolean isTracking() {
        AppMethodBeat.i(72147);
        boolean z = tracking.get();
        AppMethodBeat.o(72147);
        return z;
    }

    public static UUID getCurrentSessionGuid() {
        AppMethodBeat.i(72148);
        if (currentSession != null) {
            UUID sessionId = currentSession.getSessionId();
            AppMethodBeat.o(72148);
            return sessionId;
        }
        AppMethodBeat.o(72148);
        return null;
    }

    public static void onActivityCreated(Activity activity) {
        AppMethodBeat.i(72149);
        System.currentTimeMillis();
        activity.getApplicationContext();
        Utility.getActivityName(activity);
        Factory.create(activity);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72140);
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = SessionInfo.getStoredSessionInfo();
                }
                AppMethodBeat.o(72140);
            }
        });
        AppMethodBeat.o(72149);
    }

    public static void onActivityResumed(Activity activity) {
        AppMethodBeat.i(72150);
        foregroundActivityCount.incrementAndGet();
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        currentActivityAppearTime = currentTimeMillis;
        final String activityName = Utility.getActivityName(activity);
        codelessMatcher.add(activity);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72141);
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId);
                } else if (ActivityLifecycleTracker.currentSession.getSessionLastEventTime() != null) {
                    long longValue = currentTimeMillis - ActivityLifecycleTracker.currentSession.getSessionLastEventTime().longValue();
                    if (longValue > ((long) (ActivityLifecycleTracker.access$400() * 1000))) {
                        SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                        SessionLogger.logActivateApp(activityName, null, ActivityLifecycleTracker.appId);
                        ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > 1000) {
                        ActivityLifecycleTracker.currentSession.incrementInterruptionCount();
                    }
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                AppMethodBeat.o(72141);
            }
        });
        Context applicationContext = activity.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        final FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(applicationId);
        if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessSetupEnabled()) {
            SensorManager sensorManager = (SensorManager) applicationContext.getSystemService("sensor");
            sensorManager = sensorManager;
            if (sensorManager == null) {
                AppMethodBeat.o(72150);
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            viewIndexer = new ViewIndexer(activity);
            viewIndexingTrigger.setOnShakeListener(new OnShakeListener() {
                public final void onShake() {
                    AppMethodBeat.i(72142);
                    if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                        ActivityLifecycleTracker.checkCodelessSession(applicationId);
                    }
                    AppMethodBeat.o(72142);
                }
            });
            sensorManager.registerListener(viewIndexingTrigger, defaultSensor, 2);
            if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                viewIndexer.schedule();
            }
        }
        AppMethodBeat.o(72150);
    }

    private static void onActivityPaused(Activity activity) {
        AppMethodBeat.i(72151);
        if (foregroundActivityCount.decrementAndGet() < 0) {
            foregroundActivityCount.set(0);
        }
        cancelCurrentTask();
        final long currentTimeMillis = System.currentTimeMillis();
        final String activityName = Utility.getActivityName(activity);
        codelessMatcher.remove(activity);
        singleThreadExecutor.execute(new Runnable() {
            public final void run() {
                long j = 0;
                AppMethodBeat.i(72144);
                if (ActivityLifecycleTracker.currentSession == null) {
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                }
                ActivityLifecycleTracker.currentSession.setSessionLastEventTime(Long.valueOf(currentTimeMillis));
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    AnonymousClass1 anonymousClass1 = new Runnable() {
                        public void run() {
                            AppMethodBeat.i(72143);
                            if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                                SessionLogger.logDeactivateApp(activityName, ActivityLifecycleTracker.currentSession, ActivityLifecycleTracker.appId);
                                SessionInfo.clearSavedSessionFromDisk();
                                ActivityLifecycleTracker.currentSession = null;
                            }
                            synchronized (ActivityLifecycleTracker.currentFutureLock) {
                                try {
                                    ActivityLifecycleTracker.currentFuture = null;
                                } finally {
                                    while (true) {
                                    }
                                    AppMethodBeat.o(72143);
                                }
                            }
                        }
                    };
                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                        try {
                            ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(anonymousClass1, (long) ActivityLifecycleTracker.access$400(), TimeUnit.SECONDS);
                        } catch (Throwable th) {
                            while (true) {
                                AppMethodBeat.o(72144);
                            }
                        }
                    }
                }
                long access$900 = ActivityLifecycleTracker.currentActivityAppearTime;
                if (access$900 > 0) {
                    j = (currentTimeMillis - access$900) / 1000;
                }
                AutomaticAnalyticsLogger.logActivityTimeSpentEvent(activityName, j);
                ActivityLifecycleTracker.currentSession.writeSessionToDisk();
                AppMethodBeat.o(72144);
            }
        });
        if (viewIndexer != null) {
            viewIndexer.unschedule();
        }
        if (sensorManager != null) {
            sensorManager.unregisterListener(viewIndexingTrigger);
        }
        AppMethodBeat.o(72151);
    }

    private static int getSessionTimeoutInSeconds() {
        AppMethodBeat.i(72152);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        int defaultAppEventsSessionTimeoutInSeconds;
        if (appSettingsWithoutQuery == null) {
            defaultAppEventsSessionTimeoutInSeconds = Constants.getDefaultAppEventsSessionTimeoutInSeconds();
            AppMethodBeat.o(72152);
            return defaultAppEventsSessionTimeoutInSeconds;
        }
        defaultAppEventsSessionTimeoutInSeconds = appSettingsWithoutQuery.getSessionTimeoutInSeconds();
        AppMethodBeat.o(72152);
        return defaultAppEventsSessionTimeoutInSeconds;
    }

    private static void cancelCurrentTask() {
        AppMethodBeat.i(72153);
        synchronized (currentFutureLock) {
            try {
                if (currentFuture != null) {
                    currentFuture.cancel(false);
                }
                currentFuture = null;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72153);
            }
        }
    }

    public static void checkCodelessSession(final String str) {
        AppMethodBeat.i(72154);
        if (isCheckingSession.booleanValue()) {
            AppMethodBeat.o(72154);
            return;
        }
        isCheckingSession = Boolean.TRUE;
        FacebookSdk.getExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(72145);
                GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_indexing_session", new Object[]{str}), null, null);
                Bundle parameters = newPostRequest.getParameters();
                if (parameters == null) {
                    parameters = new Bundle();
                }
                AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                if (attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null) {
                    jSONArray.put("");
                } else {
                    jSONArray.put(attributionIdentifiers.getAndroidAdvertiserId());
                }
                jSONArray.put(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                jSONArray.put(AppEventUtility.isEmulator() ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                Locale currentLocale = Utility.getCurrentLocale();
                jSONArray.put(currentLocale.getLanguage() + "_" + currentLocale.getCountry());
                String jSONArray2 = jSONArray.toString();
                parameters.putString(Constants.DEVICE_SESSION_ID, ActivityLifecycleTracker.getCurrentDeviceSessionID());
                parameters.putString(Constants.EXTINFO, jSONArray2);
                newPostRequest.setParameters(parameters);
                if (newPostRequest != null) {
                    JSONObject jSONObject = newPostRequest.executeAndWait().getJSONObject();
                    boolean z = jSONObject != null && jSONObject.optBoolean(Constants.APP_INDEXING_ENABLED, false);
                    ActivityLifecycleTracker.isAppIndexingEnabled = Boolean.valueOf(z);
                    if (ActivityLifecycleTracker.isAppIndexingEnabled.booleanValue()) {
                        ActivityLifecycleTracker.viewIndexer.schedule();
                    } else {
                        ActivityLifecycleTracker.deviceSessionID = null;
                    }
                }
                ActivityLifecycleTracker.isCheckingSession = Boolean.FALSE;
                AppMethodBeat.o(72145);
            }
        });
        AppMethodBeat.o(72154);
    }

    public static String getCurrentDeviceSessionID() {
        AppMethodBeat.i(72155);
        if (deviceSessionID == null) {
            deviceSessionID = UUID.randomUUID().toString();
        }
        String str = deviceSessionID;
        AppMethodBeat.o(72155);
        return str;
    }

    public static boolean getIsAppIndexingEnabled() {
        AppMethodBeat.i(72156);
        boolean booleanValue = isAppIndexingEnabled.booleanValue();
        AppMethodBeat.o(72156);
        return booleanValue;
    }

    public static void updateAppIndexing(Boolean bool) {
        isAppIndexingEnabled = bool;
    }
}
