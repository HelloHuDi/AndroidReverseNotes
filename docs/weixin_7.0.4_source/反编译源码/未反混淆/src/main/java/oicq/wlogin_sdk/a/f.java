package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public final class f extends a {
    int BVs;

    public f() {
        this.BVs = 0;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW;
    }

    public final byte[] cG(byte[] bArr) {
        AppMethodBeat.i(96480);
        this.BVs = bArr.length;
        byte[] bArr2 = new byte[this.BVs];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.Vj(this.BUz);
        super.ac(bArr2, this.BVs);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.o(96480);
        return bArr2;
    }
}
