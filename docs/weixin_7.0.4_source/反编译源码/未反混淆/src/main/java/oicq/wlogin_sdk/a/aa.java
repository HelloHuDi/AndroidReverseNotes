package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class aa extends a {
    int BVJ;

    public aa() {
        this.BVJ = 0;
        this.BUz = d.MIC_PTU_YINGTAOBUDING;
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

    public final byte[] a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(96495);
        int ad = ad(bArr, 32);
        int ad2 = ad(bArr2, 16);
        this.BVJ = (((ad + 11) + 2) + ad2) + 2;
        byte[] bArr3 = new byte[this.BVJ];
        util.N(bArr3, 0, 0);
        util.M(bArr3, 2, i);
        util.M(bArr3, 3, i2);
        util.M(bArr3, 4, i3);
        util.O(bArr3, 5, 0);
        util.N(bArr3, 9, ad);
        System.arraycopy(bArr, 0, bArr3, 11, ad);
        ad += 11;
        util.N(bArr3, ad, ad2);
        ad += 2;
        System.arraycopy(bArr2, 0, bArr3, ad, ad2);
        util.N(bArr3, ad + ad2, 0);
        super.Vj(this.BUz);
        super.ac(bArr3, this.BVJ);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.o(96495);
        return emC;
    }
}
