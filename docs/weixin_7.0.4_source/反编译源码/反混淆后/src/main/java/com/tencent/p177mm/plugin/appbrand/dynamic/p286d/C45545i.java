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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.i */
public final class C45545i extends C10200a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.i$a */
    static class C41227a implements C37866a<C45544b, Bundle> {
        private C41227a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10847);
            C45544b c45544b = (C45544b) obj;
            final Bundle bundle = new Bundle();
            View zS = C10210e.azz().mo21627zS(c45544b.f17882id);
            if (zS instanceof C2150h) {
                ((C2150h) zS).mo5963a(c45544b.url, new C26438t() {
                    /* renamed from: b */
                    public final void mo5959b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.m2504i(10846);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        c18507c.mo5960ao(bundle);
                        AppMethodBeat.m2505o(10846);
                    }
                });
                AppMethodBeat.m2505o(10847);
                return;
            }
            C4990ab.m7417i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "openApp failed, view is not a instance of DynamicPageAccessible.(%s)", c45544b.f17882id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(10847);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.i$b */
    public static class C45544b implements C42136f {
        /* renamed from: id */
        String f17882id;
        String url;

        /* renamed from: e */
        public final void mo5956e(Parcel parcel) {
            AppMethodBeat.m2504i(10848);
            parcel.writeString(this.f17882id);
            parcel.writeString(this.url);
            AppMethodBeat.m2505o(10848);
        }

        public final void readFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(10849);
            this.f17882id = parcel.readString();
            this.url = parcel.readString();
            AppMethodBeat.m2505o(10849);
        }
    }

    public C45545i() {
        super("openApp", ErrorCode.TEST_THROWABLE_IS_NULL);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10850);
        C32800b Qy = c36405a.mo11733Qy();
        C45544b c45544b = new C45544b();
        c45544b.f17882id = Qy.getString("__page_view_id", "");
        c45544b.url = jSONObject.optString("url", "");
        XIPCInvoker.m83629a(Qy.getString("__process_name", C4996ah.getProcessName()), c45544b, C41227a.class, new C18507c<Bundle>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.m2504i(10845);
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
                c16115a.mo11732au(C45545i.this.mo57326a(z, str, bundle));
                AppMethodBeat.m2505o(10845);
            }
        });
        AppMethodBeat.m2505o(10850);
    }
}
