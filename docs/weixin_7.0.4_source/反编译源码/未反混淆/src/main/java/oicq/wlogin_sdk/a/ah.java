package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

public final class ah extends a {
    public int BVP;

    public ah() {
        this.BVP = 0;
        this.BUz = ErrorCode.THROWABLE_INITX5CORE;
    }

    public final byte[] cK(byte[] bArr) {
        int length;
        AppMethodBeat.i(96479);
        if (bArr != null) {
            length = bArr.length + 0;
        } else {
            length = 0;
        }
        byte[] bArr2 = new byte[length];
        if (bArr2.length > 0) {
            System.arraycopy(bArr, 0, bArr2, 0, length);
        }
        this.BVP = bArr2.length;
        super.Vj(this.BUz);
        super.ac(bArr2, bArr2.length);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.o(96479);
        return emC;
    }
}
