package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class c extends a {
    int BVp;
    int BVq;
    int BVr;

    public c() {
        this.BVp = 1;
        this.BVq = util.BWu;
        this.BVr = 22;
        this.BUz = 256;
    }

    public final byte[] Vk(int i) {
        AppMethodBeat.i(96475);
        byte[] bArr = new byte[this.BVr];
        util.N(bArr, 0, this.BVp);
        util.O(bArr, 2, this.BVq);
        util.O(bArr, 6, 522017402);
        util.O(bArr, 10, 1);
        util.O(bArr, 14, i);
        util.O(bArr, 18, 8256);
        super.Vj(this.BUz);
        super.ac(bArr, this.BVr);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.o(96475);
        return bArr;
    }
}
