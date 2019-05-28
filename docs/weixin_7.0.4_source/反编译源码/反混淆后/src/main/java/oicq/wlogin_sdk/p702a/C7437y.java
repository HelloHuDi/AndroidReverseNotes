package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.y */
public final class C7437y extends C6106a {
    int BVG;

    public C7437y() {
        this.BVG = 0;
        this.BUz = 292;
    }

    /* renamed from: ad */
    private static int m12680ad(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    /* renamed from: a */
    public final byte[] mo16231a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AppMethodBeat.m2504i(96473);
        int ad = C7437y.m12680ad(bArr, 16);
        int ad2 = C7437y.m12680ad(bArr2, 16);
        int ad3 = C7437y.m12680ad(bArr3, 16);
        int ad4 = C7437y.m12680ad(bArr4, 32);
        int ad5 = C7437y.m12680ad(bArr5, 16);
        this.BVG = (((((((((ad + 2) + 2) + ad2) + 2) + 2) + ad3) + 2) + ad4) + 2) + ad5;
        byte[] bArr6 = new byte[this.BVG];
        C6120util.m9654N(bArr6, 0, ad);
        System.arraycopy(bArr, 0, bArr6, 2, ad);
        ad += 2;
        C6120util.m9654N(bArr6, ad, ad2);
        ad += 2;
        System.arraycopy(bArr2, 0, bArr6, ad, ad2);
        ad += ad2;
        C6120util.m9654N(bArr6, ad, i);
        ad += 2;
        C6120util.m9654N(bArr6, ad, ad3);
        ad += 2;
        System.arraycopy(bArr3, 0, bArr6, ad, ad3);
        ad += ad3;
        C6120util.m9654N(bArr6, ad, ad4);
        ad += 2;
        System.arraycopy(bArr4, 0, bArr6, ad, ad4);
        ad += ad4;
        C6120util.m9654N(bArr6, ad, ad5);
        System.arraycopy(bArr5, 0, bArr6, ad + 2, ad5);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr6, this.BVG);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.m2505o(96473);
        return emC;
    }
}
