package com.tencent.p177mm.plugin.webview.luggage.ipc;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.ipc.d */
public class C43889d implements C35590c {
    /* renamed from: a */
    public final void mo56317a(Context context, Bundle bundle, final C4541a c4541a) {
        AppMethodBeat.m2504i(6254);
        String string = bundle.getString("jsapi_name");
        String string2 = bundle.getString("data");
        if (string == null) {
            C4990ab.m7412e("MicroMsg.JsApiMMActivityTask", "jsapi is null");
            c4541a.mo9613l(new Bundle());
            AppMethodBeat.m2505o(6254);
            return;
        }
        try {
            ((C22840bc) Class.forName(string).newInstance()).mo9617a(context, string2, new C22841a() {
                /* renamed from: d */
                public final void mo26722d(String str, JSONObject jSONObject) {
                    AppMethodBeat.m2504i(6253);
                    Bundle bundle = new Bundle();
                    bundle.putString("err_msg", str);
                    bundle.putString("data", jSONObject != null ? jSONObject.toString() : "");
                    c4541a.mo9613l(bundle);
                    AppMethodBeat.m2505o(6253);
                }
            });
            AppMethodBeat.m2505o(6254);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiMMActivityTask", e, "", new Object[0]);
            c4541a.mo9613l(new Bundle());
            AppMethodBeat.m2505o(6254);
        }
    }
}
