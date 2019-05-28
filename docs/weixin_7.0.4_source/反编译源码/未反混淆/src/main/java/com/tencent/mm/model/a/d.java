package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.e.a;
import com.tencent.mm.ai.e.b;
import com.tencent.mm.ai.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.cm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d implements e {
    public final b b(a aVar) {
        AppMethodBeat.i(118144);
        cm cmVar = aVar.eAB;
        if (cmVar == null || cmVar.vED == null) {
            ab.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
            AppMethodBeat.o(118144);
        } else {
            Object a = aa.a(cmVar.vED);
            g.RP().Ry().set(328193, a);
            c aaK = g.aaK();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                aaK.oQ(a);
                String str = (String) g.RP().Ry().get(328197, null);
                if (bo.isNullOrNil(str) || !(aaK.fnW == null || str.equals(aaK.fnW.fnS))) {
                    g.RP().Ry().set(328197, aaK.fnW.fnS);
                    g.RP().Ry().set(328195, Boolean.FALSE);
                    g.RP().Ry().set(328194, Boolean.FALSE);
                    g.RP().Ry().set(328196, Boolean.FALSE);
                    ab.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e) {
                ab.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e.toString());
            }
            ab.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (g.aaK().aaI()) {
                f.oS(g.aaK().fnW.fnS);
            }
            AppMethodBeat.o(118144);
        }
        return null;
    }

    public final void a(c cVar) {
    }
}
