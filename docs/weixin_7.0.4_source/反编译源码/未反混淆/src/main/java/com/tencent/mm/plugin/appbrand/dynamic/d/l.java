package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.model.v.b;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public final class l extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    static class a implements com.tencent.mm.ipcinvoker.a<com.tencent.mm.plugin.appbrand.dynamic.widget.a.a, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(10855);
            com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar = (com.tencent.mm.plugin.appbrand.dynamic.widget.a.a) obj;
            final Bundle bundle = new Bundle();
            View zS = e.azz().zS(aVar.id);
            if (zS instanceof h) {
                ((h) zS).b(aVar.height, new t() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.i(10854);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        cVar.ao(bundle);
                        AppMethodBeat.o(10854);
                    }
                });
                AppMethodBeat.o(10855);
                return;
            }
            ab.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            cVar.ao(bundle);
            AppMethodBeat.o(10855);
        }
    }

    public l(int i) {
        super("setWidgetSize", i);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10856);
        b Qy = aVar.Qy();
        com.tencent.mm.plugin.appbrand.dynamic.widget.a.a aVar3 = new com.tencent.mm.plugin.appbrand.dynamic.widget.a.a();
        aVar3.id = Qy.getString("__page_view_id", "");
        aVar3.width = jSONObject.optInt("width", Qy.getInt("__page_view_width", 0));
        aVar3.height = jSONObject.optInt("height", Qy.getInt("__page_view_height", 0));
        XIPCInvoker.a(Qy.getString("__process_name", ah.getProcessName()), aVar3, a.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.i(10853);
                Bundle bundle2 = (Bundle) obj;
                boolean z = false;
                if (bundle2 != null) {
                    z = bundle2.getBoolean("ret");
                    String string = bundle2.getString("reason");
                    bundle = bundle2.getBundle("data");
                    str = string;
                } else {
                    bundle = null;
                    str = null;
                }
                aVar2.au(l.this.a(z, str, bundle));
                AppMethodBeat.o(10853);
            }
        });
        AppMethodBeat.o(10856);
    }
}
