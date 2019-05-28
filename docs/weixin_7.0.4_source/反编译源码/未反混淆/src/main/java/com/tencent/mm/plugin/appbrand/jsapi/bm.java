package com.tencent.mm.plugin.appbrand.jsapi;

import android.util.SparseArray;
import com.tencent.luggage.sdk.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bm extends a<d> {
    public static final int CTRL_INDEX = 215;
    public static final String NAME = "updatePerfData";
    private static final SparseArray<Integer> hzt;

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(101956);
        d dVar = (d) cVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (!AppBrandPerformanceManager.b((b) dVar.getRuntime()) || optJSONArray == null) {
            dVar.M(i, j("fail", null));
            AppMethodBeat.o(101956);
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
                    if (!bo.isNullOrNil(optString)) {
                        Integer num = (Integer) hzt.get(optString.hashCode());
                        if (num != null) {
                            AppBrandPerformanceManager.a((b) dVar.getRuntime(), num.intValue(), optString2);
                        } else {
                            AppBrandPerformanceManager.a((b) dVar.getRuntime(), optString, optString2);
                        }
                    }
                }
                i2 = i3 + 1;
            } else {
                dVar.M(i, j("ok", null));
                AppMethodBeat.o(101956);
                return;
            }
        }
    }

    static {
        AppMethodBeat.i(101957);
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
        AppMethodBeat.o(101957);
    }
}
