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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.json.JSONObject;

public final class h extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    static class a implements com.tencent.mm.ipcinvoker.a<b, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(10841);
            b bVar = (b) obj;
            final Bundle bundle = new Bundle();
            View zS = e.azz().zS(bVar.id);
            if (zS instanceof com.tencent.mm.plugin.appbrand.dynamic.h) {
                ((com.tencent.mm.plugin.appbrand.dynamic.h) zS).a(bVar.hmZ, bVar.cOS, bVar.hna, new t() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.i(10840);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        cVar.ao(bundle);
                        AppMethodBeat.o(10840);
                    }
                });
                AppMethodBeat.o(10841);
                return;
            }
            ab.i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "onTapCallback failed, view is not a instance of DynamicPageAccessible.(%s)", bVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            cVar.ao(bundle);
            AppMethodBeat.o(10841);
        }
    }

    public static class b implements f {
        String cOS;
        boolean hmZ;
        boolean hna;
        String id;

        public final void e(Parcel parcel) {
            int i;
            int i2 = 1;
            AppMethodBeat.i(10842);
            parcel.writeString(this.id);
            if (this.hmZ) {
                i = 1;
            } else {
                i = 0;
            }
            parcel.writeInt(i);
            parcel.writeString(this.cOS);
            if (!this.hna) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            AppMethodBeat.o(10842);
        }

        public final void readFromParcel(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(10843);
            this.id = parcel.readString();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.hmZ = z;
            this.cOS = parcel.readString();
            if (parcel.readInt() != 1) {
                z2 = false;
            }
            this.hna = z2;
            AppMethodBeat.o(10843);
        }
    }

    public h() {
        super("onTapCallback", ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10844);
        com.tencent.mm.model.v.b Qy = aVar.Qy();
        b bVar = new b();
        bVar.id = Qy.getString("__page_view_id", "");
        bVar.cOS = jSONObject.optString("eventId", "");
        bVar.hmZ = jSONObject.optBoolean("hasHandler");
        bVar.hna = jSONObject.optBoolean("res");
        XIPCInvoker.a(Qy.getString("__process_name", ah.getProcessName()), bVar, a.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.i(10839);
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
                aVar2.au(h.this.a(z, str, bundle));
                AppMethodBeat.o(10839);
            }
        });
        AppMethodBeat.o(10844);
    }
}
