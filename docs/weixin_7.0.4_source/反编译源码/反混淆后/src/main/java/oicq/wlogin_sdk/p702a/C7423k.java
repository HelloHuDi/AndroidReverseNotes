package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;

/* renamed from: oicq.wlogin_sdk.a.k */
public final class C7423k extends C6106a {
    int BVC;

    public C7423k() {
        this.BVC = 0;
        this.BUz = C31128d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE;
    }

    /* renamed from: cI */
    public final byte[] mo16229cI(byte[] bArr) {
        AppMethodBeat.m2504i(96502);
        this.BVC = bArr.length;
        byte[] bArr2 = new byte[this.BVC];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, this.BVC);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96502);
        return bArr2;
    }
}
