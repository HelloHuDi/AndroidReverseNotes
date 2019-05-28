package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class ad extends a {
    public int BVL;

    public ad() {
        this.BVL = 0;
        this.BUz = 312;
    }

    public final Boolean emH() {
        AppMethodBeat.i(96477);
        Boolean bool;
        if (this.BVj < 4) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96477);
            return bool;
        }
        this.BVL = util.ag(this.BUt, this.BVi);
        if (this.BVj < (this.BVL * 10) + 4) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96477);
            return bool;
        }
        bool = Boolean.TRUE;
        AppMethodBeat.o(96477);
        return bool;
    }

    public final int emJ() {
        AppMethodBeat.i(96478);
        for (int i = 0; i < this.BVL; i++) {
            if (util.af(this.BUt, (this.BVi + 4) + (i * 10)) == d.MIC_PTU_ZIPAI_GRADIENT_LOLLY) {
                int ag = util.ag(this.BUt, ((i * 10) + (this.BVi + 4)) + 2);
                AppMethodBeat.o(96478);
                return ag;
            }
        }
        AppMethodBeat.o(96478);
        return 0;
    }
}
