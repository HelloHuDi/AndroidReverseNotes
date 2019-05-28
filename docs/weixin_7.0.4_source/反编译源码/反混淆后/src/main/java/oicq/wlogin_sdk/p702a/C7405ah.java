package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: oicq.wlogin_sdk.a.ah */
public final class C7405ah extends C6106a {
    public int BVP;

    public C7405ah() {
        this.BVP = 0;
        this.BUz = ErrorCode.THROWABLE_INITX5CORE;
    }

    /* renamed from: cK */
    public final byte[] mo16219cK(byte[] bArr) {
        int length;
        AppMethodBeat.m2504i(96479);
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
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, bArr2.length);
        super.emG();
        byte[] emC = super.emC();
        AppMethodBeat.m2505o(96479);
        return emC;
    }
}
