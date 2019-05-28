package com.tencent.mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc;
import com.tencent.mm.plugin.webview.luggage.jsapi.bc.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public class d implements c {
    public final void a(Context context, Bundle bundle, final a aVar) {
        AppMethodBeat.i(6254);
        String string = bundle.getString("jsapi_name");
        String string2 = bundle.getString("data");
        if (string == null) {
            ab.e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
            aVar.l(new Bundle());
            AppMethodBeat.o(6254);
            return;
        }
        try {
            ((bc) Class.forName(string).newInstance()).a(context, string2, new a() {
                public final void d(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(6253);
                    Bundle bundle = new Bundle();
                    bundle.putString("err_msg", str);
                    bundle.putString("data", jSONObject != null ? jSONObject.toString() : "");
                    aVar.l(bundle);
                    AppMethodBeat.o(6253);
                }
            });
            AppMethodBeat.o(6254);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.JsApiMMActivityTask", e, "", new Object[0]);
            aVar.l(new Bundle());
            AppMethodBeat.o(6254);
        }
    }
}
