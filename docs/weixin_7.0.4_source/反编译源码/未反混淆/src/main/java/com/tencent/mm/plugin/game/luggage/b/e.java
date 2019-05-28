package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.b;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends bc {
    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135870);
        LinkedList biz = ((d) g.K(d.class)).biz();
        if (bo.ek(biz)) {
            aVar.d(null, null);
            AppMethodBeat.o(135870);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator it = biz.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("appid", bVar.appId);
                jSONObject2.put("status", bVar.kOe);
                jSONObject2.put("download_id", bVar.crZ);
                jSONObject2.put("progress", bVar.progress);
                if (bVar.kNu) {
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
        aVar.d(null, jSONObject);
        AppMethodBeat.o(135870);
    }

    public final String name() {
        return "getDownloadWidgetTaskInfos";
    }
}
