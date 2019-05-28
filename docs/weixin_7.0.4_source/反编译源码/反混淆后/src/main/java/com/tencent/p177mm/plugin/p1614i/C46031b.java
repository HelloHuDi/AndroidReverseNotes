package com.tencent.p177mm.plugin.p1614i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.plugin.p991m.p1488a.C34506a;
import com.tencent.p177mm.storage.C7571bh;

/* renamed from: com.tencent.mm.plugin.i.b */
public final class C46031b extends C7485q {
    private static C46031b nuE;

    private C46031b() {
        super(C32291o.class);
    }

    public static synchronized C46031b bGD() {
        C46031b c46031b;
        synchronized (C46031b.class) {
            AppMethodBeat.m2504i(79095);
            if (nuE == null) {
                nuE = new C46031b();
            }
            c46031b = nuE;
            AppMethodBeat.m2505o(79095);
        }
        return c46031b;
    }

    /* renamed from: XT */
    public static C7571bh m85613XT() {
        AppMethodBeat.m2504i(79096);
        C1720g.m3534RN().mo5159QU();
        C7571bh XT = ((C34506a) C1720g.m3528K(C34506a.class)).mo24388XT();
        AppMethodBeat.m2505o(79096);
        return XT;
    }
}
