package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

public final class m extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(10859);
            Bundle bundle = (Bundle) obj;
            final Bundle bundle2 = new Bundle();
            View zS = e.azz().zS(bundle.getString("id"));
            if (zS instanceof h) {
                ((h) zS).a(FFmpegMetadataRetriever.METADATA_KEY_DATE, bundle.getString("data"), new t() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.i(10858);
                        bundle2.putBoolean("ret", z);
                        bundle2.putString("reason", str);
                        bundle2.putBundle("data", bundle);
                        cVar.ao(bundle2);
                        AppMethodBeat.o(10858);
                    }
                });
                AppMethodBeat.o(10859);
                return;
            }
            b.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "showDatePickerView failed, view is not a instance of DynamicPageAccessible.(%s)", bundle.getString("id"));
            bundle2.putBoolean("ret", false);
            bundle2.putString("reason", "view is not a instance of DynamicPageAccessible");
            cVar.ao(bundle2);
            AppMethodBeat.o(10859);
        }
    }

    public m() {
        super(com.tencent.mm.plugin.appbrand.jsapi.m.e.NAME, 457);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10860);
        v.b Qy = aVar.Qy();
        String string = Qy.getString("__page_view_id", "");
        Bundle bundle = new Bundle();
        bundle.putString("id", string);
        bundle.putString("data", jSONObject.toString());
        XIPCInvoker.a(Qy.getString("__process_name", ((com.tencent.mm.kernel.b.h) g.RM().Rn()).eHT), bundle, a.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.i(10857);
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
                aVar2.au(m.this.a(z, str, bundle));
                AppMethodBeat.o(10857);
            }
        });
        AppMethodBeat.o(10860);
    }
}
