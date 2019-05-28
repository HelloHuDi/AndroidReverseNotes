package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class f extends a<c> {
    public static final int CTRL_INDEX = 621;
    public static final String NAME = "showShareActionSheet";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        w aun;
        AppMethodBeat.i(133645);
        if (cVar instanceof s) {
            aun = ((s) cVar).aun();
        } else if (cVar instanceof w) {
            aun = (w) cVar;
        } else {
            aun = null;
        }
        if (aun == null) {
            ab.e("MicroMsg.JsApiShowShareActionSheet", "fail, page view is null");
            cVar.M(i, j("fail:page don't exist", null));
            AppMethodBeat.o(133645);
            return;
        }
        ab.i("MicroMsg.JsApiShowShareActionSheet", "weishi show share action sheet");
        aun.aJT();
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(133645);
    }
}
