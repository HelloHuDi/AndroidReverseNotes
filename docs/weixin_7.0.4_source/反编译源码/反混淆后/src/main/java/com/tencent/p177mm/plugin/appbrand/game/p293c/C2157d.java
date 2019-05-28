package com.tencent.p177mm.plugin.appbrand.game.p293c;

import com.tencent.magicbrush.p1173a.C37412c.C17837c;
import com.tencent.magicbrush.p1173a.C37412c.C37413b;
import com.tencent.magicbrush.p1173a.C45128b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.game.c.d */
public final class C2157d {

    /* renamed from: com.tencent.mm.plugin.appbrand.game.c.d$1 */
    static class C21581 implements C37413b {
        C21581() {
        }

        /* renamed from: v */
        public final void mo5985v(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130142);
            C4990ab.m7419v(str, str2, objArr);
            AppMethodBeat.m2505o(130142);
        }

        /* renamed from: d */
        public final void mo5982d(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130143);
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(130143);
        }

        /* renamed from: i */
        public final void mo5984i(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130144);
            C4990ab.m7417i(str, str2, objArr);
            AppMethodBeat.m2505o(130144);
        }

        /* renamed from: w */
        public final void mo5986w(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130145);
            C4990ab.m7421w(str, str2, objArr);
            AppMethodBeat.m2505o(130145);
        }

        /* renamed from: e */
        public final void mo5983e(String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130146);
            C4990ab.m7413e(str, str2, objArr);
            AppMethodBeat.m2505o(130146);
        }

        /* renamed from: a */
        public final void mo5981a(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.m2504i(130147);
            C4990ab.printErrStackTrace(str, th, str2, objArr);
            AppMethodBeat.m2505o(130147);
        }
    }

    static {
        AppMethodBeat.m2504i(130149);
        long yz = C5046bo.m7588yz();
        C45128b.m82948yB();
        long yz2 = C5046bo.m7588yz();
        C45128b.loadLibrary("gamelog_delegate");
        C4990ab.m7417i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush & gamelog_delegate cost = [%d]ms magicbrush cost [%d]ms", Long.valueOf(C5046bo.m7525az(yz)), Long.valueOf(yz2 - yz));
        AppMethodBeat.m2505o(130149);
    }

    public static void axy() {
        AppMethodBeat.m2504i(130148);
        C17837c.m27912a(new C21581());
        AppMethodBeat.m2505o(130148);
    }
}
