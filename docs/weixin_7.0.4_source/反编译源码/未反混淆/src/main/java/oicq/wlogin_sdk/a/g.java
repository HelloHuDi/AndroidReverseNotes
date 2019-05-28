package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class g extends a {
    public int BVt;
    public int BVu;
    public int BVv;
    public int BVw;

    public g() {
        this.BVt = 0;
        this.BVu = 0;
        this.BVv = 0;
        this.BVw = 0;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW;
    }

    public final Boolean emH() {
        AppMethodBeat.i(96469);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96469);
            return bool;
        }
        this.BVu = util.af(this.BUt, this.BVi);
        if (this.BVj < (this.BVu + 2) + 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96469);
            return bool;
        }
        this.BVt = util.af(this.BUt, (this.BVi + 2) + this.BVu);
        if (this.BVj < ((this.BVu + 2) + 2) + this.BVt) {
            bool = Boolean.FALSE;
            AppMethodBeat.o(96469);
            return bool;
        }
        this.BVw = this.BVi + 2;
        this.BVv = ((this.BVu + 2) + 2) + this.BVi;
        bool = Boolean.TRUE;
        AppMethodBeat.o(96469);
        return bool;
    }
}
