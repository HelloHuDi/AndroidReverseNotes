package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.eh */
public final class C41044eh extends C16219dy {
    /* renamed from: a */
    private static boolean f16468a = false;

    /* renamed from: a */
    public final void mo12416a(JSONObject jSONObject) {
        AppMethodBeat.m2504i(98787);
        try {
            String optString = jSONObject.optString("result");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    if (Integer.parseInt(optString) == 1002) {
                        C24370er.m37710a("");
                        AppMethodBeat.m2505o(98787);
                        return;
                    }
                } catch (Throwable th) {
                }
            }
            optString = jSONObject.optString("deviceId");
            if (TextUtils.isEmpty(optString)) {
                C24370er.m37710a("");
            } else {
                String a = C24370er.m37706a();
                if (!(TextUtils.isEmpty(optString) || optString.equals(a))) {
                    C24370er.m37710a(optString);
                }
            }
            optString = jSONObject.optString("oper");
            if (!TextUtils.isEmpty(optString)) {
                C44508ds.m80717a().mo70877a(C31029ce.m49847b(), optString);
            }
            AppMethodBeat.m2505o(98787);
        } catch (Throwable th2) {
            AppMethodBeat.m2505o(98787);
        }
    }

    /* renamed from: c */
    public final String mo12417c() {
        return "state";
    }

    /* renamed from: a */
    public final void mo12415a(C41043du c41043du) {
        AppMethodBeat.m2504i(98786);
        C31038dx c31038dx = new C31038dx();
        C24368dw c24368dw = new C24368dw();
        C46778dv c46778dv = new C46778dv();
        try {
            Integer valueOf;
            if (C24373eu.m37738a(c24368dw.f4669b) || !f16468a) {
                valueOf = Integer.valueOf(1);
                c41043du.f16467a.put("needUpdateState", valueOf);
                f16468a = true;
            } else {
                valueOf = Integer.valueOf(0);
                c41043du.f16467a.put("needUpdateState", valueOf);
            }
            if (C24373eu.m37738a(c24368dw.f4669b)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("model", c31038dx.f14106a);
                jSONObject.put("osVersion", c31038dx.f14107b);
                jSONObject.put("imei", c31038dx.f14108c);
                jSONObject.put("imsi", c31038dx.f14109d);
                jSONObject.put("pseudoId", c31038dx.f14110e);
                c41043du.f16467a.put("RegistDeviceInfo", jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", c24368dw.f4668a);
            jSONObject2.put("deviceId", c24368dw.f4669b);
            jSONObject2.put("sdkVersion", c24368dw.f4670c);
            c41043du.f16467a.put("BindDeviceInfo", jSONObject2);
            jSONObject2 = new JSONObject();
            jSONObject2.put("bundle", c46778dv.f18116a);
            jSONObject2.put("verCode", c46778dv.f18117b);
            jSONObject2.put("verName", c46778dv.f18118c);
            jSONObject2.put("appId", c46778dv.f18120e);
            jSONObject2.put("uuid", c46778dv.f18119d);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            c41043du.f16467a.put("AppState", jSONArray);
            int g = C31029ce.m49852g();
            c41043du.f16467a.put(DownloadInfo.NETTYPE, C24370er.m37707a(g));
            String a = C44508ds.m80718a(C31029ce.m49855j().intValue());
            c41043du.f16467a.put("oper", a);
            AppMethodBeat.m2505o(98786);
        } catch (Exception e) {
            AppMethodBeat.m2505o(98786);
        }
    }
}
