package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.r */
public final class C7430r extends C6106a {
    int BVD;
    int BVE;

    public C7430r() {
        this.BVD = 0;
        this.BVE = 0;
        this.BUz = C31128d.MIC_PTU_TRANS_XINGYE;
    }

    /* renamed from: iB */
    public final byte[] mo16230iB(int i, int i2) {
        AppMethodBeat.m2504i(96501);
        this.BVD = 10;
        byte[] bArr = new byte[this.BVD];
        C6120util.m9653M(bArr, 0, this.BVE);
        C6120util.m9655O(bArr, 1, i);
        C6120util.m9655O(bArr, 5, i2);
        C6120util.m9653M(bArr, 9, 0);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr, this.BVD);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.m2505o(96501);
        return bArr;
    }
}
