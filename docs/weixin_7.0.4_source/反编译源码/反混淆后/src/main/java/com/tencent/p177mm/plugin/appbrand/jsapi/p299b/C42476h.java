package com.tencent.p177mm.plugin.appbrand.jsapi.p299b;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.canvas.p885a.C10148a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.b.h */
public final class C42476h extends C19497u {
    public static final int CTRL_INDEX = 436;
    public static final String NAME = "measureText";

    /* JADX WARNING: Missing block: B:14:0x0087, code skipped:
            r3 = -1;
     */
    /* JADX WARNING: Missing block: B:15:0x0088, code skipped:
            switch(r3) {
                case 0: goto L_0x0144;
                case 1: goto L_0x0156;
                case 2: goto L_0x015c;
                default: goto L_0x008b;
            };
     */
    /* JADX WARNING: Missing block: B:33:0x0144, code skipped:
            r6.mo21507nE(2);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r6.mo21507nE(2);
     */
    /* JADX WARNING: Missing block: B:39:0x015c, code skipped:
            r6.mo21507nE(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        String j;
        String optString;
        float optDouble;
        C10148a c10148a;
        String string;
        int i = -1;
        AppMethodBeat.m2504i(103855);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiMeasureText", "measureText, data is null");
            j = mo73394j("fail:data is null", null);
            AppMethodBeat.m2505o(103855);
            return j;
        }
        optString = jSONObject.optString("text");
        optDouble = (float) jSONObject.optDouble("fontSize", 16.0d);
        C4990ab.m7417i("MicroMsg.JsApiMeasureText", "measureText data:%s", jSONObject.toString());
        if (TextUtils.isEmpty(optString) || optDouble <= 0.0f) {
            C4990ab.m7412e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
            j = mo73394j("fail:param is illegal", null);
            AppMethodBeat.m2505o(103855);
            return j;
        }
        c10148a = new C10148a();
        c10148a.setTextSize(C42668g.m75557av(optDouble));
        try {
            c10148a.mo21511yB(jSONObject.getString("fontFamily"));
        } catch (JSONException e) {
            C4990ab.m7416i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
        }
        try {
            string = jSONObject.getString("fontStyle");
            int i2;
            switch (string.hashCode()) {
                case -1657669071:
                    if (string.equals("oblique")) {
                        i2 = 0;
                        break;
                    }
                case -1178781136:
                    if (string.equals("italic")) {
                        i2 = 1;
                        break;
                    }
                case -1039745817:
                    if (string.equals("normal")) {
                        i2 = 2;
                        break;
                    }
            }
        } catch (JSONException e2) {
            C4990ab.m7416i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
        }
        float measureText;
        FontMetrics fontMetrics;
        HashMap hashMap;
        try {
            string = jSONObject.getString("fontWeight");
            switch (string.hashCode()) {
                case -1039745817:
                    if (string.equals("normal")) {
                        i = 1;
                    }
                case 3029637:
                    if (string.equals("bold")) {
                        i = 0;
                    }
            }
            switch (i) {
                case 0:
                    c10148a.setFakeBoldText(true);
                    break;
                case 1:
                    c10148a.setFakeBoldText(false);
                    break;
            }
        } catch (JSONException e3) {
            C4990ab.m7416i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        }
        measureText = c10148a.measureText(optString);
        fontMetrics = c10148a.getFontMetrics();
        C4990ab.m7417i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top)));
        measureText = C42668g.m75556au(measureText);
        optDouble = C42668g.m75556au(r5);
        hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(optDouble));
        C4990ab.m7417i("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
        j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(103855);
        return j;
        measureText = c10148a.measureText(optString);
        fontMetrics = c10148a.getFontMetrics();
        C4990ab.m7417i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top)));
        measureText = C42668g.m75556au(measureText);
        optDouble = C42668g.m75556au(r5);
        hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(optDouble));
        C4990ab.m7417i("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
        j = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(103855);
        return j;
    }
}
