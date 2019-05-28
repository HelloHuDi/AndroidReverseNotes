package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {
    private static String hmI = "com.tencent.mm:tools";

    interface a {
        void l(Bundle bundle);
    }

    static class b implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private static final String[] hmL = new String[]{"scope.userLocation"};

        private b() {
        }

        static /* synthetic */ void b(c cVar, boolean z, String str) {
            AppMethodBeat.i(10823);
            a(cVar, z, str);
            AppMethodBeat.o(10823);
        }

        private static void a(c<Bundle> cVar, boolean z, String str) {
            AppMethodBeat.i(10821);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ret", z);
            bundle.putString("reason", str);
            cVar.ao(bundle);
            AppMethodBeat.o(10821);
        }

        static /* synthetic */ String Ae(String str) {
            return str != null ? str : "";
        }
    }

    public a() {
        super("authorize", 419);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10827);
        com.tencent.mm.model.v.b Qy = aVar.Qy();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", Qy.getString("__page_app_id", ""));
            bundle.putString("widgetId", Qy.getString("__page_view_id", ""));
            XIPCInvoker.a(Qy.getString("__process_name", hmI), bundle, b.class, new c<Bundle>() {
                public final /* synthetic */ void ao(Object obj) {
                    Bundle bundle;
                    String str;
                    AppMethodBeat.i(10815);
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
                    aVar2.au(a.this.a(z, str, bundle));
                    AppMethodBeat.o(10815);
                }
            });
            AppMethodBeat.o(10827);
        } catch (Exception e) {
            ab.e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", e.getMessage());
            AppMethodBeat.o(10827);
        }
    }
}
