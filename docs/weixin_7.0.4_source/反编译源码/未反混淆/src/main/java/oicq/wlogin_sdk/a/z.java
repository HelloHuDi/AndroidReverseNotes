package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class z extends a {
    public int BVH;
    public int BVI;

    public z() {
        this.BVH = 0;
        this.BVI = 0;
        this.BUz = 293;
    }

    public final Boolean emH() {
        AppMethodBeat.i(96476);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96476);
            return bool;
        }
        this.BVH = util.af(this.BUt, this.BVi);
        if (this.BVj < (this.BVH + 2) + 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96476);
            return bool;
        }
        this.BVI = util.af(this.BUt, (this.BVi + 2) + this.BVH);
        bool = Boolean.TRUE;
        AppMethodBeat.o(96476);
        return bool;
    }
}
