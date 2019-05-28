package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import com.facebook.LoggingBehavior;
import com.facebook.internal.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

class FacebookSDKJSInterface {
    private static final String PARAMETER_FBSDK_PIXEL_REFERRAL = "_fb_pixel_referral_id";
    private static final String PROTOCOL = "fbmq-0.1";
    public static final String TAG = FacebookSDKJSInterface.class.getSimpleName();
    private Context context;

    static {
        AppMethodBeat.i(71987);
        AppMethodBeat.o(71987);
    }

    public FacebookSDKJSInterface(Context context) {
        this.context = context;
    }

    private static Bundle jsonToBundle(JSONObject jSONObject) {
        AppMethodBeat.i(71984);
        Bundle bundle = new Bundle();
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            bundle.putString(str, jSONObject.getString(str));
        }
        AppMethodBeat.o(71984);
        return bundle;
    }

    private static Bundle jsonStringToBundle(String str) {
        AppMethodBeat.i(71985);
        Bundle jsonToBundle;
        try {
            jsonToBundle = jsonToBundle(new JSONObject(str));
            AppMethodBeat.o(71985);
            return jsonToBundle;
        } catch (JSONException e) {
            jsonToBundle = new Bundle();
            AppMethodBeat.o(71985);
            return jsonToBundle;
        }
    }

    @JavascriptInterface
    public void sendEvent(String str, String str2, String str3) {
        AppMethodBeat.i(71986);
        if (str == null) {
            Logger.log(LoggingBehavior.DEVELOPER_ERRORS, TAG, "Can't bridge an event without a referral Pixel ID. Check your webview Pixel configuration");
            AppMethodBeat.o(71986);
            return;
        }
        AppEventsLogger newLogger = AppEventsLogger.newLogger(this.context);
        Bundle jsonStringToBundle = jsonStringToBundle(str3);
        jsonStringToBundle.putString(PARAMETER_FBSDK_PIXEL_REFERRAL, str);
        newLogger.logEvent(str2, jsonStringToBundle);
        AppMethodBeat.o(71986);
    }

    @JavascriptInterface
    public String getProtocol() {
        return PROTOCOL;
    }
}
