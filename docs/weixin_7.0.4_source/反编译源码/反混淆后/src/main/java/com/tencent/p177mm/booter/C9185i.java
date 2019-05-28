package com.tencent.p177mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.booter.i */
public final class C9185i {
    /* renamed from: Iv */
    public static boolean m16686Iv() {
        AppMethodBeat.m2504i(15852);
        try {
            C9638aw.m17190ZK();
            C42252ah.m74617d((Long) C18628c.m29072Ry().get(66817, null));
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.PostTaskMediaNoteStat", e, "", new Object[0]);
        }
        if (C42252ah.m74621fp(0) * 1000 > 1800000) {
            AppMethodBeat.m2505o(15852);
            return true;
        }
        AppMethodBeat.m2505o(15852);
        return false;
    }
}
