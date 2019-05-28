package com.tencent.p177mm.plugin.address.p718b.p1387a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.plugin.p984j.p985a.C43233a;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.address.b.a.a */
public final class C26684a {
    public C43233a gIF = new C43233a();

    public C26684a() {
        AppMethodBeat.m2504i(16719);
        AppMethodBeat.m2505o(16719);
    }

    /* renamed from: nd */
    public final C12328b mo44443nd(int i) {
        AppMethodBeat.m2504i(16720);
        Iterator it = this.gIF.nuG.iterator();
        while (it.hasNext()) {
            C12328b c12328b = (C12328b) it.next();
            if (c12328b.nuH == i) {
                AppMethodBeat.m2505o(16720);
                return c12328b;
            }
        }
        AppMethodBeat.m2505o(16720);
        return null;
    }
}
