package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ab extends a {
    public int BVK;

    public ab() {
        this.BVK = 0;
        this.BUz = 306;
    }

    public final Boolean emH() {
        AppMethodBeat.i(96471);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96471);
            return bool;
        }
        this.BVK = util.af(this.BUt, this.BVi);
        if (this.BVK + 2 > this.BVj) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96471);
            return bool;
        }
        bool = Boolean.TRUE;
        AppMethodBeat.o(96471);
        return bool;
    }
}
