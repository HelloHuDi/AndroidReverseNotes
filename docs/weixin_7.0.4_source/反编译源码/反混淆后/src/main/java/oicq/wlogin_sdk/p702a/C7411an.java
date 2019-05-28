package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.an */
public final class C7411an extends C6106a {
    int BVU;
    int BVV;
    int BVW;

    public C7411an() {
        this.BVU = 22;
        this.BVV = 1;
        this.BVW = 1536;
        this.BUz = 24;
    }

    /* renamed from: aj */
    public final byte[] mo16221aj(int i, long j) {
        AppMethodBeat.m2504i(96504);
        byte[] bArr = new byte[this.BVU];
        C6120util.m9654N(bArr, 0, this.BVV);
        C6120util.m9655O(bArr, 2, this.BVW);
        C6120util.m9655O(bArr, 6, 522017402);
        C6120util.m9655O(bArr, 10, i);
        C6120util.m9655O(bArr, 14, (int) j);
        C6120util.m9654N(bArr, 18, 0);
        C6120util.m9654N(bArr, 20, 0);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr, this.BVU);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.m2505o(96504);
        return bArr;
    }
}
