package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.ae */
public final class C7402ae extends C6106a {
    int BVM;
    int upS;

    public C7402ae() {
        this.upS = 0;
        this.BVM = 0;
        this.BUz = ErrorCode.ERROR_TBSINSTALLER_ISTBSCORELEGAL_02;
    }

    /* renamed from: cJ */
    public final byte[] mo16217cJ(byte[] bArr) {
        AppMethodBeat.m2504i(96494);
        this.BVM = bArr.length + 4;
        byte[] bArr2 = new byte[this.BVM];
        C6120util.m9654N(bArr2, 0, this.upS);
        C6120util.m9654N(bArr2, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, bArr2.length);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96494);
        return bArr2;
    }
}
