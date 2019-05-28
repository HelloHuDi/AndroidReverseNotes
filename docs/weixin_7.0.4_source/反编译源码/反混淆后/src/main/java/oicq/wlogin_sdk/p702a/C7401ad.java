package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ad */
public final class C7401ad extends C6106a {
    public int BVL;

    public C7401ad() {
        this.BVL = 0;
        this.BUz = 312;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96477);
        Boolean bool;
        if (this.BVj < 4) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96477);
            return bool;
        }
        this.BVL = C6120util.m9660ag(this.BUt, this.BVi);
        if (this.BVj < (this.BVL * 10) + 4) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96477);
            return bool;
        }
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96477);
        return bool;
    }

    public final int emJ() {
        AppMethodBeat.m2504i(96478);
        for (int i = 0; i < this.BVL; i++) {
            if (C6120util.m9659af(this.BUt, (this.BVi + 4) + (i * 10)) == C31128d.MIC_PTU_ZIPAI_GRADIENT_LOLLY) {
                int ag = C6120util.m9660ag(this.BUt, ((i * 10) + (this.BVi + 4)) + 2);
                AppMethodBeat.m2505o(96478);
                return ag;
            }
        }
        AppMethodBeat.m2505o(96478);
        return 0;
    }
}
