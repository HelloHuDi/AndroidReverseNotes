package com.tencent.p177mm.p1374bi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7569ax;

/* renamed from: com.tencent.mm.bi.c */
public final class C37512c {
    /* renamed from: q */
    public static long m63303q(String str, long j) {
        AppMethodBeat.m2504i(16618);
        long j2 = 0;
        if (str != null) {
            C7569ax apw = C41789d.akO().apw(str);
            if (apw != null) {
                j2 = apw.field_createTime + 1;
            }
        }
        if (j2 > j * 1000) {
            AppMethodBeat.m2505o(16618);
            return j2;
        }
        j2 = j * 1000;
        AppMethodBeat.m2505o(16618);
        return j2;
    }

    /* renamed from: e */
    public static void m63302e(long j, String str) {
        AppMethodBeat.m2504i(16619);
        C4990ab.m7417i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", Long.valueOf(j), str);
        C4990ab.m7416i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = ".concat(String.valueOf(C41789d.akP().mo7911p(j, str))));
        C4990ab.m7416i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = ".concat(String.valueOf(C41789d.akO().mo15227QS(str))));
        AppMethodBeat.m2505o(16619);
    }
}
