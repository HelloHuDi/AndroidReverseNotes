package com.tencent.p177mm.plugin.appbrand.p322m.p324d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c;
import com.tencent.p177mm.plugin.appbrand.p281b.C10136c.C10137a;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e;
import com.tencent.p177mm.plugin.appbrand.p322m.p1228a.C42627e.C38438a;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.m.d.c */
public final class C2387c extends C42627e {
    private C10137a iqn;

    /* renamed from: com.tencent.mm.plugin.appbrand.m.d.c$1 */
    class C23881 implements C10137a {
        C23881() {
        }

        /* renamed from: a */
        public final void mo6006a(String str, C45524b c45524b) {
            AppMethodBeat.m2504i(102210);
            HashMap hashMap = new HashMap();
            hashMap.put("state", Integer.valueOf(c45524b.ordinal()));
            C2387c.this.mo68067D(hashMap);
            AppMethodBeat.m2505o(102210);
        }
    }

    public C2387c(C38438a c38438a, C38492q c38492q) {
        super(c38438a, c38492q);
    }

    public final void aIV() {
        AppMethodBeat.m2504i(102211);
        this.iqn = new C23881();
        this.gMN.getRuntime().gNN.mo21486a(this.iqn);
        AppMethodBeat.m2505o(102211);
    }

    public final void removeListener() {
        AppMethodBeat.m2504i(102212);
        if (this.iqn == null) {
            AppMethodBeat.m2505o(102212);
        } else if (this.gMN.getRuntime() == null) {
            AppMethodBeat.m2505o(102212);
        } else {
            C10136c c10136c = this.gMN.getRuntime().gNN;
            if (c10136c == null) {
                AppMethodBeat.m2505o(102212);
                return;
            }
            c10136c.mo21488b(this.iqn);
            AppMethodBeat.m2505o(102212);
        }
    }

    public final int getType() {
        return 2;
    }
}
