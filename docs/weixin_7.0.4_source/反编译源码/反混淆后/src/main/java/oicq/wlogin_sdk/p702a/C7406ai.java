package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ai */
public final class C7406ai extends C6106a {
    public int BVQ;
    public int BVR;
    public int BVS;

    public C7406ai() {
        this.BVQ = 0;
        this.BVR = 0;
        this.BVS = 0;
        this.BUz = ErrorCode.TEST_THROWABLE_IS_NULL;
    }

    public final Boolean emH() {
        AppMethodBeat.m2504i(96472);
        Boolean bool;
        if (this.BVj < 12) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96472);
            return bool;
        }
        int af = C6120util.m9659af(this.BUt, this.BVi + 4);
        if (this.BVj < af + 12) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96472);
            return bool;
        }
        this.BVQ = af;
        af = C6120util.m9659af(this.BUt, (this.BVi + 6) + this.BVQ);
        if (this.BVj < (this.BVQ + 12) + af) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96472);
            return bool;
        }
        this.BVR = af;
        af = C6120util.m9659af(this.BUt, ((this.BVi + 10) + this.BVQ) + this.BVR);
        if (this.BVj < ((this.BVQ + 12) + this.BVR) + af) {
            bool = Boolean.FALSE;
            AppMethodBeat.m2505o(96472);
            return bool;
        }
        this.BVS = af;
        bool = Boolean.TRUE;
        AppMethodBeat.m2505o(96472);
        return bool;
    }
}
