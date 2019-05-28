package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.view.d;
import oicq.wlogin_sdk.tools.util;

public final class r extends a {
    int BVD;
    int BVE;

    public r() {
        this.BVD = 0;
        this.BVE = 0;
        this.BUz = d.MIC_PTU_TRANS_XINGYE;
    }

    public final byte[] iB(int i, int i2) {
        AppMethodBeat.i(96501);
        this.BVD = 10;
        byte[] bArr = new byte[this.BVD];
        util.M(bArr, 0, this.BVE);
        util.O(bArr, 1, i);
        util.O(bArr, 5, i2);
        util.M(bArr, 9, 0);
        super.Vj(this.BUz);
        super.ac(bArr, this.BVD);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.o(96501);
        return bArr;
    }
}
