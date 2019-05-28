package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;

public final class k extends a {
    int BVC;

    public k() {
        this.BVC = 0;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_MILKBLUE;
    }

    public final byte[] cI(byte[] bArr) {
        AppMethodBeat.i(96502);
        this.BVC = bArr.length;
        byte[] bArr2 = new byte[this.BVC];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        super.Vj(this.BUz);
        super.ac(bArr2, this.BVC);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.o(96502);
        return bArr2;
    }
}
