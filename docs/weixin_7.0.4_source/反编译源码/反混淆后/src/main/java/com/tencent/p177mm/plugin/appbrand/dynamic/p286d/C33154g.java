package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.C42136f;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45573as;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsReaderView;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.g */
public final class C33154g extends C10200a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.g$a */
    static class C2136a implements C42136f {
        String cMQ;
        /* renamed from: id */
        String f1247id;

        private C2136a() {
        }

        /* synthetic */ C2136a(byte b) {
            this();
        }

        /* renamed from: e */
        public final void mo5956e(Parcel parcel) {
            AppMethodBeat.m2504i(TbsReaderView.READER_CHANNEL_PDF_ID);
            parcel.writeString(this.f1247id);
            parcel.writeString(this.cMQ);
            AppMethodBeat.m2505o(TbsReaderView.READER_CHANNEL_PDF_ID);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(TbsReaderView.READER_CHANNEL_TXT_ID);
            this.f1247id = parcel.readString();
            this.cMQ = parcel.readString();
            AppMethodBeat.m2505o(TbsReaderView.READER_CHANNEL_TXT_ID);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.g$b */
    static class C2137b implements C37866a<C2136a, Bundle> {
        private C2137b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10837);
            C2136a c2136a = (C2136a) obj;
            final Bundle bundle = new Bundle();
            View zS = C10210e.azz().mo21627zS(c2136a.f1247id);
            if (zS instanceof C2150h) {
                ((C2150h) zS).mo5968b(c2136a.cMQ, new C26438t() {
                    /* renamed from: b */
                    public final void mo5959b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.m2504i(10836);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        c18507c.mo5960ao(bundle);
                        AppMethodBeat.m2505o(10836);
                    }
                });
                AppMethodBeat.m2505o(10837);
                return;
            }
            C4990ab.m7417i("MicroMsg.IPCInvoke_RequestMakePhoneCall", "makePhoneCall failed, view is not a instance of DynamicPageAccessible.(%s)", c2136a.f1247id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(10837);
        }
    }

    public C33154g() {
        super(C45573as.NAME, ErrorCode.TEST_THROWABLE_ISNOT_NULL);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10838);
        C32800b Qy = c36405a.mo11733Qy();
        C2136a c2136a = new C2136a();
        c2136a.f1247id = Qy.getString("__page_view_id", "");
        c2136a.cMQ = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.m83629a(Qy.getString("__process_name", C4996ah.getProcessName()), c2136a, C2137b.class, new C18507c<Bundle>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.m2504i(TbsReaderView.READER_CHANNEL_PPT_ID);
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
                c16115a.mo11732au(C33154g.this.mo57326a(z, str, bundle));
                AppMethodBeat.m2505o(TbsReaderView.READER_CHANNEL_PPT_ID);
            }
        });
        AppMethodBeat.m2505o(10838);
    }
}
