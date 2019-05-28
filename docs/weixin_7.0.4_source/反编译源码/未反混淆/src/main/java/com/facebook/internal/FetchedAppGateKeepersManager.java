package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FetchedAppGateKeepersManager {
    private static final String APPLICATION_DEVICE_ID = "device_id";
    private static final String APPLICATION_FIELDS = "fields";
    private static final String APPLICATION_GATEKEEPER_EDGE = "mobile_sdk_gk";
    private static final String APPLICATION_GATEKEEPER_FIELD = "gatekeepers";
    private static final String APPLICATION_GRAPH_DATA = "data";
    private static final String APPLICATION_PLATFORM = "platform";
    private static final String APPLICATION_SDK_VERSION = "sdk_version";
    public static final String APP_EVENTS_IF_AUTO_LOG_SUBS = "app_events_if_auto_log_subs";
    private static final String APP_GATEKEEPERS_PREFS_KEY_FORMAT = "com.facebook.internal.APP_GATEKEEPERS.%s";
    private static final String APP_GATEKEEPERS_PREFS_STORE = "com.facebook.internal.preferences.APP_GATEKEEPERS";
    private static final String APP_PLATFORM = "android";
    private static final String TAG = FetchedAppGateKeepersManager.class.getCanonicalName();
    private static final Map<String, JSONObject> fetchedAppGateKeepers = new ConcurrentHashMap();

    static /* synthetic */ void access$000(String str, JSONObject jSONObject) {
        AppMethodBeat.i(72298);
        parseAppGateKeepersFromJSON(str, jSONObject);
        AppMethodBeat.o(72298);
    }

    static /* synthetic */ JSONObject access$100(String str) {
        AppMethodBeat.i(72299);
        JSONObject appGateKeepersQueryResponse = getAppGateKeepersQueryResponse(str);
        AppMethodBeat.o(72299);
        return appGateKeepersQueryResponse;
    }

    static {
        AppMethodBeat.i(72300);
        AppMethodBeat.o(72300);
    }

    public static synchronized void loadAppGateKeepersAsync() {
        synchronized (FetchedAppGateKeepersManager.class) {
            AppMethodBeat.i(72294);
            final Context applicationContext = FacebookSdk.getApplicationContext();
            final String applicationId = FacebookSdk.getApplicationId();
            final String format = String.format(APP_GATEKEEPERS_PREFS_KEY_FORMAT, new Object[]{applicationId});
            FacebookSdk.getExecutor().execute(new Runnable() {
                public final void run() {
                    JSONObject jSONObject;
                    AppMethodBeat.i(72293);
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FetchedAppGateKeepersManager.APP_GATEKEEPERS_PREFS_STORE, 0);
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.isNullOrEmpty(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e) {
                            Utility.logd("FacebookSDK", e);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            FetchedAppGateKeepersManager.access$000(applicationId, jSONObject);
                        }
                    }
                    jSONObject = FetchedAppGateKeepersManager.access$100(applicationId);
                    if (jSONObject != null) {
                        FetchedAppGateKeepersManager.access$000(applicationId, jSONObject);
                        sharedPreferences.edit().putString(format, jSONObject.toString()).apply();
                    }
                    AppMethodBeat.o(72293);
                }
            });
            AppMethodBeat.o(72294);
        }
    }

    public static boolean getGateKeeperForKey(String str, String str2, boolean z) {
        AppMethodBeat.i(72295);
        if (str2 == null || !fetchedAppGateKeepers.containsKey(str2)) {
            AppMethodBeat.o(72295);
            return z;
        }
        z = ((JSONObject) fetchedAppGateKeepers.get(str2)).optBoolean(str, z);
        AppMethodBeat.o(72295);
        return z;
    }

    private static JSONObject getAppGateKeepersQueryResponse(String str) {
        AppMethodBeat.i(72296);
        Bundle bundle = new Bundle();
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        String str2 = "";
        if (!(attributionIdentifiers == null || attributionIdentifiers.getAndroidAdvertiserId() == null)) {
            str2 = attributionIdentifiers.getAndroidAdvertiserId();
        }
        String sdkVersion = FacebookSdk.getSdkVersion();
        bundle.putString(APPLICATION_PLATFORM, "android");
        bundle.putString(APPLICATION_DEVICE_ID, str2);
        bundle.putString(APPLICATION_SDK_VERSION, sdkVersion);
        bundle.putString("fields", APPLICATION_GATEKEEPER_FIELD);
        GraphRequest newGraphPathRequest = GraphRequest.newGraphPathRequest(null, String.format("%s/%s", new Object[]{str, APPLICATION_GATEKEEPER_EDGE}), null);
        newGraphPathRequest.setSkipClientToken(true);
        newGraphPathRequest.setParameters(bundle);
        JSONObject jSONObject = newGraphPathRequest.executeAndWait().getJSONObject();
        AppMethodBeat.o(72296);
        return jSONObject;
    }

    private static void parseAppGateKeepersFromJSON(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        int i = 0;
        AppMethodBeat.i(72297);
        if (fetchedAppGateKeepers.containsKey(str)) {
            jSONObject2 = (JSONObject) fetchedAppGateKeepers.get(str);
        } else {
            jSONObject2 = new JSONObject();
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        JSONObject jSONObject3 = null;
        if (optJSONArray != null) {
            jSONObject3 = optJSONArray.optJSONObject(0);
        }
        if (!(jSONObject3 == null || jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD) == null)) {
            optJSONArray = jSONObject3.optJSONArray(APPLICATION_GATEKEEPER_FIELD);
            while (i < optJSONArray.length()) {
                try {
                    jSONObject3 = optJSONArray.getJSONObject(i);
                    jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                } catch (JSONException e) {
                    Utility.logd("FacebookSDK", e);
                }
                i++;
            }
        }
        fetchedAppGateKeepers.put(str, jSONObject2);
        AppMethodBeat.o(72297);
    }
}
