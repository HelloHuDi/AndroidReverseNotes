package com.tencent.p177mm.plugin.appbrand.p322m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.p322m.p1229b.C19598a;
import com.tencent.p177mm.plugin.appbrand.p322m.p1229b.C42628b;
import com.tencent.p177mm.plugin.appbrand.p322m.p1229b.C42628b.C27192a;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C10616e;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C10616e.C2386a;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C33444d;
import com.tencent.p177mm.plugin.appbrand.p322m.p323c.C33444d.C27193a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.m.a */
public final class C10612a extends C19598a {
    private static Set<String> ipP;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.a$2 */
    static class C106132 implements C27193a {
        C106132() {
        }

        /* renamed from: M */
        public final void mo22136M(int i, int i2, int i3) {
            AppMethodBeat.m2504i(132323);
            C7060h.pYm.mo15419k((long) i, (long) i2, (long) i3);
            AppMethodBeat.m2505o(132323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.m.a$1 */
    static class C106141 implements C2386a {
        C106141() {
        }

        /* renamed from: X */
        public final void mo6286X(int i, String str) {
            AppMethodBeat.m2504i(132322);
            C7060h.pYm.mo8374X(i, str);
            AppMethodBeat.m2505o(132322);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.m.a$3 */
    static class C106153 implements C27192a {
        C106153() {
        }

        /* renamed from: a */
        public final void mo22137a(C6750i c6750i, JSONObject jSONObject) {
            AppMethodBeat.m2504i(132324);
            try {
                jSONObject.put("notSupport", C10612a.ipP.contains(C4995ag.m7428ck(c6750i.mAppId)));
                jSONObject.put("switchWebsocket", ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_nodejs_websocket_open, 0));
                jSONObject.put("switchFs", ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_nodejs_fs_open, 0));
                AppMethodBeat.m2505o(132324);
            } catch (JSONException e) {
                AppMethodBeat.m2505o(132324);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(132325);
        C10616e.iqg = new C106141();
        C33444d.iqf = new C106132();
        C42628b.m75491a(new C106153());
        HashSet hashSet = new HashSet();
        ipP = hashSet;
        hashSet.add(C4995ag.m7428ck("wxa51f55ab3b2655b9"));
        ipP.add(C4995ag.m7428ck("wx5b5555f4b7c7824b"));
        ipP.add(C4995ag.m7428ck("wx8c67c6eee918d4ea"));
        ipP.add(C4995ag.m7428ck("wx577c74fb940daaea"));
        ipP.add(C4995ag.m7428ck("wx7d9e9cbea92ce71f"));
        ipP.add(C4995ag.m7428ck("wx850d691fd02de8a1"));
        AppMethodBeat.m2505o(132325);
    }
}
