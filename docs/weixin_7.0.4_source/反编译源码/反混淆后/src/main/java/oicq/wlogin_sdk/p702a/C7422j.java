package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: oicq.wlogin_sdk.a.j */
public final class C7422j extends C6106a {
    int BVB;

    public C7422j() {
        this.BVB = 0;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
    }

    /* renamed from: cH */
    public final byte[] mo16228cH(byte[] bArr) {
        AppMethodBeat.m2504i(96493);
        this.BVB = bArr.length;
        byte[] bArr2 = new byte[this.BVB];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, this.BVB);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96493);
        return bArr2;
    }
}
