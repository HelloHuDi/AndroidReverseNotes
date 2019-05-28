package com.tencent.p177mm.plugin.p268aa.p269a.p717c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p268aa.p269a.p1215a.C18768c;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C26536a.C67021;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.p637c.C24135b;
import com.tencent.p177mm.vending.p641g.C5688b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p641g.C7361c;
import com.tencent.p177mm.vending.p642h.C7368e;
import com.tencent.p177mm.vending.p644j.C7583c;
import com.tencent.p177mm.vending.p644j.C7625d;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.a.c.b */
public class C24676b implements C24135b<C26536a> {
    protected C26536a gmC;
    public final C18772a gmD;

    /* renamed from: com.tencent.mm.plugin.aa.a.c.b$a */
    public class C18772a implements C7368e<C7625d<List, String, Boolean>, C7583c<Boolean, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            int i;
            C18768c c18768c;
            int i2 = 20;
            AppMethodBeat.m2504i(40678);
            C7583c c7583c = (C7583c) obj;
            C26536a c26536a = C24676b.this.gmC;
            boolean booleanValue = ((Boolean) c7583c.get(0)).booleanValue();
            int intValue = ((Integer) c7583c.get(1)).intValue();
            if (!booleanValue || c26536a.gmt <= 0) {
                i = 20;
            } else {
                i = c26536a.gmt;
                c26536a.gmt = 0;
                c26536a.gmy = false;
            }
            if (c26536a.gmz == intValue) {
                i2 = i;
            }
            c26536a.gmz = intValue;
            C4990ab.m7417i("MicroMsg.AAQueryListInteractor", "getNextAAQueryPage, currentPageOffset: %s, force: %s", Integer.valueOf(c26536a.gmt), Boolean.valueOf(booleanValue));
            C5688b dMj = C5698f.dMj();
            dMj.dMi();
            if (c26536a.gmy) {
                c18768c = new C18768c(i2, c26536a.gmt, intValue, c26536a.gmu, c26536a.gmv, c26536a.gmw, c26536a.gmx);
            } else {
                c18768c = new C18768c(i2, c26536a.gmt, intValue);
            }
            c18768c.acy().mo60492h(new C67021(dMj));
            AppMethodBeat.m2505o(40678);
            return null;
        }

        /* renamed from: HZ */
        public final String mo4644HZ() {
            return "Vending.ANY";
        }

        /* renamed from: g */
        public final C7361c<C7625d<List, String, Boolean>> mo34042g(boolean z, int i) {
            AppMethodBeat.m2504i(40677);
            C7361c c = C5698f.m8551D(Boolean.valueOf(z), Integer.valueOf(i)).mo15892c(this);
            AppMethodBeat.m2505o(40677);
            return c;
        }
    }

    public C24676b() {
        this(new C26536a());
        AppMethodBeat.m2504i(40679);
        AppMethodBeat.m2505o(40679);
    }

    private C24676b(C26536a c26536a) {
        AppMethodBeat.m2504i(40680);
        this.gmD = new C18772a();
        this.gmC = c26536a;
        AppMethodBeat.m2505o(40680);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.gmC;
    }
}
