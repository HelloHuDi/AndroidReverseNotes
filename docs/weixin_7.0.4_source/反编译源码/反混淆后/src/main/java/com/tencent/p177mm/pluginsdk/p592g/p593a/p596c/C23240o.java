package com.tencent.p177mm.pluginsdk.p592g.p593a.p596c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C6617c;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;

/* renamed from: com.tencent.mm.pluginsdk.g.a.c.o */
public final class C23240o implements C1671c, C6617c {
    public static final C23240o vfu = new C23240o();
    private final C1923n kzM = new C232411();
    private final C4884c vfv = new C232422();

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.o$1 */
    class C232411 extends C1924a {
        C232411() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(79603);
            C30046p.dix();
            AppMethodBeat.m2505o(79603);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.g.a.c.o$2 */
    class C232422 extends C4884c<C6504k> {
        C232422() {
            AppMethodBeat.m2504i(79604);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(79604);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(79605);
            if (!((C6504k) c4883b).csh.csi) {
                C30046p.dix();
            }
            AppMethodBeat.m2505o(79605);
            return false;
        }
    }

    public C23240o() {
        AppMethodBeat.m2504i(79606);
        AppMethodBeat.m2505o(79606);
    }

    static {
        AppMethodBeat.m2504i(79609);
        AppMethodBeat.m2505o(79609);
    }

    public final void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(79607);
        for (C4721g cYt : C46489r.diz()) {
            cYt.cYt();
        }
        C1720g.m3535RO().mo5187a(this.kzM);
        this.vfv.dnU();
        AppMethodBeat.m2505o(79607);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(79608);
        C1720g.m3535RO().mo5188b(this.kzM);
        this.vfv.dead();
        for (C4721g onAccountRelease : C46489r.diz()) {
            onAccountRelease.onAccountRelease();
        }
        AppMethodBeat.m2505o(79608);
    }
}
