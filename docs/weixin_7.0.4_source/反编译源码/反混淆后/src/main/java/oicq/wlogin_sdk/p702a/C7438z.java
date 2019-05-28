package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.z */
public final class C7438z extends C6106a {
    public int BVH;
    public int BVI;

    public C7438z() {
        this.BVH = 0;
        this.BVI = 0;
        this.BUz = 293;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96476);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96476);
            return bool;
        }
        this.BVH = C6120util.m9659af(this.BUt, this.BVi);
        if (this.BVj < (this.BVH + 2) + 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96476);
            return bool;
        }
        this.BVI = C6120util.m9659af(this.BUt, (this.BVi + 2) + this.BVH);
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96476);
        return bool;
    }
}
