package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a<q> {
    private static final int CTRL_INDEX = 106;
    private static final String NAME = "hideToast";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(74780);
        final q qVar = (q) cVar;
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74779);
                a aVar = a.this;
                q qVar = qVar;
                int i = i;
                b nV = v.Zp().nV(qVar.hashCode() + "toast_name");
                if (nV != null) {
                    View view = (View) nV.get("toast_view", null);
                    if (view != null) {
                        view.setVisibility(8);
                        qVar.M(i, aVar.j("ok", null));
                        AppMethodBeat.o(74779);
                        return;
                    }
                }
                qVar.M(i, aVar.j("fail:toast can't be found", null));
                AppMethodBeat.o(74779);
            }
        });
        AppMethodBeat.o(74780);
    }
}
