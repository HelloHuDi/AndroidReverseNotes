package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.g;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d<CONTEXT extends c> extends a<CONTEXT> {
    /* Access modifiers changed, original: protected */
    public int r(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    protected static float[] s(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            float a = g.a(jSONObject2, "left", 0.0f);
            float a2 = g.a(jSONObject2, "top", 0.0f);
            float a3 = g.a(jSONObject2, "width", 0.0f);
            float a4 = g.a(jSONObject2, "height", 0.0f);
            int optInt = jSONObject.optInt("zIndex", 0);
            return new float[]{a, a2, a3, a4, (float) optInt};
        } catch (Exception e) {
            return null;
        }
    }

    protected static int t(JSONObject jSONObject) {
        int i = -1;
        try {
            return jSONObject.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE) ? 4 : 0;
        } catch (JSONException e) {
            return i;
        }
    }

    protected static Boolean u(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (JSONException e) {
            return null;
        }
    }

    protected static Boolean v(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fullscreen"));
        } catch (JSONException e) {
            return null;
        }
    }
}
