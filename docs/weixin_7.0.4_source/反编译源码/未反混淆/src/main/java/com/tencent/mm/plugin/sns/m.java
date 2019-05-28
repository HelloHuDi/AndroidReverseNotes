package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends c<rv> {
    public m() {
        AppMethodBeat.i(35633);
        this.xxI = rv.class.getName().hashCode();
        AppMethodBeat.o(35633);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(35634);
        rv rvVar = (rv) bVar;
        if (rvVar instanceof rv) {
            if (rvVar.cNO.cvp == 2) {
                boolean z = bo.isNullOrNil((String) g.RP().Ry().get(68377, null)) && n.qFz.baS() == 0;
                ab.i("MicroMsg.SnsSyncListener", "Strategy 3 isNotExistSnsNew %b", Boolean.valueOf(z));
                if (z) {
                    g.RQ();
                    g.RO().eJo.a(new u(), 0);
                }
            } else {
                g.RQ();
                g.RO().eJo.a(new u(), 0);
            }
            AppMethodBeat.o(35634);
            return true;
        }
        ab.f("MicroMsg.SnsSyncListener", "mismatched event");
        AppMethodBeat.o(35634);
        return false;
    }
}
