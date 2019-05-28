package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class eh extends dy {
    private static boolean a = false;

    public final void a(JSONObject jSONObject) {
        AppMethodBeat.i(98787);
        try {
            String optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        er.a("");
                        AppMethodBeat.o(98787);
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            optString = jSONObject.optString("deviceId");
            if (TextUtils.isEmpty(optString)) {
                er.a("");
            } else {
                String a = er.a();
                if (!(TextUtils.isEmpty(optString) || optString.equals(a))) {
                    er.a(optString);
                }
            }
            optString = jSONObject.optString("oper");
            if (!TextUtils.isEmpty(optString)) {
                ds.a().a(ce.b(), optString);
            }
            AppMethodBeat.o(98787);
        } catch (Throwable th2) {
            AppMethodBeat.o(98787);
        }
    }

    public final String c() {
        return "state";
    }

    public final void a(du duVar) {
        AppMethodBeat.i(98786);
        dx dxVar = new dx();
        dw dwVar = new dw();
        dv dvVar = new dv();
        try {
            Integer valueOf;
            if (eu.a(dwVar.b) || !a) {
                valueOf = Integer.valueOf(1);
                duVar.a.put("needUpdateState", valueOf);
                a = true;
            } else {
                valueOf = Integer.valueOf(0);
                duVar.a.put("needUpdateState", valueOf);
            }
            if (eu.a(dwVar.b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", dxVar.a);
                jSONObject.put("osVersion", dxVar.b);
                jSONObject.put("imei", dxVar.c);
                jSONObject.put("imsi", dxVar.d);
                jSONObject.put("pseudoId", dxVar.e);
                duVar.a.put("RegistDeviceInfo", jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", dwVar.a);
            jSONObject2.put("deviceId", dwVar.b);
            jSONObject2.put("sdkVersion", dwVar.c);
            duVar.a.put("BindDeviceInfo", jSONObject2);
            jSONObject2 = new JSONObject();
            jSONObject2.put("bundle", dvVar.a);
            jSONObject2.put("verCode", dvVar.b);
            jSONObject2.put("verName", dvVar.c);
            jSONObject2.put("appId", dvVar.e);
            jSONObject2.put("uuid", dvVar.d);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            duVar.a.put("AppState", jSONArray);
            int g = ce.g();
            duVar.a.put(DownloadInfo.NETTYPE, er.a(g));
            String a = ds.a(ce.j().intValue());
            duVar.a.put("oper", a);
            AppMethodBeat.o(98786);
        } catch (Exception e) {
            AppMethodBeat.o(98786);
        }
    }
}
