package com.tencent.p177mm.p835bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C6465cd;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.bd.b */
public final class C17978b {
    private static final C17978b fNg = new C17978b();
    public long fNf;

    /* renamed from: com.tencent.mm.bd.b$1 */
    class C90711 extends C4884c<C6465cd> {
        C90711() {
            AppMethodBeat.m2504i(1004);
            this.xxI = C6465cd.class.getName().hashCode();
            AppMethodBeat.m2505o(1004);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(1005);
            if (C1720g.m3531RK()) {
                C17978b.this.fNf = C1853r.m3823YE();
            }
            AppMethodBeat.m2505o(1005);
            return true;
        }
    }

    static {
        AppMethodBeat.m2504i(1007);
        AppMethodBeat.m2505o(1007);
    }

    public C17978b() {
        AppMethodBeat.m2504i(1006);
        if (C1720g.m3531RK()) {
            this.fNf = C1853r.m3823YE();
            AppMethodBeat.m2505o(1006);
            return;
        }
        C4879a.xxA.mo10051b(new C90711());
        AppMethodBeat.m2505o(1006);
    }

    public static C17978b aiC() {
        return fNg;
    }
}
