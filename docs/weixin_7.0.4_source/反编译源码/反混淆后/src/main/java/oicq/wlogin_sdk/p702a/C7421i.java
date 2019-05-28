package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.i */
public final class C7421i extends C6106a {
    int BVA;

    public C7421i() {
        this.BVA = 6;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_FASHION;
    }

    public final byte[] emI() {
        AppMethodBeat.m2504i(96492);
        byte[] bArr = new byte[this.BVA];
        C6120util.m9654N(bArr, 0, 0);
        C6120util.m9653M(bArr, 2, 1);
        C6120util.m9654N(bArr, 3, 102400);
        C6120util.m9653M(bArr, 5, 1);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr, this.BVA);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.m2505o(96492);
        return bArr;
    }
}
