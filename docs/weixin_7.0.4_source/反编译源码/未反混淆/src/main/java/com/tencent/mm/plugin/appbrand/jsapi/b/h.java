package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.graphics.Paint.FontMetrics;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends u {
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
            r6.nE(2);
     */
    /* JADX WARNING: Missing block: B:38:?, code skipped:
            r6.nE(2);
     */
    /* JADX WARNING: Missing block: B:39:0x015c, code skipped:
            r6.nE(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final String b(c cVar, JSONObject jSONObject) {
        String j;
        String optString;
        float optDouble;
        a aVar;
        String string;
        int i = -1;
        AppMethodBeat.i(103855);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiMeasureText", "measureText, data is null");
            j = j("fail:data is null", null);
            AppMethodBeat.o(103855);
            return j;
        }
        optString = jSONObject.optString("text");
        optDouble = (float) jSONObject.optDouble("fontSize", 16.0d);
        ab.i("MicroMsg.JsApiMeasureText", "measureText data:%s", jSONObject.toString());
        if (TextUtils.isEmpty(optString) || optDouble <= 0.0f) {
            ab.e("MicroMsg.JsApiMeasureText", "measureText, param is illegal");
            j = j("fail:param is illegal", null);
            AppMethodBeat.o(103855);
            return j;
        }
        aVar = new a();
        aVar.setTextSize(g.av(optDouble));
        try {
            aVar.yB(jSONObject.getString("fontFamily"));
        } catch (JSONException e) {
            ab.i("MicroMsg.JsApiMeasureText", "get 'fontFamily' error");
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
            ab.i("MicroMsg.JsApiMeasureText", "get 'fontStyle' error.");
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
                    aVar.setFakeBoldText(true);
                    break;
                case 1:
                    aVar.setFakeBoldText(false);
                    break;
            }
        } catch (JSONException e3) {
            ab.i("MicroMsg.JsApiMeasureText", "get 'fontWeight' error.");
        }
        measureText = aVar.measureText(optString);
        fontMetrics = aVar.getFontMetrics();
        ab.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top)));
        measureText = g.au(measureText);
        optDouble = g.au(r5);
        hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(optDouble));
        ab.i("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
        j = j("ok", hashMap);
        AppMethodBeat.o(103855);
        return j;
        measureText = aVar.measureText(optString);
        fontMetrics = aVar.getFontMetrics();
        ab.i("MicroMsg.JsApiMeasureText", "fontMetrics.bottom : %f, fontMetrics.top : %f, width : %f, height : %f", Float.valueOf(fontMetrics.bottom), Float.valueOf(fontMetrics.top), Float.valueOf(measureText), Float.valueOf(Math.abs(fontMetrics.bottom - fontMetrics.top)));
        measureText = g.au(measureText);
        optDouble = g.au(r5);
        hashMap = new HashMap();
        hashMap.put("width", Float.valueOf(measureText));
        hashMap.put("height", Float.valueOf(optDouble));
        ab.i("MicroMsg.JsApiMeasureText", "map:%s", hashMap.toString());
        j = j("ok", hashMap);
        AppMethodBeat.o(103855);
        return j;
    }
}
