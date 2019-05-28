package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ao */
public final class C7412ao extends C6106a {
    int BVX;
    int BVY;

    public C7412ao() {
        this.BVX = 0;
        this.BVY = 0;
        this.BUz = 2;
    }

    /* renamed from: q */
    public final byte[] mo16222q(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(96470);
        this.BVX = (bArr.length + 6) + bArr2.length;
        byte[] bArr3 = new byte[this.BVX];
        C6120util.m9654N(bArr3, 0, this.BVY);
        C6120util.m9654N(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length = bArr.length + 4;
        C6120util.m9654N(bArr3, length, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length + 2, bArr2.length);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr3, this.BVX);
        super.emG();
        bArr3 = super.emC();
        AppMethodBeat.m2505o(96470);
        return bArr3;
    }
}
