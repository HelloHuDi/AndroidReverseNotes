package com.tencent.p177mm.plugin.readerapp.p1015c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C32780bm;
import com.tencent.p177mm.p230g.p231a.C42035pg;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.readerapp.c.f */
final class C46156f extends C4884c<C42035pg> {
    C46156f() {
        AppMethodBeat.m2504i(76762);
        this.xxI = C42035pg.class.getName().hashCode();
        AppMethodBeat.m2505o(76762);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(76763);
        C42035pg c42035pg = (C42035pg) c4883b;
        if (c42035pg instanceof C42035pg) {
            long j = c42035pg.cLy.cvx;
            C39565g.m67627jA(j);
            C32780bm cdZ = C39565g.cdZ();
            C4990ab.m7411d("MicroMsg.ReaderAppInfoStorage", "deleteGroupByMsgSvrID:%s", "delete from " + C32780bm.m53549kH(20) + " where reserved2 = " + j);
            if (cdZ.fni.mo10108hY(C32780bm.m53549kH(20), "delete from " + C32780bm.m53549kH(20) + " where reserved2 = " + j)) {
                cdZ.mo53340kK(20);
                cdZ.doNotify();
            }
            AppMethodBeat.m2505o(76763);
            return true;
        }
        AppMethodBeat.m2505o(76763);
        return false;
    }
}
