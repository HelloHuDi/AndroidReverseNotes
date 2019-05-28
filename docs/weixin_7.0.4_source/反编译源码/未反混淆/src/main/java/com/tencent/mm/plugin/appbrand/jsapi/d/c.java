package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.appbrand.widget.input.o;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a {
    public static final int CTRL_INDEX = 70;
    public static final String NAME = "hideKeyboard";

    public final void a(final com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(123527);
        Integer num = null;
        try {
            num = Integer.valueOf(jSONObject.getInt("inputId"));
        } catch (JSONException e) {
        }
        m.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123526);
                if (cVar.isRunning()) {
                    u uVar;
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar = cVar;
                    if (cVar instanceof u) {
                        uVar = (u) cVar;
                    } else if (cVar instanceof q) {
                        uVar = ((q) cVar).getRuntime().asV().getCurrentPage().getCurrentPageView();
                    } else {
                        ab.e("MicroMsg.JsApiHideKeyboard", "invalid component type while calling hide keyboard");
                        uVar = null;
                    }
                    cVar.M(i, c.this.j(o.a(uVar, num) ? "ok" : "fail:input not exists", null));
                    AppMethodBeat.o(123526);
                    return;
                }
                AppMethodBeat.o(123526);
            }
        });
        AppMethodBeat.o(123527);
    }
}
