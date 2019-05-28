package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vv;
import com.tencent.mm.plugin.game.luggage.d.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends bd<e> {
    public final int biG() {
        return 1;
    }

    public final void b(a aVar) {
    }

    public final void a(Context context, String str, bc.a aVar) {
        AppMethodBeat.i(135868);
        ab.i("MicroMsg.JsApiBatchUpdateWepkg", "invokeInMM");
        JSONObject bQ = i.bQ(str);
        if (bQ == null) {
            ab.e("MicroMsg.JsApiBatchUpdateWepkg", "data is null");
            aVar.d("fail", null);
            AppMethodBeat.o(135868);
            return;
        }
        String optString = bQ.optString("pkgIdList");
        if (!bo.isNullOrNil(optString)) {
            try {
                JSONArray jSONArray = new JSONArray(optString);
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        arrayList.add(jSONArray.optString(i));
                    }
                    if (!bo.ek(arrayList)) {
                        vv vvVar = new vv();
                        vvVar.cSX.cuy = 8;
                        vvVar.cSX.scene = 0;
                        vvVar.cSX.cTc = arrayList;
                        com.tencent.mm.sdk.b.a.xxA.m(vvVar);
                        aVar.d(null, null);
                        AppMethodBeat.o(135868);
                        return;
                    }
                }
            } catch (JSONException e) {
                ab.e("MicroMsg.JsApiBatchUpdateWepkg", "data is not json");
            }
        }
        aVar.d("fail", null);
        AppMethodBeat.o(135868);
    }

    public final String name() {
        return "batchUpdateWepkg";
    }
}
