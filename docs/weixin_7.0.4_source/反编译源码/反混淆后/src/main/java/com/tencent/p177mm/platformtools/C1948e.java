package com.tencent.p177mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.modelsimple.C6686q.C6688a;
import com.tencent.p177mm.protocal.C4824j.C4829d;
import com.tencent.p177mm.protocal.C4824j.C4830e;
import com.tencent.p177mm.protocal.protobuf.bzr;
import com.tencent.p177mm.protocal.protobuf.cfi;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.platformtools.e */
public final class C1948e {
    /* renamed from: a */
    public static C6688a m4157a(C6686q c6686q) {
        AppMethodBeat.m2504i(79001);
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        C6688a a = C1948e.m4158a(c6686q, bundle);
        AppMethodBeat.m2505o(79001);
        return a;
    }

    /* renamed from: a */
    private static C6688a m4158a(C6686q c6686q, Bundle bundle) {
        AppMethodBeat.m2504i(79002);
        if (c6686q == null) {
            AppMethodBeat.m2505o(79002);
            return null;
        } else if (((C4830e) c6686q.ftU.mo5618ZS()).vxV.xid == null) {
            AppMethodBeat.m2505o(79002);
            return null;
        } else {
            bzr bzr = ((C4830e) c6686q.ftU.mo5618ZS()).vxV.xid.vHR;
            if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
                C6688a c6688a = new C6688a();
                Iterator it = bzr.wYM.iterator();
                while (it.hasNext()) {
                    cfi cfi = (cfi) it.next();
                    if (cfi.pXC == 19) {
                        c6688a.cxb = cfi.xeN;
                    } else if (cfi.pXC == 20) {
                        c6688a.fPp = cfi.xeN;
                    } else if (cfi.pXC == 21) {
                        c6688a.cEh = cfi.xeN;
                    }
                }
                c6688a.fPq = bundle;
                c6688a.type = 0;
                if (!C5046bo.isNullOrNil(c6688a.cxb)) {
                    c6688a.username = ((C4829d) c6686q.ftU.acF()).vxS.wEb.jBB;
                    AppMethodBeat.m2505o(79002);
                    return c6688a;
                }
            }
            AppMethodBeat.m2505o(79002);
            return null;
        }
    }
}
