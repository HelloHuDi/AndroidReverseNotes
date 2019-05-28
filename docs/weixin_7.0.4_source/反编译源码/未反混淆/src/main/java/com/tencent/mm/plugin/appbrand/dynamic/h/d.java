package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static Set<String> hoG = new HashSet();

    static {
        AppMethodBeat.i(10958);
        String str = e.NAME;
        if (!TextUtils.isEmpty(str)) {
            hoG.add(str);
        }
        AppMethodBeat.o(10958);
    }

    public static boolean yN(String str) {
        AppMethodBeat.i(10955);
        boolean contains = hoG.contains(str);
        AppMethodBeat.o(10955);
        return contains;
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        AppMethodBeat.i(10956);
        try {
            jSONObject.put("__session_id", str);
            jSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
            CollectSession yH = c.yH(str);
            if (yH != null) {
                yH.cBY.putInt("__invoke_jsapi_data_size", str2.length());
            }
            AppMethodBeat.o(10956);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiCostTimeStrategy", "%s", Log.getStackTraceString(e));
            AppMethodBeat.o(10956);
        }
    }

    public static String o(JSONObject jSONObject) {
        AppMethodBeat.i(10957);
        String optString = jSONObject.optString("__session_id");
        AppMethodBeat.o(10957);
        return optString;
    }
}
