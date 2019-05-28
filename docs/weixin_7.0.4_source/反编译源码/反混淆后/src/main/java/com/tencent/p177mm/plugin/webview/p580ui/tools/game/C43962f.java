package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C9549f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C43961e.C22978b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.f */
public final class C43962f {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.f$a */
    public static class C29923a implements C37866a<Bundle, Bundle> {
        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(8702);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("report_data");
            String string2 = bundle.getString("url");
            if (!C5046bo.isNullOrNil(string)) {
                try {
                    C43962f.m78896y(string2, C43962f.m78895aO(new JSONObject(string)));
                    AppMethodBeat.m2505o(8702);
                    return;
                } catch (JSONException e) {
                }
            }
            AppMethodBeat.m2505o(8702);
        }
    }

    /* renamed from: y */
    public static void m78896y(String str, Map<Integer, Object> map) {
        AppMethodBeat.m2504i(8703);
        if (C4996ah.doF()) {
            C43963g agh = C43963g.agh(str);
            map.put(Integer.valueOf(C22978b.uDF), Long.valueOf(agh.uDL - agh.startTime));
            map.put(Integer.valueOf(C22978b.uDG), Long.valueOf(agh.uDM - agh.startTime));
            map.put(Integer.valueOf(C22978b.uDH), Long.valueOf(agh.uDN - agh.uDM));
            map.put(Integer.valueOf(C22978b.uDI), Long.valueOf(agh.uDP - agh.uDO));
            map.put(Integer.valueOf(C22978b.uDJ), Long.valueOf(agh.uDR - agh.uDQ));
            C43961e.m78893x(str, map);
            AppMethodBeat.m2505o(8703);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("report_data", C43962f.m78894aJ(map).toString());
        bundle.putString("url", str);
        C9549f.m17012a("com.tencent.mm:tools", bundle, C29923a.class, null);
        AppMethodBeat.m2505o(8703);
    }

    /* renamed from: aJ */
    private static JSONObject m78894aJ(Map<Integer, Object> map) {
        AppMethodBeat.m2504i(8704);
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            AppMethodBeat.m2505o(8704);
            return jSONObject;
        }
        try {
            for (Integer num : map.keySet()) {
                jSONObject.put(String.valueOf(num), map.get(num));
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(8704);
        return jSONObject;
    }

    /* renamed from: aO */
    public static Map<Integer, Object> m78895aO(JSONObject jSONObject) {
        AppMethodBeat.m2504i(8705);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.m2505o(8705);
            return hashMap;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            String str = (String) keys.next();
            int i = C5046bo.getInt(str, -1);
            if (i == -1) {
                C4990ab.m7416i("MicroMsg.GameWebReportUtil", "reportData key error");
            } else {
                hashMap.put(Integer.valueOf(i), jSONObject.opt(str));
            }
        }
        AppMethodBeat.m2505o(8705);
        return hashMap;
    }
}
