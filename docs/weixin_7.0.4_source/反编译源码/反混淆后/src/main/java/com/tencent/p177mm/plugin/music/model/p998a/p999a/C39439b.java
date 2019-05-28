package com.tencent.p177mm.plugin.music.model.p998a.p999a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.p462e.C39435k;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.sdk.platformtools.C4995ag;

/* renamed from: com.tencent.mm.plugin.music.model.a.a.b */
public final class C39439b {
    /* renamed from: Tm */
    public static String m67376Tm(String str) {
        AppMethodBeat.m2504i(104961);
        C9058e bTQ = C39435k.bUf().oLX.bTQ();
        String str2;
        if (bTQ == null || !str.equalsIgnoreCase(bTQ.fJU)) {
            str2 = "0_" + C4995ag.m7428ck(str);
            AppMethodBeat.m2505o(104961);
            return str2;
        }
        str2 = C12673b.m20670K(bTQ);
        AppMethodBeat.m2505o(104961);
        return str2;
    }
}
