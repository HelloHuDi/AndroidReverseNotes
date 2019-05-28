package com.tencent.p177mm.plugin.account.security.p880a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C18288hy;
import com.tencent.p177mm.p230g.p231a.C32647tt;
import com.tencent.p177mm.p230g.p231a.C6494hz;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.account.security.a.g */
public class C45501g implements C1816at {
    private static HashMap<Integer, C1366d> gzk;
    private C18849e gzj;
    private C4884c gzl = new C188502();
    private C4884c gzm = new C266063();
    private C4884c gzn = new C99094();

    /* renamed from: com.tencent.mm.plugin.account.security.a.g$4 */
    class C99094 extends C4884c<C6494hz> {
        C99094() {
            AppMethodBeat.m2504i(69850);
            this.xxI = C6494hz.class.getName().hashCode();
            AppMethodBeat.m2505o(69850);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(69851);
            ((C6494hz) c4883b).cCV.cCW = C38042f.aqE();
            AppMethodBeat.m2505o(69851);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.a.g$2 */
    class C188502 extends C4884c<C32647tt> {
        C188502() {
            super(0);
            AppMethodBeat.m2504i(69845);
            this.xxI = C32647tt.class.getName().hashCode();
            AppMethodBeat.m2505o(69845);
        }

        /* renamed from: a */
        private static boolean m29443a(C32647tt c32647tt) {
            AppMethodBeat.m2504i(69846);
            C38042f.m64374n(c32647tt.cPS.cPT, c32647tt.cPS.cPU);
            AppMethodBeat.m2505o(69846);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.a.g$3 */
    class C266063 extends C4884c<C18288hy> {
        C266063() {
            AppMethodBeat.m2504i(69848);
            this.xxI = C18288hy.class.getName().hashCode();
            AppMethodBeat.m2505o(69848);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(69849);
            C18288hy c18288hy = (C18288hy) c4883b;
            c18288hy.cCT.cCU = C38042f.m64373cz(c18288hy.cCS.context);
            AppMethodBeat.m2505o(69849);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.security.a.g$1 */
    static class C329831 implements C1366d {
        C329831() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C18849e.fnj;
        }
    }

    public C45501g() {
        AppMethodBeat.m2504i(69852);
        AppMethodBeat.m2505o(69852);
    }

    private static synchronized C45501g aqF() {
        C45501g c45501g;
        synchronized (C45501g.class) {
            AppMethodBeat.m2504i(69853);
            c45501g = (C45501g) C7485q.m12925Y(C45501g.class);
            AppMethodBeat.m2505o(69853);
        }
        return c45501g;
    }

    public static C18849e aqG() {
        AppMethodBeat.m2504i(69854);
        C1720g.m3534RN().mo5159QU();
        if (C45501g.aqF().gzj == null) {
            C45501g.aqF().gzj = new C18849e(C1720g.m3536RP().eJN);
        }
        C18849e c18849e = C45501g.aqF().gzj;
        AppMethodBeat.m2505o(69854);
        return c18849e;
    }

    static {
        AppMethodBeat.m2504i(69857);
        HashMap hashMap = new HashMap();
        gzk = hashMap;
        hashMap.put(Integer.valueOf("SAFE_DEVICE_INFO_TABLE".hashCode()), new C329831());
        AppMethodBeat.m2505o(69857);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return gzk;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(69855);
        C4879a.xxA.mo10052c(this.gzl);
        C4879a.xxA.mo10052c(this.gzm);
        C4879a.xxA.mo10052c(this.gzn);
        AppMethodBeat.m2505o(69855);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(69856);
        C4879a.xxA.mo10053d(this.gzl);
        C4879a.xxA.mo10053d(this.gzm);
        C4879a.xxA.mo10053d(this.gzn);
        AppMethodBeat.m2505o(69856);
    }
}
