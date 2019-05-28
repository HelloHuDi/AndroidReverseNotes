package com.facebook.appevents;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class FacebookUninstallTracker {
    private static final String PLATFORM = "android";
    private static final String SUCCESS = "success";
    private static final String TAG = FacebookUninstallTracker.class.getCanonicalName();
    private static final String UPLOADED_TOKEN_STORE = "com.facebook.appevents.FacebookUninstallTracker.UPLOADED_TOKEN";
    private static final SharedPreferences uploadedTokenSharedPrefs = FacebookSdk.getApplicationContext().getSharedPreferences(UPLOADED_TOKEN_STORE, 0);

    static /* synthetic */ GraphRequest access$000(String str, String str2) {
        AppMethodBeat.m2504i(72002);
        GraphRequest buildPushDeviceTokenRequest = buildPushDeviceTokenRequest(str, str2);
        AppMethodBeat.m2505o(72002);
        return buildPushDeviceTokenRequest;
    }

    static {
        AppMethodBeat.m2504i(72003);
        AppMethodBeat.m2505o(72003);
    }

    public static void updateDeviceToken(String str) {
        AppMethodBeat.m2504i(71999);
        FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
        if (appSettingsWithoutQuery == null) {
            AppMethodBeat.m2505o(71999);
            return;
        }
        boolean trackUninstallEnabled = appSettingsWithoutQuery.getTrackUninstallEnabled();
        String string = uploadedTokenSharedPrefs.getString("uploaded_token", null);
        boolean z = uploadedTokenSharedPrefs.getBoolean("pre_track_uninstall_enabled", false);
        if (!trackUninstallEnabled || (z && str.equals(string))) {
            if (!trackUninstallEnabled && z) {
                uploadedTokenSharedPrefs.edit().putBoolean("pre_track_uninstall_enabled", false).apply();
            }
            AppMethodBeat.m2505o(71999);
            return;
        }
        sendToServer(str);
        AppMethodBeat.m2505o(71999);
    }

    private static void sendToServer(final String str) {
        AppMethodBeat.m2504i(72000);
        FacebookSdk.getExecutor().execute(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(71998);
                GraphRequest access$000 = FacebookUninstallTracker.access$000(FacebookSdk.getApplicationId(), str);
                if (access$000 != null) {
                    GraphResponse executeAndWait = access$000.executeAndWait();
                    try {
                        JSONObject jSONObject = executeAndWait.getJSONObject();
                        if (jSONObject != null) {
                            if (jSONObject.has("success") && jSONObject.getString("success").equals("true")) {
                                FacebookUninstallTracker.uploadedTokenSharedPrefs.edit().putString("uploaded_token", str).putBoolean("pre_track_uninstall_enabled", true).apply();
                                AppMethodBeat.m2505o(71998);
                                return;
                            }
                            FacebookUninstallTracker.TAG;
                            new StringBuilder("Error sending device token to Facebook: ").append(executeAndWait.getError());
                        }
                        AppMethodBeat.m2505o(71998);
                        return;
                    } catch (JSONException e) {
                        FacebookUninstallTracker.TAG;
                    }
                }
                AppMethodBeat.m2505o(71998);
            }
        });
        AppMethodBeat.m2505o(72000);
    }

    private static GraphRequest buildPushDeviceTokenRequest(String str, String str2) {
        AppMethodBeat.m2504i(72001);
        GraphRequest newPostRequest = GraphRequest.newPostRequest(null, String.format(Locale.US, "%s/app_push_device_token", new Object[]{str}), null, null);
        newPostRequest.setSkipClientToken(true);
        AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(FacebookSdk.getApplicationContext());
        if (attributionIdentifiers == null) {
            AppMethodBeat.m2505o(72001);
            return null;
        }
        String androidAdvertiserId = attributionIdentifiers.getAndroidAdvertiserId();
        Bundle parameters = newPostRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("device_id", androidAdvertiserId);
        parameters.putString("device_token", str2);
        parameters.putString("platform", "android");
        newPostRequest.setParameters(parameters);
        AppMethodBeat.m2505o(72001);
        return newPostRequest;
    }
}
