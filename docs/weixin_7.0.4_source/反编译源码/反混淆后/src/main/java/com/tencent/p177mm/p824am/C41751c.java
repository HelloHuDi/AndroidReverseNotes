package com.tencent.p177mm.p824am;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.am.c */
public final class C41751c extends C1812ai {
    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        return i != 0 && i < 637929471;
    }

    public final String getTag() {
        return "MicroMsg.BizTimeLineDataTransfer";
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(16431);
        C4990ab.m7411d("MicroMsg.BizTimeLineDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 637929471) {
            boolean z;
            if ((((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(0))).intValue() & 2) > 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C30309s.m48275pp(true);
            }
            C4990ab.m7417i("MicroMsg.BizTimeLineDataTransfer", "transfer end %b", Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(16431);
    }
}
