package oicq.wlogin_sdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import oicq.wlogin_sdk.tools.util;

public final class ae extends a {
    int BVM;
    int upS;

    public ae() {
        this.upS = 0;
        this.BVM = 0;
        this.BUz = ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02;
    }

    public final byte[] cJ(byte[] bArr) {
        AppMethodBeat.i(96494);
        this.BVM = bArr.length + 4;
        byte[] bArr2 = new byte[this.BVM];
        util.N(bArr2, 0, this.upS);
        util.N(bArr2, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        super.Vj(this.BUz);
        super.ac(bArr2, bArr2.length);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.o(96494);
        return bArr2;
    }
}
