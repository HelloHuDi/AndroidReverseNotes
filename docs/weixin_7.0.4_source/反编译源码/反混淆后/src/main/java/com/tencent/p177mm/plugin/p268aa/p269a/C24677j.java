package com.tencent.p177mm.plugin.p268aa.p269a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C18770e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.p177mm.vending.p644j.C7641e;

/* renamed from: com.tencent.mm.plugin.aa.a.j */
public final class C24677j implements C24135b<C26537i> {
    protected C26537i glL;
    public final C24678b glM;
    public final C18778a glN;

    /* renamed from: com.tencent.mm.plugin.aa.a.j$a */
    public class C18778a implements C7368e<Boolean, C7641e<String, Integer, String, Long>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40628);
            C7641e c7641e = (C7641e) obj;
            C26537i c26537i = C24677j.this.glL;
            String str = (String) c7641e.get(0);
            int intValue = ((Integer) c7641e.get(1)).intValue();
            String str2 = (String) c7641e.get(2);
            long longValue = ((Long) c7641e.get(3)).longValue();
            c26537i.fsC = C5698f.dMj();
            c26537i.cvx = longValue;
            if (C5046bo.isNullOrNil(str)) {
                c26537i.fsC.mo11582cR(Boolean.FALSE);
            } else {
                C1207m c18770e = new C18770e(str, intValue, str2);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c18770e, 0);
                C4990ab.m7417i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                c26537i.fsC = C5698f.dMo();
            }
            AppMethodBeat.m2505o(40628);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.a.j$b */
    public class C24678b implements C7368e<Boolean, C7625d<String, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40629);
            C7625d c7625d = (C7625d) obj;
            C26537i c26537i = C24677j.this.glL;
            String str = (String) c7625d.get(0);
            int intValue = ((Integer) c7625d.get(1)).intValue();
            String str2 = (String) c7625d.get(2);
            c26537i.fsC = C5698f.dMj();
            if (C5046bo.isNullOrNil(str)) {
                c26537i.fsC.mo11582cR(Boolean.FALSE);
            } else {
                C1207m c18770e = new C18770e(str, intValue, str2);
                C1720g.m3537RQ();
                C1720g.m3535RO().eJo.mo14541a(c18770e, 0);
                C4990ab.m7417i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                c26537i.fsC = C5698f.dMo();
            }
            AppMethodBeat.m2505o(40629);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.LOGIC";
        }
    }

    public C24677j() {
        this(new C26537i());
        AppMethodBeat.m2504i(40630);
        AppMethodBeat.m2505o(40630);
    }

    private C24677j(C26537i c26537i) {
        AppMethodBeat.m2504i(40631);
        this.glM = new C24678b();
        this.glN = new C18778a();
        this.glL = c26537i;
        AppMethodBeat.m2505o(40631);
    }

    public final C26537i aoo() {
        return this.glL;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glL;
    }
}
