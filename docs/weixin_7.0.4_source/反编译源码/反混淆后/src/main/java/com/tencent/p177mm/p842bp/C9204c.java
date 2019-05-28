package com.tencent.p177mm.p842bp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.model.C7485q.C1852a;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.bp.c */
public final class C9204c {
    public static C23255n vwA;
    public static C23244m vwB;

    public static void aks(String str) {
        AppMethodBeat.m2504i(114682);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C25985d.m41461a(str, vwA, vwB);
        }
        AppMethodBeat.m2505o(114682);
    }

    /* renamed from: b */
    public static void m16715b(final String str, final C7485q c7485q) {
        AppMethodBeat.m2504i(114683);
        new C42148a() {
            public final void execute(C1681g c1681g) {
                AppMethodBeat.m2504i(114680);
                String str = str;
                C7485q c7485q = c7485q;
                C25985d.m41461a(str, C9204c.vwA, C9204c.vwB);
                if (c7485q == null) {
                    c7485q = new C7485q(C9204c.akt(str));
                }
                C7485q.m12927a("plugin.".concat(String.valueOf(str)), c7485q);
                AppMethodBeat.m2505o(114680);
            }
        }.alone();
        AppMethodBeat.m2505o(114683);
    }

    public static C1852a akt(final String str) {
        AppMethodBeat.m2504i(114684);
        C4990ab.m7417i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new C1852a() {
            public final C1816at createSubCore() {
                AppMethodBeat.m2504i(114681);
                C1816at akv = C25985d.akv(str);
                AppMethodBeat.m2505o(114681);
                return akv;
            }
        }, str);
        AppMethodBeat.m2505o(114684);
        return /* anonymous class already generated */;
    }
}
