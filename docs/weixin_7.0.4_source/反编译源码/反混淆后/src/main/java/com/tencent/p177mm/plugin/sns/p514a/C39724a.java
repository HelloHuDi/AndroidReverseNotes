package com.tencent.p177mm.plugin.sns.p514a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p514a.p1023a.C29027a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.a.a */
public final class C39724a implements C13356c {
    private Map<Integer, C29027a> qCV = new HashMap();

    public C39724a() {
        AppMethodBeat.m2504i(35688);
        AppMethodBeat.m2505o(35688);
    }

    /* renamed from: a */
    public final void mo62706a(C29027a c29027a) {
        AppMethodBeat.m2504i(35689);
        this.qCV.put(Integer.valueOf(c29027a.cez()), c29027a);
        AppMethodBeat.m2505o(35689);
    }

    /* renamed from: a */
    public final void mo25461a(int i, int i2, Object... objArr) {
        AppMethodBeat.m2504i(35690);
        C29027a c29027a = (C29027a) this.qCV.get(Integer.valueOf(i));
        if (c29027a == null) {
            C4990ab.m7421w("SnsAdReportService", "can not find %s implementation for kv %d", C29027a.class, Integer.valueOf(i));
            AppMethodBeat.m2505o(35690);
            return;
        }
        c29027a.mo25427e(i2, objArr);
        AppMethodBeat.m2505o(35690);
    }

    /* renamed from: e */
    public final void mo25462e(int i, Object... objArr) {
        AppMethodBeat.m2504i(35691);
        C29027a c29027a = (C29027a) this.qCV.get(Integer.valueOf(i));
        if (c29027a == null) {
            C4990ab.m7421w("SnsAdReportService", "can not find %s implementation for kv %d", C29027a.class, Integer.valueOf(i));
            AppMethodBeat.m2505o(35691);
            return;
        }
        c29027a.mo25428t(objArr);
        AppMethodBeat.m2505o(35691);
    }
}
