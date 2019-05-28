package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.util;

public final class ao extends a {
    int BVX;
    int BVY;

    public ao() {
        this.BVX = 0;
        this.BVY = 0;
        this.BUz = 2;
    }

    public final byte[] q(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(96470);
        this.BVX = (bArr.length + 6) + bArr2.length;
        byte[] bArr3 = new byte[this.BVX];
        util.N(bArr3, 0, this.BVY);
        util.N(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length = bArr.length + 4;
        util.N(bArr3, length, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length + 2, bArr2.length);
        super.Vj(this.BUz);
        super.ac(bArr3, this.BVX);
        super.emG();
        bArr3 = super.emC();
        AppMethodBeat.o(96470);
        return bArr3;
    }
}
