package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C37992i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7641e;

/* renamed from: com.tencent.mm.plugin.aa.a.g */
public final class C1955g implements C24135b<C32896f> {
    protected C32896f glI;
    public final C1956a glJ;

    /* renamed from: com.tencent.mm.plugin.aa.a.g$a */
    public class C1956a implements C7368e<C7583c<String, String>, C7641e<String, Long, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40606);
            C7641e c7641e = (C7641e) obj;
            C32896f c32896f = C1955g.this.glI;
            String str = (String) c7641e.get(0);
            long longValue = ((Long) c7641e.get(1)).longValue();
            int intValue = ((Integer) c7641e.get(2)).intValue();
            String str2 = (String) c7641e.get(3);
            if (c32896f.glH) {
                C4990ab.m7412e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                C1207m c37992i = new C37992i(str, longValue, intValue, str2);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c37992i, 0);
                c32896f.glt = C5698f.dMo();
                c32896f.glH = true;
            }
            AppMethodBeat.m2505o(40606);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C1955g() {
        this(new C32896f());
        AppMethodBeat.m2504i(40607);
        AppMethodBeat.m2505o(40607);
    }

    private C1955g(C32896f c32896f) {
        AppMethodBeat.m2504i(40608);
        this.glJ = new C1956a();
        this.glI = c32896f;
        AppMethodBeat.m2505o(40608);
    }

    public final C32896f aol() {
        return this.glI;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glI;
    }
}
