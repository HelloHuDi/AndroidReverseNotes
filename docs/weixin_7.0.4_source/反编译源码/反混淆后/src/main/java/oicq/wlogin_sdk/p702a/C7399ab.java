package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ab */
public final class C7399ab extends C6106a {
    public int BVK;

    public C7399ab() {
        this.BVK = 0;
        this.BUz = 306;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96471);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96471);
            return bool;
        }
        this.BVK = C6120util.m9659af(this.BUt, this.BVi);
        if (this.BVK + 2 > this.BVj) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96471);
            return bool;
        }
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96471);
        return bool;
    }
}
