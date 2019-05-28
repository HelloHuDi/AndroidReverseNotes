package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.modelappbrand.t;
import com.tencent.mm.plugin.appbrand.dynamic.e;
import com.tencent.mm.plugin.appbrand.dynamic.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.json.JSONObject;

public final class i extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    static class a implements com.tencent.mm.ipcinvoker.a<b, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(10847);
            b bVar = (b) obj;
            final Bundle bundle = new Bundle();
            View zS = e.azz().zS(bVar.id);
            if (zS instanceof h) {
                ((h) zS).a(bVar.url, new t() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.i(10846);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        cVar.ao(bundle);
                        AppMethodBeat.o(10846);
                    }
                });
                AppMethodBeat.o(10847);
                return;
            }
            ab.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "openApp failed, view is not a instance of DynamicPageAccessible.(%s)", bVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            cVar.ao(bundle);
            AppMethodBeat.o(10847);
        }
    }

    public static class b implements f {
        String id;
        String url;

        public final void e(Parcel parcel) {
            AppMethodBeat.i(10848);
            parcel.writeString(this.id);
            parcel.writeString(this.url);
            AppMethodBeat.o(10848);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(10849);
            this.id = parcel.readString();
            this.url = parcel.readString();
            AppMethodBeat.o(10849);
        }
    }

    public i() {
        super("openApp", ErrorCode.TEST_THROWABLE_IS_NULL);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10850);
        com.tencent.mm.model.v.b Qy = aVar.Qy();
        b bVar = new b();
        bVar.id = Qy.getString("__page_view_id", "");
        bVar.url = jSONObject.optString("url", "");
        XIPCInvoker.a(Qy.getString("__process_name", ah.getProcessName()), bVar, a.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.i(10845);
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
                aVar2.au(i.this.a(z, str, bundle));
                AppMethodBeat.o(10845);
            }
        });
        AppMethodBeat.o(10850);
    }
}
