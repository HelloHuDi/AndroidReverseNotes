package com.tencent.p177mm.plugin.appbrand.dynamic.p286d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p652z.p653c.C16116d;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.d.p */
public class C45546p {
    private static volatile C16116d hnj;
    private static volatile C16116d hnk;

    /* renamed from: nM */
    public static C16116d m83997nM(int i) {
        AppMethodBeat.m2504i(10865);
        C16116d azS;
        if (i == 1) {
            azS = C45546p.azS();
            AppMethodBeat.m2505o(10865);
            return azS;
        }
        azS = C45546p.azR();
        AppMethodBeat.m2505o(10865);
        return azS;
    }

    private static C16116d azR() {
        C16116d c16116d;
        AppMethodBeat.m2504i(10866);
        if (hnj == null) {
            synchronized (C45546p.class) {
                try {
                    if (hnj == null) {
                        c16116d = new C16116d();
                        c16116d.mo28560a(new C2140l(312));
                        c16116d.mo28560a(new C16601d(306));
                        c16116d.mo28560a(new C2134e(306));
                        c16116d.mo28560a(new C45543b(C31128d.MIC_PTU_QINGCHENG));
                        c16116d.mo28560a(new C16600c(307));
                        c16116d.mo28560a(new C33158k(C31128d.MIC_PTU_MUSE));
                        c16116d.mo28560a(new C33157j(C31128d.MIC_PTU_DANNAI));
                        c16116d.mo28560a(new C2135f(C31128d.MIC_PTU_HONGKONG));
                        c16116d.mo28560a(new C16609o());
                        hnj = c16116d;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10866);
                    }
                }
            }
        }
        c16116d = hnj;
        AppMethodBeat.m2505o(10866);
        return c16116d;
    }

    private static C16116d azS() {
        C16116d c16116d;
        AppMethodBeat.m2504i(10867);
        if (hnk == null) {
            synchronized (C45546p.class) {
                try {
                    if (hnk == null) {
                        c16116d = new C16116d();
                        c16116d.mo28560a(new C2140l(C31128d.MIC_PTU_ZIRAN));
                        c16116d.mo28560a(new C16601d(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY));
                        c16116d.mo28560a(new C2134e(C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY));
                        c16116d.mo28560a(new C45543b(C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE));
                        c16116d.mo28560a(new C16600c(C31128d.MIC_PTU_ZIPAI_GRADIENT_LIPNEW));
                        c16116d.mo28560a(new C33158k(C31128d.MIC_PTU_TRANS_KONGCHENG));
                        c16116d.mo28560a(new C33157j(C31128d.MIC_PTU_BAIXI));
                        c16116d.mo28560a(new C2135f(C31128d.MIC_PTU_SHUILIAN));
                        c16116d.mo28560a(new C38199h());
                        c16116d.mo28560a(new C45545i());
                        c16116d.mo28560a(new C16606n());
                        c16116d.mo28560a(new C16602m());
                        c16116d.mo28560a(new C16609o());
                        c16116d.mo28560a(new C38199h());
                        c16116d.mo28560a(new C33154g());
                        c16116d.mo28560a(new C38198a());
                        hnk = c16116d;
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10867);
                    }
                }
            }
        }
        c16116d = hnk;
        AppMethodBeat.m2505o(10867);
        return c16116d;
    }
}
