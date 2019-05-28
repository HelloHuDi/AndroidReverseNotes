package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.t */
public final class C7432t extends C6106a {
    public int BVF;

    public C7432t() {
        this.BVF = 0;
        this.BUz = C31128d.MIC_PTU_BAIXI;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96503);
        Boolean bool;
        if (this.BVj < 5) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96503);
            return bool;
        }
        int ae = C6120util.m9658ae(this.BUt, ((this.BVi + 2) + 1) + 1);
        if (this.BVj < ae + 5) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96503);
            return bool;
        }
        this.BVF = ae;
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96503);
        return bool;
    }
}
