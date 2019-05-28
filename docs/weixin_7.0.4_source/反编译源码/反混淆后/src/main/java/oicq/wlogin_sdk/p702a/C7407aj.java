package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.aj */
public final class C7407aj extends C6106a {
    public C7407aj() {
        this.BUz = ErrorCode.TEST_THROWABLE_ISNOT_NULL;
    }

    /* renamed from: cL */
    private static int m12669cL(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > 32) {
            return 32;
        }
        return bArr.length;
    }

    /* renamed from: p */
    public final byte[] mo16220p(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(96500);
        int cL = C7407aj.m12669cL(bArr);
        int cL2 = C7407aj.m12669cL(bArr2);
        byte[] bArr3 = new byte[(((cL + 6) + 2) + cL2)];
        C6120util.m9669d(bArr3, 0, 522017402);
        C6120util.m9654N(bArr3, 4, cL);
        System.arraycopy(bArr, 0, bArr3, 6, cL);
        cL += 6;
        C6120util.m9654N(bArr3, cL, cL2);
        System.arraycopy(bArr2, 0, bArr3, cL + 2, cL2);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr3, bArr3.length);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.m2505o(96500);
        return emC;
    }
}
