package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class e extends a<u> {
    private static final int CTRL_INDEX = 119;
    private static final String NAME = "removeTextArea";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(123541);
        u uVar = (u) cVar;
        try {
            final int i2 = jSONObject.getInt("inputId");
            final WeakReference weakReference = new WeakReference(uVar);
            m.runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(123540);
                    u uVar = (u) weakReference.get();
                    if (uVar == null) {
                        AppMethodBeat.o(123540);
                        return;
                    }
                    if (uVar.aJw() != null) {
                        uVar.aJw().aqX();
                    }
                    uVar.M(i, e.this.j(o.b(uVar, i2) ? "ok" : "fail", null));
                    AppMethodBeat.o(123540);
                }
            });
            AppMethodBeat.o(123541);
        } catch (JSONException e) {
            uVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(123541);
        }
    }
}
