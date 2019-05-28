package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.q;
import com.tencent.mm.modelsimple.q.a;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class e {
    public static a a(q qVar) {
        AppMethodBeat.i(79001);
        Bundle bundle = new Bundle();
        bundle.putInt("kscene_type", 73);
        a a = a(qVar, bundle);
        AppMethodBeat.o(79001);
        return a;
    }

    private static a a(q qVar, Bundle bundle) {
        AppMethodBeat.i(79002);
        if (qVar == null) {
            AppMethodBeat.o(79002);
            return null;
        } else if (((com.tencent.mm.protocal.j.e) qVar.ftU.ZS()).vxV.xid == null) {
            AppMethodBeat.o(79002);
            return null;
        } else {
            bzr bzr = ((com.tencent.mm.protocal.j.e) qVar.ftU.ZS()).vxV.xid.vHR;
            if (!(bzr == null || bzr.wYM == null || bzr.wYM.size() <= 0)) {
                a aVar = new a();
                Iterator it = bzr.wYM.iterator();
                while (it.hasNext()) {
                    cfi cfi = (cfi) it.next();
                    if (cfi.pXC == 19) {
                        aVar.cxb = cfi.xeN;
                    } else if (cfi.pXC == 20) {
                        aVar.fPp = cfi.xeN;
                    } else if (cfi.pXC == 21) {
                        aVar.cEh = cfi.xeN;
                    }
                }
                aVar.fPq = bundle;
                aVar.type = 0;
                if (!bo.isNullOrNil(aVar.cxb)) {
                    aVar.username = ((d) qVar.ftU.acF()).vxS.wEb.jBB;
                    AppMethodBeat.o(79002);
                    return aVar;
                }
            }
            AppMethodBeat.o(79002);
            return null;
        }
    }
}
