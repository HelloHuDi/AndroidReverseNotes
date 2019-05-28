package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.C19208a.C19209a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.l */
public final class C2140l extends C10200a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.l$a */
    static class C2141a implements C37866a<C19209a, Bundle> {
        private C2141a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10855);
            C19209a c19209a = (C19209a) obj;
            final Bundle bundle = new Bundle();
            View zS = C10210e.azz().mo21627zS(c19209a.f4349id);
            if (zS instanceof C2150h) {
                ((C2150h) zS).mo5967b(c19209a.height, new C26438t() {
                    /* renamed from: b */
                    public final void mo5959b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.m2504i(10854);
                        bundle.putBoolean("ret", z);
                        bundle.putString("reason", str);
                        bundle.putBundle("data", bundle);
                        c18507c.mo5960ao(bundle);
                        AppMethodBeat.m2505o(10854);
                    }
                });
                AppMethodBeat.m2505o(10855);
                return;
            }
            C4990ab.m7417i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "drawCanvas failed, view is not a instance of DynamicPageAccessible.(%s)", c19209a.f4349id);
            bundle.putBoolean("ret", false);
            bundle.putString("reason", "view is not a instance of DynamicPageAccessible");
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(10855);
        }
    }

    public C2140l(int i) {
        super("setWidgetSize", i);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10856);
        C32800b Qy = c36405a.mo11733Qy();
        C19209a c19209a = new C19209a();
        c19209a.f4349id = Qy.getString("__page_view_id", "");
        c19209a.width = jSONObject.optInt("width", Qy.getInt("__page_view_width", 0));
        c19209a.height = jSONObject.optInt("height", Qy.getInt("__page_view_height", 0));
        XIPCInvoker.m83629a(Qy.getString("__process_name", C4996ah.getProcessName()), c19209a, C2141a.class, new C18507c<Bundle>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.m2504i(10853);
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
                c16115a.mo11732au(C2140l.this.mo57326a(z, str, bundle));
                AppMethodBeat.m2505o(10853);
            }
        });
        AppMethodBeat.m2505o(10856);
    }
}
