package com.tencent.p177mm.plugin.appbrand.appusage.p280a;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¨\u0006\u0004"}, dWq = {"runOnWorkThread", "", "action", "Lkotlin/Function0;", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.e */
public final class C10113e {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appusage.a.e$a */
    static final class C10112a implements Runnable {
        final /* synthetic */ C31214a hbA;

        C10112a(C31214a c31214a) {
            this.hbA = c31214a;
        }

        public final void run() {
            AppMethodBeat.m2504i(134593);
            this.hbA.invoke();
            AppMethodBeat.m2505o(134593);
        }
    }

    /* renamed from: d */
    public static final void m17715d(C31214a<C37091y> c31214a) {
        AppMethodBeat.m2504i(134594);
        C25052j.m39376p(c31214a, NativeProtocol.WEB_DIALOG_ACTION);
        C45673m.aNS().mo10302aa(new C10112a(c31214a));
        AppMethodBeat.m2505o(134594);
    }
}
