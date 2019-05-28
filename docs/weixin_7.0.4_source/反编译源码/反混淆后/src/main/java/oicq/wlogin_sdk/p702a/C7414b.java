package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.b */
public final class C7414b extends C6106a {
    int BVk;
    int BVl;
    int BVm;
    int BVn;
    byte[] BVo;

    public C7414b() {
        AppMethodBeat.m2504i(96498);
        this.BVk = 4;
        this.BVl = 14;
        this.BVm = 1;
        this.BVn = 20;
        this.BVo = new byte[2];
        this.BUz = 1;
        AppMethodBeat.m2505o(96498);
    }

    public final Boolean emH() {
        if (this.BVj < 20) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    /* renamed from: g */
    public final byte[] mo16223g(long j, byte[] bArr) {
        AppMethodBeat.m2504i(96499);
        byte[] bArr2 = new byte[this.BVn];
        C6120util.m9654N(bArr2, 0, this.BVm);
        C6120util.m9655O(bArr2, 2, C6120util.emN());
        C6120util.m9655O(bArr2, 6, (int) j);
        C6120util.m9669d(bArr2, 10, C6120util.emP());
        System.arraycopy(bArr, 0, bArr2, 14, bArr.length);
        C6120util.m9654N(bArr2, bArr.length + 14, 0);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr2, this.BVn);
        super.emG();
        bArr2 = super.emC();
        AppMethodBeat.m2505o(96499);
        return bArr2;
    }
}
