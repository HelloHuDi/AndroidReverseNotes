package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.C31128d;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.aa */
public final class C7398aa extends C6106a {
    int BVJ;

    public C7398aa() {
        this.BVJ = 0;
        this.BUz = C31128d.MIC_PTU_YINGTAOBUDING;
    }

    /* renamed from: ad */
    private static int m12664ad(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }

    /* renamed from: a */
    public final byte[] mo16215a(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(96495);
        int ad = C7398aa.m12664ad(bArr, 32);
        int ad2 = C7398aa.m12664ad(bArr2, 16);
        this.BVJ = (((ad + 11) + 2) + ad2) + 2;
        byte[] bArr3 = new byte[this.BVJ];
        C6120util.m9654N(bArr3, 0, 0);
        C6120util.m9653M(bArr3, 2, i);
        C6120util.m9653M(bArr3, 3, i2);
        C6120util.m9653M(bArr3, 4, i3);
        C6120util.m9655O(bArr3, 5, 0);
        C6120util.m9654N(bArr3, 9, ad);
        System.arraycopy(bArr, 0, bArr3, 11, ad);
        ad += 11;
        C6120util.m9654N(bArr3, ad, ad2);
        ad += 2;
        System.arraycopy(bArr2, 0, bArr3, ad, ad2);
        C6120util.m9654N(bArr3, ad + ad2, 0);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr3, this.BVJ);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.m2505o(96495);
        return emC;
    }
}
