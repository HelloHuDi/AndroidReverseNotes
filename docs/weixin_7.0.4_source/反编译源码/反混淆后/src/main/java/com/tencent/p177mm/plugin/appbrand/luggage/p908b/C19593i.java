package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import android.content.Context;
import com.tencent.luggage.p1433c.p1434a.C31256a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C38571j;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C6789b;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C7498d;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.i */
public final class C19593i implements C31256a {
    /* renamed from: av */
    public final C38571j mo34802av(Context context) {
        AppMethodBeat.m2504i(132102);
        C7498d c7498d = new C7498d(context);
        c7498d.setCancelable(false);
        AppMethodBeat.m2505o(132102);
        return c7498d;
    }

    /* renamed from: a */
    public final void mo34801a(C38571j c38571j) {
        AppMethodBeat.m2504i(132103);
        if (c38571j instanceof C6789b) {
            ((C6789b) c38571j).dismiss();
        }
        AppMethodBeat.m2505o(132103);
    }
}
