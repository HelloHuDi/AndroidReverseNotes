package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONArray;

public class m extends bd<d> {
    public final String name() {
        return "disableBounceScroll";
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        Object obj = null;
        AppMethodBeat.i(6307);
        ab.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = aVar.bPa.bOf.optJSONArray("place");
        if (optJSONArray == null) {
            ab.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
            aVar.a("fail", null);
            AppMethodBeat.o(6307);
            return;
        }
        Object obj2;
        int i = 0;
        while (true) {
            obj2 = obj;
            if (i >= optJSONArray.length()) {
                break;
            }
            if ("top".equalsIgnoreCase(optJSONArray.optString(i))) {
                obj = 1;
            } else {
                obj = obj2;
            }
            i++;
        }
        if (obj2 == null) {
            aVar.a("", null);
            AppMethodBeat.o(6307);
            return;
        }
        ((d) aVar.bOZ).cWJ();
        aVar.a("", null);
        AppMethodBeat.o(6307);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
