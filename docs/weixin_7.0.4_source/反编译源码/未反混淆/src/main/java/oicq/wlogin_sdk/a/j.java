package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public final class j extends a {
    int BVB;

    public j() {
        this.BVB = 0;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_MILKCOFFEE;
    }

    public final byte[] cH(byte[] bArr) {
        AppMethodBeat.i(96493);
        this.BVB = bArr.length;
        byte[] bArr2 = new byte[this.BVB];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.Vj(this.BUz);
        super.ac(bArr2, this.BVB);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.o(96493);
        return bArr2;
    }
}
