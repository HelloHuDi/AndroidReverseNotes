package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.g.b.a.p;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

public final class d {
    private static d qSX = null;
    private c<rq> ecA;
    public HashMap<Integer, String> qSY;

    private d() {
        AppMethodBeat.i(36876);
        this.qSY = null;
        this.ecA = new c<rq>() {
            {
                AppMethodBeat.i(36874);
                this.xxI = rq.class.getName().hashCode();
                AppMethodBeat.o(36874);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(36875);
                final rq rqVar = (rq) bVar;
                com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(36873);
                        d.a(d.this, rqVar.cNC.cND, rqVar.cNC.cNF);
                        AppMethodBeat.o(36873);
                    }
                });
                AppMethodBeat.o(36875);
                return false;
            }
        };
        this.qSY = new HashMap();
        a.xxA.b(this.ecA);
        AppMethodBeat.o(36876);
    }

    public static d coE() {
        AppMethodBeat.i(36877);
        if (qSX == null) {
            qSX = new d();
        }
        d dVar = qSX;
        AppMethodBeat.o(36877);
        return dVar;
    }

    static /* synthetic */ void a(d dVar, long j, HashMap hashMap) {
        AppMethodBeat.i(36878);
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Integer intValue : hashMap.keySet()) {
                int intValue2 = intValue.intValue();
                String str = (String) dVar.qSY.remove(Integer.valueOf(intValue2));
                if (!bo.isNullOrNil(str)) {
                    try {
                        intValue2 = ((Integer) hashMap.get(Integer.valueOf(intValue2))).intValue() == 1 ? 1 : 2;
                    } catch (Exception e) {
                        intValue2 = 0;
                    }
                    p pVar = new p(str);
                    pVar.eM(i.jV(j));
                    pVar.cWH = (long) intValue2;
                    pVar.ajK();
                    ab.i("MicroMsg.SnsPostReportLogic", "report sns image exif [%s]", pVar.Fk());
                }
            }
        }
        AppMethodBeat.o(36878);
    }
}
