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
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsReaderView;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    static class a implements f {
        String cMQ;
        String id;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void e(Parcel parcel) {
            AppMethodBeat.i(TbsReaderView.READER_CHANNEL_PDF_ID);
            parcel.writeString(this.id);
            parcel.writeString(this.cMQ);
            AppMethodBeat.o(TbsReaderView.READER_CHANNEL_PDF_ID);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.i(TbsReaderView.READER_CHANNEL_TXT_ID);
            this.id = parcel.readString();
            this.cMQ = parcel.readString();
            AppMethodBeat.o(TbsReaderView.READER_CHANNEL_TXT_ID);
        }
    }

    static class b implements com.tencent.mm.ipcinvoker.a<a, Bundle> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(10837);
            a aVar = (a) obj;
            final Bundle bundle = new Bundle();
            View zS = e.azz().zS(aVar.id);
            if (zS instanceof h) {
                ((h) zS).b(aVar.cMQ, new t() {
                    public final void b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.i(10836);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        cVar.ao(bundle);
                        AppMethodBeat.o(10836);
                    }
                });
                AppMethodBeat.o(10837);
                return;
            }
            ab.i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", aVar.id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            cVar.ao(bundle);
            AppMethodBeat.o(10837);
        }
    }

    public g() {
        super(as.NAME, ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    public final void a(com.tencent.mm.z.c.a aVar, JSONObject jSONObject, final com.tencent.mm.z.b.b.a<JSONObject> aVar2) {
        AppMethodBeat.i(10838);
        com.tencent.mm.model.v.b Qy = aVar.Qy();
        a aVar3 = new a();
        aVar3.id = Qy.getString("__page_view_id", "");
        aVar3.cMQ = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.a(Qy.getString("__process_name", ah.getProcessName()), aVar3, b.class, new c<Bundle>() {
            public final /* synthetic */ void ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.i(TbsReaderView.READER_CHANNEL_PPT_ID);
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
                aVar2.au(g.this.a(z, str, bundle));
                AppMethodBeat.o(TbsReaderView.READER_CHANNEL_PPT_ID);
            }
        });
        AppMethodBeat.o(10838);
    }
}
