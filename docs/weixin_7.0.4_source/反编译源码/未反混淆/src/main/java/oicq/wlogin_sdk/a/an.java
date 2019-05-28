package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class an extends a {
    int BVU;
    int BVV;
    int BVW;

    public an() {
        this.BVU = 22;
        this.BVV = 1;
        this.BVW = 1536;
        this.BUz = 24;
    }

    public final byte[] aj(int i, long j) {
        AppMethodBeat.i(96504);
        byte[] bArr = new byte[this.BVU];
        util.N(bArr, 0, this.BVV);
        util.O(bArr, 2, this.BVW);
        util.O(bArr, 6, 522017402);
        util.O(bArr, 10, i);
        util.O(bArr, 14, (int) j);
        util.N(bArr, 18, 0);
        util.N(bArr, 20, 0);
        super.Vj(this.BUz);
        super.ac(bArr, this.BVU);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.o(96504);
        return bArr;
    }
}
