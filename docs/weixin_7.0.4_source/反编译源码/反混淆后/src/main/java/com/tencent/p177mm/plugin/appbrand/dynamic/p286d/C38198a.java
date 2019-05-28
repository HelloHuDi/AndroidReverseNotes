package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a */
public final class C38198a extends C10200a {
    private static String hmI = "com.tencent.mm:tools";

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a$a */
    interface C33149a {
        /* renamed from: l */
        void mo5950l(Bundle bundle);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a$b */
    static class C33150b implements C37866a<Bundle, Bundle> {
        private static final String[] hmL = new String[]{"scope.userLocation"};

        /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.a$b$3 */
        class C101993 implements C26438t {
            C101993() {
            }

            /* renamed from: b */
            public final void mo5959b(boolean z, String str, Bundle bundle) {
            }
        }

        private C33150b() {
        }

        /* renamed from: b */
        static /* synthetic */ void m54198b(C18507c c18507c, boolean z, String str) {
            AppMethodBeat.m2504i(10823);
            C33150b.m54194a(c18507c, z, str);
            AppMethodBeat.m2505o(10823);
        }

        /* renamed from: a */
        private static void m54194a(C18507c<Bundle> c18507c, boolean z, String str) {
            AppMethodBeat.m2504i(10821);
            Bundle bundle = new Bundle();
            bundle.putBoolean("ret", z);
            bundle.putString("reason", str);
            c18507c.mo5960ao(bundle);
            AppMethodBeat.m2505o(10821);
        }

        /* renamed from: Ae */
        static /* synthetic */ String m54193Ae(String str) {
            return str != null ? str : "";
        }
    }

    public C38198a() {
        super("authorize", 419);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10827);
        C32800b Qy = c36405a.mo11733Qy();
        Bundle bundle = new Bundle();
        try {
            bundle.putString("scope", jSONObject.getString("scope"));
            bundle.putString("appId", Qy.getString("__page_app_id", ""));
            bundle.putString("widgetId", Qy.getString("__page_view_id", ""));
            XIPCInvoker.m83629a(Qy.getString("__process_name", hmI), bundle, C33150b.class, new C18507c<Bundle>() {
                /* renamed from: ao */
                public final /* synthetic */ void mo5960ao(Object obj) {
                    Bundle bundle;
                    String str;
                    AppMethodBeat.m2504i(10815);
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
                    c16115a.mo11732au(C38198a.this.mo57326a(z, str, bundle));
                    AppMethodBeat.m2505o(10815);
                }
            });
            AppMethodBeat.m2505o(10827);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.JsApiFunc_DoAuthroize", "JSON Exception[%s]", e.getMessage());
            AppMethodBeat.m2505o(10827);
        }
    }
}
