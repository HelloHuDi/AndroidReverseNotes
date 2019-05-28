package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class t extends a {
    public int BVF;

    public t() {
        this.BVF = 0;
        this.BUz = d.MIC_PTU_BAIXI;
    }

    public final Boolean emH() {
        AppMethodBeat.i(96503);
        Boolean bool;
        if (this.BVj < 5) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96503);
            return bool;
        }
        int ae = util.ae(this.BUt, ((this.BVi + 2) + 1) + 1);
        if (this.BVj < ae + 5) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96503);
            return bool;
        }
        this.BVF = ae;
        bool = Boolean.TRUE;
        AppMethodBeat.o(96503);
        return bool;
    }
}
