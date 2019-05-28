package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.model.bk */
public final class C6668bk extends C1207m implements C1918k {
    private C1202f ehi;
    private final C1835a fmT;
    private final String fmU;
    private long fmV;

    /* renamed from: com.tencent.mm.model.bk$1 */
    class C18341 implements Runnable {
        C18341() {
        }

        public final void run() {
            AppMethodBeat.m2504i(58109);
            C6668bk.this.mo4498a(0, 0, 0, null, null, null);
            AppMethodBeat.m2505o(58109);
        }

        public final String toString() {
            AppMethodBeat.m2504i(58110);
            String str = super.toString() + "|doScene";
            AppMethodBeat.m2505o(58110);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.model.bk$a */
    public interface C1835a {
        /* renamed from: a */
        void mo4918a(C1902e c1902e);
    }

    public C6668bk(C1835a c1835a) {
        this(c1835a, null);
    }

    public C6668bk(C1835a c1835a, String str) {
        AppMethodBeat.m2504i(58111);
        C4990ab.m7417i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, C5046bo.dpG());
        this.fmT = c1835a;
        this.fmU = str;
        AppMethodBeat.m2505o(58111);
    }

    public final int getType() {
        return 0;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(58112);
        mo4470c(c1902e);
        this.ehi = c1202f;
        this.fmV = C5046bo.m7588yz();
        C1720g.m3539RS().mo10302aa(new C18341());
        AppMethodBeat.m2505o(58112);
        return 0;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58113);
        if (this.fmT != null) {
            C4990ab.m7411d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.fmU, Long.valueOf(C5046bo.m7525az(this.fmV)));
            this.fmT.mo4918a(this.ftf);
        }
        this.ehi.onSceneEnd(0, 0, null, this);
        AppMethodBeat.m2505o(58113);
    }
}
