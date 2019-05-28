package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class b extends a {
    int BVk;
    int BVl;
    int BVm;
    int BVn;
    byte[] BVo;

    public b() {
        AppMethodBeat.i(96498);
        this.BVk = 4;
        this.BVl = 14;
        this.BVm = 1;
        this.BVn = 20;
        this.BVo = new byte[2];
        this.BUz = 1;
        AppMethodBeat.o(96498);
    }

    public final Boolean emH() {
        if (this.BVj < 20) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public final byte[] g(long j, byte[] bArr) {
        AppMethodBeat.i(96499);
        byte[] bArr2 = new byte[this.BVn];
        util.N(bArr2, 0, this.BVm);
        util.O(bArr2, 2, util.emN());
        util.O(bArr2, 6, (int) j);
        util.d(bArr2, 10, util.emP());
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        util.N(bArr2, bArr.length + 14, 0);
        super.Vj(this.BUz);
        super.ac(bArr2, this.BVn);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.o(96499);
        return bArr2;
    }
}
