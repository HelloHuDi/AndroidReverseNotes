package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: oicq.wlogin_sdk.a.f */
public final class C7418f extends C6106a {
    int BVs;

    public C7418f() {
        this.BVs = 0;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;
    }

    /* renamed from: cG */
    public final byte[] mo16225cG(byte[] bArr) {
        AppMethodBeat.m2504i(96480);
        this.BVs = bArr.length;
        byte[] bArr2 = new byte[this.BVs];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, this.BVs);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96480);
        return bArr2;
    }
}
