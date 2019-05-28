package com.tencent.p177mm.plugin.appbrand.dynamic.p288h;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.collector.C2107c;
import com.tencent.p177mm.plugin.appbrand.collector.CollectSession;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19311e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.d */
public final class C26863d {
    private static Set<String> hoG = new HashSet();

    static {
        AppMethodBeat.m2504i(10958);
        String str = C19311e.NAME;
        if (!TextUtils.isEmpty(str)) {
            hoG.add(str);
        }
        AppMethodBeat.m2505o(10958);
    }

    /* renamed from: yN */
    public static boolean m42789yN(String str) {
        AppMethodBeat.m2504i(10955);
        boolean contains = hoG.contains(str);
        AppMethodBeat.m2505o(10955);
        return contains;
    }

    /* renamed from: a */
    public static void m42787a(String str, String str2, JSONObject jSONObject) {
        AppMethodBeat.m2504i(10956);
        try {
            jSONObject.put("__session_id", str);
            jSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
            CollectSession yH = C2107c.m4318yH(str);
            if (yH != null) {
                yH.cBY.putInt("__invoke_jsapi_data_size", str2.length());
            }
            AppMethodBeat.m2505o(10956);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiCostTimeStrategy", "%s", Log.getStackTraceString(e));
            AppMethodBeat.m2505o(10956);
        }
    }

    /* renamed from: o */
    public static String m42788o(JSONObject jSONObject) {
        AppMethodBeat.m2504i(10957);
        String optString = jSONObject.optString("__session_id");
        AppMethodBeat.m2505o(10957);
        return optString;
    }
}
