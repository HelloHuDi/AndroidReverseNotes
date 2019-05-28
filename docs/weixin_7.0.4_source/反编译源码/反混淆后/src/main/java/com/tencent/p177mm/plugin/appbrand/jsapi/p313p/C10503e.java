package com.tencent.p177mm.plugin.appbrand.jsapi.p313p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1378ce.C26006a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C10731b;
import com.tencent.p177mm.plugin.appbrand.p329s.C45688t.C45687a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.e */
public final class C10503e extends C19497u {
    public static final int CTRL_INDEX = 472;
    public static final String NAME = "enableDeviceOrientationChangeListening";
    private boolean hVI = false;
    protected C45688t hVJ;
    private C10731b hVK = new C105041();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.p.e$1 */
    class C105041 implements C10731b {
        C105041() {
        }

        /* renamed from: a */
        public final void mo22009a(C45687a c45687a, final C45687a c45687a2) {
            AppMethodBeat.m2504i(126379);
            C4990ab.m7416i("MicroMsg.JsApiEnableDeviceOrientation", "OrientationListener lastOrientation:" + c45687a.name() + "; newOrientation:" + c45687a2.name());
            C26006a.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(126378);
                    C45613h.m84193b(c45687a2);
                    AppMethodBeat.m2505o(126378);
                }
            }, 500);
            AppMethodBeat.m2505o(126379);
        }
    }

    public C10503e() {
        AppMethodBeat.m2504i(126380);
        AppMethodBeat.m2505o(126380);
    }

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(126381);
        if (jSONObject.optBoolean("enable", false)) {
            C45613h.m84194s(c2241c);
            if (!this.hVI) {
                this.hVJ = new C45688t(c2241c.getContext(), this.hVK);
                this.hVJ.enable();
                this.hVI = true;
            }
        } else {
            C45613h.m84195t(c2241c);
            if (this.hVI) {
                this.hVJ.disable();
                this.hVJ = null;
                this.hVI = false;
            }
        }
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(126381);
        return j;
    }
}
