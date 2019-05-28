package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.g */
public final class C7419g extends C6106a {
    public int BVt;
    public int BVu;
    public int BVv;
    public int BVw;

    public C7419g() {
        this.BVt = 0;
        this.BVu = 0;
        this.BVv = 0;
        this.BVw = 0;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_ANDYWARHOLCOW;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96469);
        Boolean bool;
        if (this.BVj < 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96469);
            return bool;
        }
        this.BVu = C6120util.m9659af(this.BUt, this.BVi);
        if (this.BVj < (this.BVu + 2) + 2) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96469);
            return bool;
        }
        this.BVt = C6120util.m9659af(this.BUt, (this.BVi + 2) + this.BVu);
        if (this.BVj < ((this.BVu + 2) + 2) + this.BVt) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96469);
            return bool;
        }
        this.BVw = this.BVi + 2;
        this.BVv = ((this.BVu + 2) + 2) + this.BVi;
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96469);
        return bool;
    }
}
