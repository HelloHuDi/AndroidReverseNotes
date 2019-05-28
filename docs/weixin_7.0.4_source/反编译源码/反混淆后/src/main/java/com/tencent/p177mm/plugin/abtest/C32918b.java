package com.tencent.p177mm.plugin.abtest;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.p1207a.C26407g;
import com.tencent.p177mm.model.p1207a.C42182a;
import com.tencent.p177mm.model.p1207a.C45436d;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;

/* renamed from: com.tencent.mm.plugin.abtest.b */
public final class C32918b extends C7485q implements C9562c {
    private static C32918b gpL;
    private C45436d gpM = new C45436d();
    private C42182a gpN = new C42182a();

    private C32918b() {
        super(C26407g.class);
        AppMethodBeat.m2504i(118188);
        AppMethodBeat.m2505o(118188);
    }

    public static synchronized C32918b aoM() {
        C32918b c32918b;
        synchronized (C32918b.class) {
            AppMethodBeat.m2504i(118189);
            if (gpL == null) {
                gpL = new C32918b();
            }
            c32918b = gpL;
            AppMethodBeat.m2505o(118189);
        }
        return c32918b;
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(118190);
        super.onAccountInitialized(c1705c);
        C1200d.m2636a(Integer.valueOf(-1879048184), this.gpM);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14901a("abtest", this.gpN);
        AppMethodBeat.m2505o(118190);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(118191);
        super.onAccountRelease();
        C1200d.m2636a(Integer.valueOf(-1879048184), this.gpM);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14904b("abtest", this.gpN);
        AppMethodBeat.m2505o(118191);
    }
}
