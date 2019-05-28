package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class y extends a {
    int BVG;

    public y() {
        this.BVG = 0;
        this.BUz = 292;
    }

    private static int ad(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    public final byte[] a(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        AppMethodBeat.i(96473);
        int ad = ad(bArr, 16);
        int ad2 = ad(bArr2, 16);
        int ad3 = ad(bArr3, 16);
        int ad4 = ad(bArr4, 32);
        int ad5 = ad(bArr5, 16);
        this.BVG = (((((((((ad + 2) + 2) + ad2) + 2) + 2) + ad3) + 2) + ad4) + 2) + ad5;
        byte[] bArr6 = new byte[this.BVG];
        util.N(bArr6, 0, ad);
        System.arraycopy(bArr, 0, bArr6, 2, ad);
        ad += 2;
        util.N(bArr6, ad, ad2);
        ad += 2;
        System.arraycopy(bArr2, 0, bArr6, ad, ad2);
        ad += ad2;
        util.N(bArr6, ad, i);
        ad += 2;
        util.N(bArr6, ad, ad3);
        ad += 2;
        System.arraycopy(bArr3, 0, bArr6, ad, ad3);
        ad += ad3;
        util.N(bArr6, ad, ad4);
        ad += 2;
        System.arraycopy(bArr4, 0, bArr6, ad, ad4);
        ad += ad4;
        util.N(bArr6, ad, ad5);
        System.arraycopy(bArr5, 0, bArr6, ad + 2, ad5);
        super.Vj(this.BUz);
        super.ac(bArr6, this.BVG);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.o(96473);
        return emC;
    }
}
