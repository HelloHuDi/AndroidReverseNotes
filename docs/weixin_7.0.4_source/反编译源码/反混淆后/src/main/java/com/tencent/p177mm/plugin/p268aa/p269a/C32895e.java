package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C42260h;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;

/* renamed from: com.tencent.mm.plugin.aa.a.e */
public final class C32895e implements C24135b<C32894d> {
    protected C32894d glE;
    public final C18777a glF;

    /* renamed from: com.tencent.mm.plugin.aa.a.e$a */
    public class C18777a implements C7368e<Void, Void> {
        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40602);
            C32894d c32894d = C32895e.this.glE;
            C1207m c42260h = new C42260h();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c42260h, 0);
            c32894d.glt = C5698f.dMo();
            Void voidR = zXH;
            AppMethodBeat.m2505o(40602);
            return voidR;
        }
    }

    public C32895e() {
        this(new C32894d());
        AppMethodBeat.m2504i(40603);
        AppMethodBeat.m2505o(40603);
    }

    private C32895e(C32894d c32894d) {
        AppMethodBeat.m2504i(40604);
        this.glF = new C18777a();
        this.glE = c32894d;
        AppMethodBeat.m2505o(40604);
    }

    public final C32894d aok() {
        return this.glE;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glE;
    }
}
