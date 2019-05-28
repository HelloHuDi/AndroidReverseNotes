package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.dynamic.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.b.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class b extends a {
    public b(int i) {
        super(e.NAME, i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, Bundle bundle, com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10828);
        c.bD(d.o(jSONObject), "before_jsapi_invoke");
        com.tencent.mm.model.v.b Qy = aVar.Qy();
        String string = Qy.getString("__page_view_id", null);
        String string2 = Qy.getString("__process_name", ah.getProcessName());
        int i = Qy.getInt("__draw_strategy", 0);
        if (com.tencent.mm.plugin.appbrand.dynamic.d.azy().zR(string) == null) {
            ab.w("MicroMsg.JsApiFunc_DrawCanvas", "get view by viewId(%s) return null.", string);
            aVar2.au(a(false, "got 'null' when get view by the given viewId", null));
            AppMethodBeat.o(10828);
            return;
        }
        com.tencent.mm.plugin.appbrand.dynamic.d.b.b bVar = new com.tencent.mm.plugin.appbrand.dynamic.d.b.b();
        bVar.a(string2, string, jSONObject, this, aVar2, com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(string, i), bundle != null ? bundle.getString("rawJsapiData") : System.currentTimeMillis());
        com.tencent.mm.plugin.appbrand.dynamic.d.b.a.bb(string, i).a(bVar);
        AppMethodBeat.o(10828);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
    }
}
