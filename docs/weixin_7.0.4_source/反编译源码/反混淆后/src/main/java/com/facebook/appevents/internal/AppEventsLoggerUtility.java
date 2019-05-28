package com.facebook.appevents.internal;

import android.content.Context;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AppEventsLoggerUtility {
    private static final Map<GraphAPIActivityType, String> API_ACTIVITY_TYPE_TO_STRING = new C254841();

    /* renamed from: com.facebook.appevents.internal.AppEventsLoggerUtility$1 */
    static class C254841 extends HashMap<GraphAPIActivityType, String> {
        C254841() {
            AppMethodBeat.m2504i(72165);
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
            AppMethodBeat.m2505o(72165);
        }
    }

    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        static {
            AppMethodBeat.m2505o(72168);
        }
    }

    static {
        AppMethodBeat.m2504i(72170);
        AppMethodBeat.m2505o(72170);
    }

    public static JSONObject getJSONObjectForGraphAPICall(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) {
        AppMethodBeat.m2504i(72169);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", API_ACTIVITY_TYPE_TO_STRING.get(graphAPIActivityType));
        String userID = AppEventsLogger.getUserID();
        if (userID != null) {
            jSONObject.put("app_user_id", userID);
        }
        userID = AppEventsLogger.getUserData();
        if (userID != null) {
            jSONObject.put("ud", userID);
        }
        Utility.setAppEventAttributionParameters(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.setAppEventExtendedDeviceInfoParameters(jSONObject, context);
        } catch (Exception e) {
            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        AppMethodBeat.m2505o(72169);
        return jSONObject;
    }
}
