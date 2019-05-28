package com.tencent.p177mm.plugin.appbrand.jsapi.base;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.base.d */
public abstract class C38268d<CONTEXT extends C2241c> extends C10296a<CONTEXT> {
    /* Access modifiers changed, original: protected */
    /* renamed from: r */
    public int mo6130r(JSONObject jSONObject) {
        throw new JSONException("viewId do not exist, override the method getViewId(data).");
    }

    /* renamed from: s */
    protected static float[] m64760s(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("position"));
            float a = C42668g.m75553a(jSONObject2, "left", 0.0f);
            float a2 = C42668g.m75553a(jSONObject2, "top", 0.0f);
            float a3 = C42668g.m75553a(jSONObject2, "width", 0.0f);
            float a4 = C42668g.m75553a(jSONObject2, "height", 0.0f);
            int optInt = jSONObject.optInt("zIndex", 0);
            return new float[]{a, a2, a3, a4, (float) optInt};
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: t */
    protected static int m64761t(JSONObject jSONObject) {
        int i = -1;
        try {
            return jSONObject.getBoolean(MessengerShareContentUtility.SHARE_BUTTON_HIDE) ? 4 : 0;
        } catch (JSONException e) {
            return i;
        }
    }

    /* renamed from: u */
    protected static Boolean m64762u(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fixed"));
        } catch (JSONException e) {
            return null;
        }
    }

    /* renamed from: v */
    protected static Boolean m64763v(JSONObject jSONObject) {
        try {
            return Boolean.valueOf(jSONObject.getBoolean("fullscreen"));
        } catch (JSONException e) {
            return null;
        }
    }
}
