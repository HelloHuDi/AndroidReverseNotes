package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C45482j;
import com.tencent.p177mm.protocal.protobuf.C15389v;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7643f;

/* renamed from: com.tencent.mm.plugin.aa.a.c */
public final class C38002c implements C24135b<C32892b> {
    protected C32892b glu;
    public final C38003a glv;

    /* renamed from: com.tencent.mm.plugin.aa.a.c$a */
    public class C38003a implements C7368e<C15389v, C7643f<String, Integer, String, String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40595);
            C7643f c7643f = (C7643f) obj;
            C32892b c32892b = C38002c.this.glu;
            C1207m c45482j = new C45482j((String) c7643f.get(0), ((Integer) c7643f.get(1)).intValue(), (String) c7643f.get(2), (String) c7643f.get(3), ((Integer) c7643f.get(4)).intValue());
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c45482j, 0);
            c32892b.glt = C5698f.dMo();
            AppMethodBeat.m2505o(40595);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C38002c() {
        this(new C32892b());
        AppMethodBeat.m2504i(40596);
        AppMethodBeat.m2505o(40596);
    }

    private C38002c(C32892b c32892b) {
        AppMethodBeat.m2504i(40597);
        this.glv = new C38003a();
        this.glu = c32892b;
        AppMethodBeat.m2505o(40597);
    }

    public final C32892b aof() {
        return this.glu;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glu;
    }
}
