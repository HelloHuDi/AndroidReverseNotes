package com.tencent.p177mm.plugin.game.luggage.p429b;

import android.content.Context;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38854b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b.e */
public class C34287e extends C22840bc {
    public final int biG() {
        return 1;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
        AppMethodBeat.m2504i(135870);
        LinkedList biz = ((C38855d) C1720g.m3528K(C38855d.class)).biz();
        if (C5046bo.m7548ek(biz)) {
            c22841a.mo26722d(null, null);
            AppMethodBeat.m2505o(135870);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = biz.iterator();
        while (it.hasNext()) {
            C38854b c38854b = (C38854b) it.next();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("appid", c38854b.appId);
                jSONObject2.put("status", c38854b.kOe);
                jSONObject2.put("download_id", c38854b.crZ);
                jSONObject2.put("progress", c38854b.progress);
                if (c38854b.kNu) {
                    jSONObject2.put("reserve_for_wifi", 1);
                }
            } catch (JSONException e) {
            }
            jSONArray.put(jSONObject2);
        }
        try {
            jSONObject.put("result", jSONArray.toString());
        } catch (JSONException e2) {
        }
        c22841a.mo26722d(null, jSONObject);
        AppMethodBeat.m2505o(135870);
    }

    public final String name() {
        return "getDownloadWidgetTaskInfos";
    }
}
