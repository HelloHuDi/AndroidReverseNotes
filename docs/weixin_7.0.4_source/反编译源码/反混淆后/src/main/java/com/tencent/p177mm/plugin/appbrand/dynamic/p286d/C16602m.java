package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.modelappbrand.C26438t;
import com.tencent.p177mm.p652z.p1101b.C40953b.C16115a;
import com.tencent.p177mm.p652z.p653c.C36405a;
import com.tencent.p177mm.plugin.appbrand.dynamic.C10210e;
import com.tencent.p177mm.plugin.appbrand.dynamic.C2150h;
import com.tencent.p177mm.plugin.appbrand.dynamic.p286d.p888a.C10200a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.m */
public final class C16602m extends C10200a {

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.m$a */
    static class C16603a implements C37866a<Bundle, Bundle> {
        private C16603a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(10859);
            Bundle bundle = (Bundle) obj;
            final Bundle bundle2 = new Bundle();
            View zS = C10210e.azz().mo21627zS(bundle.getString("id"));
            if (zS instanceof C2150h) {
                ((C2150h) zS).mo5964a(FFmpegMetadataRetriever.METADATA_KEY_DATE, bundle.getString("data"), new C26438t() {
                    /* renamed from: b */
                    public final void mo5959b(boolean z, String str, Bundle bundle) {
                        AppMethodBeat.m2504i(10858);
                        bundle2.putBoolean("ret", z);
                        bundle2.putString("reason", str);
                        bundle2.putBundle("data", bundle);
                        c18507c.mo5960ao(bundle2);
                        AppMethodBeat.m2505o(10858);
                    }
                });
                AppMethodBeat.m2505o(10859);
                return;
            }
            C26340b.m41917i("MicroMsg.IPCInvoke_RequestSetWidgetSize", "showDatePickerView failed, view is not a instance of DynamicPageAccessible.(%s)", bundle.getString("id"));
            bundle2.putBoolean("ret", false);
            bundle2.putString("reason", "view is not a instance of DynamicPageAccessible");
            c18507c.mo5960ao(bundle2);
            AppMethodBeat.m2505o(10859);
        }
    }

    public C16602m() {
        super(C38339e.NAME, 457);
    }

    /* renamed from: a */
    public final void mo5955a(C36405a c36405a, JSONObject jSONObject, final C16115a<JSONObject> c16115a) {
        AppMethodBeat.m2504i(10860);
        C32800b Qy = c36405a.mo11733Qy();
        String string = Qy.getString("__page_view_id", "");
        Bundle bundle = new Bundle();
        bundle.putString("id", string);
        bundle.putString("data", jSONObject.toString());
        XIPCInvoker.m83629a(Qy.getString("__process_name", ((C6624h) C1720g.m3533RM().mo5224Rn()).eHT), bundle, C16603a.class, new C18507c<Bundle>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                Bundle bundle;
                String str;
                AppMethodBeat.m2504i(10857);
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
                c16115a.mo11732au(C16602m.this.mo57326a(z, str, bundle));
                AppMethodBeat.m2505o(10857);
            }
        });
        AppMethodBeat.m2505o(10860);
    }
}
