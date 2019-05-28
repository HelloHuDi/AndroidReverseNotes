package com.tencent.p177mm.plugin.sns.p514a.p1023a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.a.a.b */
public final class C13340b implements C29027a {
    public final int cez() {
        return 11855;
    }

    /* renamed from: t */
    public final void mo25428t(Object... objArr) {
        AppMethodBeat.m2504i(35692);
        mo25427e(0, objArr);
        AppMethodBeat.m2505o(35692);
    }

    /* renamed from: e */
    public final void mo25427e(int i, Object... objArr) {
        AppMethodBeat.m2504i(35693);
        switch (i) {
            case 0:
            case 1:
                C7060h.pYm.mo8381e(11855, objArr);
                AppMethodBeat.m2505o(35693);
                return;
            case 2:
                C7060h.pYm.mo8381e(14646, objArr);
                AppMethodBeat.m2505o(35693);
                return;
            default:
                C4990ab.m7413e("Kv_11855", "unknown type %d", Integer.valueOf(i));
                AppMethodBeat.m2505o(35693);
                return;
        }
    }
}
