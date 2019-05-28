package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bm */
public final class C42489bm extends C10296a<C2119d> {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> hzt;

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(101956);
        C2119d c2119d = (C2119d) c2241c;
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.m43291b((C25697b) c2119d.getRuntime()) || optJSONArray == null) {
            c2119d.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(101956);
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < optJSONArray.length()) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("key");
                    String optString2 = optJSONObject.optString("value");
                    if (!C5046bo.isNullOrNil(optString)) {
                        Integer num = (Integer) hzt.get(optString.hashCode());
                        if (num != null) {
                            AppBrandPerformanceManager.m43288a((C25697b) c2119d.getRuntime(), num.intValue(), optString2);
                        } else {
                            AppBrandPerformanceManager.m43290a((C25697b) c2119d.getRuntime(), optString, optString2);
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                c2119d.mo6107M(i, mo73394j("ok", null));
                AppMethodBeat.m2505o(101956);
                return;
            }
        }
    }

    static {
        AppMethodBeat.m2504i(101957);
        SparseArray sparseArray = new SparseArray();
        hzt = sparseArray;
        sparseArray.put("firstRenderTime".hashCode(), Integer.valueOf(301));
        hzt.put("reRenderTime".hashCode(), Integer.valueOf(302));
        hzt.put("webview2AppServiceTotalTime".hashCode(), Integer.valueOf(402));
        hzt.put("webview2AppServiceDataSize".hashCode(), Integer.valueOf(403));
        hzt.put("webview2AppServiceNativeTime".hashCode(), Integer.valueOf(404));
        hzt.put("appService2WebviewTotalTime".hashCode(), Integer.valueOf(405));
        hzt.put("appService2WebviewDataSize".hashCode(), Integer.valueOf(406));
        hzt.put("appService2WebviewNativeTime".hashCode(), Integer.valueOf(407));
        AppMethodBeat.m2505o(101957);
    }
}
