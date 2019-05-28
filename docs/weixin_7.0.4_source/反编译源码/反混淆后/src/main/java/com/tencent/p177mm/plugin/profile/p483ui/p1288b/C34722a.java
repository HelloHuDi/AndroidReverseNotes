package com.tencent.p177mm.plugin.profile.p483ui.p1288b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p182ah.C41732d.C8915a;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.profile.ui.b.a */
public final class C34722a implements C8915a {
    private WeakReference<C8915a> bSI;

    public C34722a(C8915a c8915a) {
        AppMethodBeat.m2504i(23960);
        this.bSI = new WeakReference(c8915a);
        AppMethodBeat.m2505o(23960);
    }

    /* renamed from: qj */
    public final void mo20342qj(String str) {
        AppMethodBeat.m2504i(23961);
        if (this.bSI.get() != null) {
            ((C8915a) this.bSI.get()).mo20342qj(str);
        }
        AppMethodBeat.m2505o(23961);
    }
}
