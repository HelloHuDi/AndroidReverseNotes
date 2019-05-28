package oicq.wlogin_sdk.p702a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.tools.C6120util;

/* renamed from: oicq.wlogin_sdk.a.c */
public final class C7415c extends C6106a {
    int BVp;
    int BVq;
    int BVr;

    public C7415c() {
        this.BVp = 1;
        this.BVq = C6120util.BWu;
        this.BVr = 22;
        this.BUz = 256;
    }

    /* renamed from: Vk */
    public final byte[] mo16224Vk(int i) {
        AppMethodBeat.m2504i(96475);
        byte[] bArr = new byte[this.BVr];
        C6120util.m9654N(bArr, 0, this.BVp);
        C6120util.m9655O(bArr, 2, this.BVq);
        C6120util.m9655O(bArr, 6, 522017402);
        C6120util.m9655O(bArr, 10, 1);
        C6120util.m9655O(bArr, 14, i);
        C6120util.m9655O(bArr, 18, 8256);
        super.mo13502Vj(this.BUz);
        super.mo13503ac(bArr, this.BVr);
        super.emG();
        bArr = super.emC();
        AppMethodBeat.m2505o(96475);
        return bArr;
    }
}
