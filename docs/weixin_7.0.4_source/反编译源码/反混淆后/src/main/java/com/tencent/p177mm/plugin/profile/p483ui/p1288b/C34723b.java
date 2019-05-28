package com.tencent.p177mm.plugin.profile.p483ui.p1288b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.profile.ui.b.b */
public final class C34723b implements C4937b {
    private WeakReference<C4937b> bSI;

    public C34723b(C4937b c4937b) {
        AppMethodBeat.m2504i(23962);
        this.bSI = new WeakReference(c4937b);
        AppMethodBeat.m2505o(23962);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23963);
        if (this.bSI.get() != null) {
            ((C4937b) this.bSI.get()).mo10136a(i, c7298n, obj);
        }
        AppMethodBeat.m2505o(23963);
    }
}
