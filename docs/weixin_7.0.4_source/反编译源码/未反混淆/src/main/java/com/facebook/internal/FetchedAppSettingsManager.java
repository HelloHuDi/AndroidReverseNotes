package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.facebook.internal.FetchedAppSettings.DialogFeatureConfig;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class FetchedAppSettingsManager {
    private static final String ADVERTISER_ID_KEY = "advertiser_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APP_SETTINGS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_SETTINGS.%s";
    private static final String APP_SETTINGS_PREFS_STORE = "com.facebook.internal.preferences.APP_SETTINGS";
    private static final String APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES = "android_sdk_error_categories";
    private static final String APP_SETTING_APP_EVENTS_CODELESS_SETUP_ENABLED = "auto_event_setup_enabled";
    private static final String APP_SETTING_APP_EVENTS_EVENT_BINDINGS = "auto_event_mapping_android";
    private static final String APP_SETTING_APP_EVENTS_FEATURE_BITMASK = "app_events_feature_bitmask";
    private static final String APP_SETTING_APP_EVENTS_SESSION_TIMEOUT = "app_events_session_timeout";
    private static final String APP_SETTING_CUSTOM_TABS_ENABLED = "gdpv4_chrome_custom_tabs_enabled";
    private static final String APP_SETTING_DIALOG_CONFIGS = "android_dialog_configs";
    private static final String[] APP_SETTING_FIELDS = new String[]{APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, APP_SETTING_NUX_CONTENT, APP_SETTING_NUX_ENABLED, APP_SETTING_CUSTOM_TABS_ENABLED, APP_SETTING_DIALOG_CONFIGS, APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES, APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, APP_SETTING_APP_EVENTS_FEATURE_BITMASK, APP_SETTING_APP_EVENTS_EVENT_BINDINGS, APP_SETTING_APP_EVENTS_CODELESS_SETUP_ENABLED, APP_SETTING_SMART_LOGIN_OPTIONS, SMART_LOGIN_BOOKMARK_ICON_URL, SMART_LOGIN_MENU_ICON_URL};
    private static final String APP_SETTING_NUX_CONTENT = "gdpv4_nux_content";
    private static final String APP_SETTING_NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String APP_SETTING_SMART_LOGIN_OPTIONS = "seamless_login";
    private static final String APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final int AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 8;
    private static final int CODELESS_EVENTS_ENABLED_BITMASK_FIELD = 32;
    private static final int IAP_AUTOMATIC_LOGGING_ENABLED_BITMASK_FIELD = 16;
    private static final String SDK_UPDATE_MESSAGE = "sdk_update_message";
    private static final String SMART_LOGIN_BOOKMARK_ICON_URL = "smart_login_bookmark_icon_url";
    private static final String SMART_LOGIN_MENU_ICON_URL = "smart_login_menu_icon_url";
    private static final String TAG = FetchedAppSettingsManager.class.getSimpleName();
    private static final int TRACK_UNINSTALL_ENABLED_BITMASK_FIELD = 256;
    private static final Map<String, FetchedAppSettings> fetchedAppSettings = new ConcurrentHashMap();
    private static final ConcurrentLinkedQueue<FetchedAppSettingsCallback> fetchedAppSettingsCallbacks = new ConcurrentLinkedQueue();
    private static boolean isUnityInit = false;
    private static final AtomicReference<FetchAppSettingState> loadingState = new AtomicReference(FetchAppSettingState.NOT_LOADED);
    private static boolean printedSDKUpdatedMessage = false;
    private static JSONArray unityEventBindings = null;

    enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        static {
            AppMethodBeat.o(72309);
        }
    }

    public interface FetchedAppSettingsCallback {
        void onError();

        void onSuccess(FetchedAppSettings fetchedAppSettings);
    }

    static /* synthetic */ FetchedAppSettings access$000(String str, JSONObject jSONObject) {
        AppMethodBeat.i(72319);
        FetchedAppSettings parseAppSettingsFromJSON = parseAppSettingsFromJSON(str, jSONObject);
        AppMethodBeat.o(72319);
        return parseAppSettingsFromJSON;
    }

    static /* synthetic */ JSONObject access$100(String str) {
        AppMethodBeat.i(72320);
        JSONObject appSettingsQueryResponse = getAppSettingsQueryResponse(str);
        AppMethodBeat.o(72320);
        return appSettingsQueryResponse;
    }

    static /* synthetic */ void access$600() {
        AppMethodBeat.i(72321);
        pollCallbacks();
        AppMethodBeat.o(72321);
    }

    static {
        AppMethodBeat.i(72322);
        AppMethodBeat.o(72322);
    }

    public static void loadAppSettingsAsync() {
        AppMethodBeat.i(72310);
        final Context applicationContext = FacebookSdk.getApplicationContext();
        final String applicationId = FacebookSdk.getApplicationId();
        if (Utility.isNullOrEmpty(applicationId)) {
            loadingState.set(FetchAppSettingState.ERROR);
            pollCallbacks();
            AppMethodBeat.o(72310);
        } else if (fetchedAppSettings.containsKey(applicationId)) {
            loadingState.set(FetchAppSettingState.SUCCESS);
            pollCallbacks();
            AppMethodBeat.o(72310);
        } else {
            int i;
            if (loadingState.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || loadingState.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING)) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                pollCallbacks();
                AppMethodBeat.o(72310);
                return;
            }
            final String format = String.format(APP_SETTINGS_PREFS_KEY_FORMAT, new Object[]{applicationId});
            FacebookSdk.getExecutor().execute(new Runnable() {
                public final void run() {
                    JSONObject jSONObject;
                    FetchedAppSettings fetchedAppSettings = null;
                    AppMethodBeat.i(72304);
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FetchedAppSettingsManager.APP_SETTINGS_PREFS_STORE, 0);
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e) {
                            Utility.logd("FacebookSDK", e);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            fetchedAppSettings = FetchedAppSettingsManager.access$000(applicationId, jSONObject);
                        }
                    }
                    jSONObject = FetchedAppSettingsManager.access$100(applicationId);
                    if (jSONObject != null) {
                        FetchedAppSettingsManager.access$000(applicationId, jSONObject);
                        sharedPreferences.edit().putString(format, jSONObject.toString()).apply();
                    }
                    if (fetchedAppSettings != null) {
                        String sdkUpdateMessage = fetchedAppSettings.getSdkUpdateMessage();
                        if (!(FetchedAppSettingsManager.printedSDKUpdatedMessage || sdkUpdateMessage == null || sdkUpdateMessage.length() <= 0)) {
                            FetchedAppSettingsManager.printedSDKUpdatedMessage = true;
                            FetchedAppSettingsManager.TAG;
                        }
                    }
                    AutomaticAnalyticsLogger.logActivateAppEvent();
                    InAppPurchaseActivityLifecycleTracker.update();
                    FetchedAppSettingsManager.loadingState.set(FetchedAppSettingsManager.fetchedAppSettings.containsKey(applicationId) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
                    FetchedAppSettingsManager.access$600();
                    AppMethodBeat.o(72304);
                }
            });
            AppMethodBeat.o(72310);
        }
    }

    public static FetchedAppSettings getAppSettingsWithoutQuery(String str) {
        AppMethodBeat.i(72311);
        if (str != null) {
            FetchedAppSettings fetchedAppSettings = (FetchedAppSettings) fetchedAppSettings.get(str);
            AppMethodBeat.o(72311);
            return fetchedAppSettings;
        }
        AppMethodBeat.o(72311);
        return null;
    }

    public static void getAppSettingsAsync(FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        AppMethodBeat.i(72312);
        fetchedAppSettingsCallbacks.add(fetchedAppSettingsCallback);
        loadAppSettingsAsync();
        AppMethodBeat.o(72312);
    }

    private static synchronized void pollCallbacks() {
        synchronized (FetchedAppSettingsManager.class) {
            AppMethodBeat.i(72313);
            FetchAppSettingState fetchAppSettingState = (FetchAppSettingState) loadingState.get();
            if (FetchAppSettingState.NOT_LOADED.equals(fetchAppSettingState) || FetchAppSettingState.LOADING.equals(fetchAppSettingState)) {
                AppMethodBeat.o(72313);
            } else {
                final FetchedAppSettings fetchedAppSettings = (FetchedAppSettings) fetchedAppSettings.get(FacebookSdk.getApplicationId());
                Handler handler = new Handler(Looper.getMainLooper());
                final FetchedAppSettingsCallback fetchedAppSettingsCallback;
                if (FetchAppSettingState.ERROR.equals(fetchAppSettingState)) {
                    while (!fetchedAppSettingsCallbacks.isEmpty()) {
                        fetchedAppSettingsCallback = (FetchedAppSettingsCallback) fetchedAppSettingsCallbacks.poll();
                        handler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(72305);
                                fetchedAppSettingsCallback.onError();
                                AppMethodBeat.o(72305);
                            }
                        });
                    }
                    AppMethodBeat.o(72313);
                } else {
                    while (!fetchedAppSettingsCallbacks.isEmpty()) {
                        fetchedAppSettingsCallback = (FetchedAppSettingsCallback) fetchedAppSettingsCallbacks.poll();
                        handler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(72306);
                                fetchedAppSettingsCallback.onSuccess(fetchedAppSettings);
                                AppMethodBeat.o(72306);
                            }
                        });
                    }
                    AppMethodBeat.o(72313);
                }
            }
        }
    }

    public static FetchedAppSettings queryAppSettings(String str, boolean z) {
        AppMethodBeat.i(72314);
        FetchedAppSettings parseAppSettingsFromJSON;
        if (z || !fetchedAppSettings.containsKey(str)) {
            JSONObject appSettingsQueryResponse = getAppSettingsQueryResponse(str);
            if (appSettingsQueryResponse == null) {
                AppMethodBeat.o(72314);
                return null;
            }
            parseAppSettingsFromJSON = parseAppSettingsFromJSON(str, appSettingsQueryResponse);
            if (str.equals(FacebookSdk.getApplicationId())) {
                loadingState.set(FetchAppSettingState.SUCCESS);
                pollCallbacks();
            }
            AppMethodBeat.o(72314);
            return parseAppSettingsFromJSON;
        }
        parseAppSettingsFromJSON = (FetchedAppSettings) fetchedAppSettings.get(str);
        AppMethodBeat.o(72314);
        return parseAppSettingsFromJSON;
    }

    private static FetchedAppSettings parseAppSettingsFromJSON(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification defaultErrorClassification;
        AppMethodBeat.i(72315);
        JSONArray optJSONArray = jSONObject.optJSONArray(APP_SETTING_ANDROID_SDK_ERROR_CATEGORIES);
        if (optJSONArray == null) {
            defaultErrorClassification = FacebookRequestErrorClassification.getDefaultErrorClassification();
        } else {
            defaultErrorClassification = FacebookRequestErrorClassification.createFromJSON(optJSONArray);
        }
        int optInt = jSONObject.optInt(APP_SETTING_APP_EVENTS_FEATURE_BITMASK, 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean optBoolean = jSONObject.optBoolean(APP_SETTING_APP_EVENTS_CODELESS_SETUP_ENABLED, false);
        JSONArray optJSONArray2 = jSONObject.optJSONArray(APP_SETTING_APP_EVENTS_EVENT_BINDINGS);
        unityEventBindings = optJSONArray2;
        if (optJSONArray2 != null && InternalSettings.isUnityApp()) {
            UnityReflection.sendEventMapping(optJSONArray2.toString());
        }
        FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(jSONObject.optBoolean(APP_SETTING_SUPPORTS_IMPLICIT_SDK_LOGGING, false), jSONObject.optString(APP_SETTING_NUX_CONTENT, ""), jSONObject.optBoolean(APP_SETTING_NUX_ENABLED, false), jSONObject.optBoolean(APP_SETTING_CUSTOM_TABS_ENABLED, false), jSONObject.optInt(APP_SETTING_APP_EVENTS_SESSION_TIMEOUT, Constants.getDefaultAppEventsSessionTimeoutInSeconds()), SmartLoginOption.parseOptions(jSONObject.optLong(APP_SETTING_SMART_LOGIN_OPTIONS)), parseDialogConfigurations(jSONObject.optJSONObject(APP_SETTING_DIALOG_CONFIGS)), z, defaultErrorClassification, jSONObject.optString(SMART_LOGIN_BOOKMARK_ICON_URL), jSONObject.optString(SMART_LOGIN_MENU_ICON_URL), z2, z3, optJSONArray2, jSONObject.optString(SDK_UPDATE_MESSAGE), z4, optBoolean);
        fetchedAppSettings.put(str, fetchedAppSettings);
        AppMethodBeat.o(72315);
        return fetchedAppSettings;
    }

    public static void setIsUnityInit(boolean z) {
        AppMethodBeat.i(72316);
        isUnityInit = z;
        if (unityEventBindings != null && isUnityInit) {
            UnityReflection.sendEventMapping(unityEventBindings.toString());
        }
        AppMethodBeat.o(72316);
    }

    private static JSONObject getAppSettingsQueryResponse(String str) {
        AppMethodBeat.i(72317);
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(APP_SETTING_FIELDS))));
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            bundle.putString(ADVERTISER_ID_KEY, attributionIdentifiers.getAndroidAdvertiserId());
        }
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, str, null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        AppMethodBeat.o(72317);
        return jSONObject;
    }

    private static Map<String, Map<String, DialogFeatureConfig>> parseDialogConfigurations(JSONObject jSONObject) {
        AppMethodBeat.i(72318);
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            if (optJSONArray != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= optJSONArray.length()) {
                        break;
                    }
                    DialogFeatureConfig parseDialogConfig = DialogFeatureConfig.parseDialogConfig(optJSONArray.optJSONObject(i2));
                    if (parseDialogConfig != null) {
                        String dialogName = parseDialogConfig.getDialogName();
                        Map map = (Map) hashMap.get(dialogName);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(dialogName, map);
                        }
                        map.put(parseDialogConfig.getFeatureName(), parseDialogConfig);
                    }
                    i = i2 + 1;
                }
            }
        }
        AppMethodBeat.o(72318);
        return hashMap;
    }
}
