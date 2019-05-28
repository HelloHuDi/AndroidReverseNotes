package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class i extends a {
    int BVA;

    public i() {
        this.BVA = 6;
        this.BUz = d.MIC_PTU_ZIPAI_GRADIENT_FASHION;
    }

    public final byte[] emI() {
        AppMethodBeat.i(96492);
        byte[] bArr = new byte[this.BVA];
        util.N(bArr, 0, 0);
        util.M(bArr, 2, 1);
        util.N(bArr, 3, 102400);
        util.M(bArr, 5, 1);
        super.Vj(this.BUz);
        super.ac(bArr, this.BVA);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.o(96492);
        return bArr;
    }
}
