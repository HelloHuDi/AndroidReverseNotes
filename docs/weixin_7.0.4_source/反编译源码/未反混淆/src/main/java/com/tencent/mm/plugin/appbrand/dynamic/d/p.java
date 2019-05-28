package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.z.c.d;

public class p {
    private static volatile d hnj;
    private static volatile d hnk;

    public static d nM(int i) {
        AppMethodBeat.i(10865);
        d azS;
        if (i == 1) {
            azS = azS();
            AppMethodBeat.o(10865);
            return azS;
        }
        azS = azR();
        AppMethodBeat.o(10865);
        return azS;
    }

    private static d azR() {
        d dVar;
        AppMethodBeat.i(10866);
        if (hnj == null) {
            synchronized (p.class) {
                try {
                    if (hnj == null) {
                        dVar = new d();
                        dVar.a(new l(312));
                        dVar.a(new d(306));
                        dVar.a(new e(306));
                        dVar.a(new b(com.tencent.view.d.MIC_PTU_QINGCHENG));
                        dVar.a(new c(307));
                        dVar.a(new k(com.tencent.view.d.MIC_PTU_MUSE));
                        dVar.a(new j(com.tencent.view.d.MIC_PTU_DANNAI));
                        dVar.a(new f(com.tencent.view.d.MIC_PTU_HONGKONG));
                        dVar.a(new o());
                        hnj = dVar;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10866);
                    }
                }
            }
        }
        dVar = hnj;
        AppMethodBeat.o(10866);
        return dVar;
    }

    private static d azS() {
        d dVar;
        AppMethodBeat.i(10867);
        if (hnk == null) {
            synchronized (p.class) {
                try {
                    if (hnk == null) {
                        dVar = new d();
                        dVar.a(new l(com.tencent.view.d.MIC_PTU_ZIRAN));
                        dVar.a(new d(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_LOLLY));
                        dVar.a(new e(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_LOLLY));
                        dVar.a(new b(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE));
                        dVar.a(new c(com.tencent.view.d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW));
                        dVar.a(new k(com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG));
                        dVar.a(new j(com.tencent.view.d.MIC_PTU_BAIXI));
                        dVar.a(new f(com.tencent.view.d.MIC_PTU_SHUILIAN));
                        dVar.a(new h());
                        dVar.a(new i());
                        dVar.a(new n());
                        dVar.a(new m());
                        dVar.a(new o());
                        dVar.a(new h());
                        dVar.a(new g());
                        dVar.a(new a());
                        hnk = dVar;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10867);
                    }
                }
            }
        }
        dVar = hnk;
        AppMethodBeat.o(10867);
        return dVar;
    }
}
