package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.webview.ui.tools.game.e.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {

    public static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(8702);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("report_data");
            String string2 = bundle.getString("url");
            if (!bo.isNullOrNil(string)) {
                try {
                    f.y(string2, f.aO(new JSONObject(string)));
                    AppMethodBeat.o(8702);
                    return;
                } catch (JSONException e) {
                }
            }
            AppMethodBeat.o(8702);
        }
    }

    public static void y(String str, Map<Integer, Object> map) {
        AppMethodBeat.i(8703);
        if (ah.doF()) {
            g agh = g.agh(str);
            map.put(Integer.valueOf(b.uDF), Long.valueOf(agh.uDL - agh.startTime));
            map.put(Integer.valueOf(b.uDG), Long.valueOf(agh.uDM - agh.startTime));
            map.put(Integer.valueOf(b.uDH), Long.valueOf(agh.uDN - agh.uDM));
            map.put(Integer.valueOf(b.uDI), Long.valueOf(agh.uDP - agh.uDO));
            map.put(Integer.valueOf(b.uDJ), Long.valueOf(agh.uDR - agh.uDQ));
            e.x(str, map);
            AppMethodBeat.o(8703);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("report_data", aJ(map).toString());
        bundle.putString("url", str);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", bundle, a.class, null);
        AppMethodBeat.o(8703);
    }

    private static JSONObject aJ(Map<Integer, Object> map) {
        AppMethodBeat.i(8704);
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            AppMethodBeat.o(8704);
            return jSONObject;
        }
        try {
            for (Integer num : map.keySet()) {
                jSONObject.put(String.valueOf(num), map.get(num));
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(8704);
        return jSONObject;
    }

    public static Map<Integer, Object> aO(JSONObject jSONObject) {
        AppMethodBeat.i(8705);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(8705);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            int i = bo.getInt(str, -1);
            if (i == -1) {
                ab.i("MicroMsg.GameWebReportUtil", "reportData key error");
            } else {
                hashMap.put(Integer.valueOf(i), jSONObject.opt(str));
            }
        }
        AppMethodBeat.o(8705);
        return hashMap;
    }
}
