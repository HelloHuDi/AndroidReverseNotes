package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import oicq.wlogin_sdk.tools.util;

public final class aj extends a {
    public aj() {
        this.BUz = ErrorCode.TEST_THROWABLE_ISNOT_NULL;
    }

    private static int cL(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    public final byte[] p(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(96500);
        int cL = cL(bArr);
        int cL2 = cL(bArr2);
        byte[] bArr3 = new byte[(((cL + 6) + 2) + cL2)];
        util.d(bArr3, 0, 522017402);
        util.N(bArr3, 4, cL);
        System.arraycopy(bArr, 0, bArr3, 6, cL);
        cL += 6;
        util.N(bArr3, cL, cL2);
        System.arraycopy(bArr2, 0, bArr3, cL + 2, cL2);
        super.Vj(this.BUz);
        super.ac(bArr3, bArr3.length);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.o(96500);
        return emC;
    }
}
