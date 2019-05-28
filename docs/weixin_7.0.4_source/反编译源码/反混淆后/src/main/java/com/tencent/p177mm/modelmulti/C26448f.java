package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.protocal.C23474u.C23475b;
import com.tencent.p177mm.protocal.C23474u.C23476a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelmulti.f */
public final class C26448f extends C1207m implements C1918k {
    private C1202f ehi;
    public long fHM = -1;
    private byte[] fIi;
    private C1929q ftU;
    private int uin = 0;

    /* renamed from: com.tencent.mm.modelmulti.f$b */
    public static class C26449b implements C1929q {
        private final C23476a fIj = new C23476a();
        private final C23475b fIk = new C23475b();
        int uin;

        public C26449b() {
            AppMethodBeat.m2504i(58371);
            AppMethodBeat.m2505o(58371);
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final C4834d acF() {
            AppMethodBeat.m2504i(58372);
            this.fIj.vye = C1427q.m3028LM();
            this.fIj.vyd = C7243d.eSg;
            this.fIj.vyc = C7243d.vxo;
            this.fIj.mo10000hB(this.uin);
            C23476a c23476a = this.fIj;
            AppMethodBeat.m2505o(58372);
            return c23476a;
        }

        public final boolean acG() {
            return false;
        }

        public final int acC() {
            return 0;
        }

        public final int acB() {
            return 0;
        }

        public final boolean acH() {
            return true;
        }

        /* renamed from: ZS */
        public final /* bridge */ /* synthetic */ C4835e mo5618ZS() {
            return this.fIk;
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.f$a */
    public static class C26450a extends C6297k {
        private final C23476a fIj = new C23476a();
        private final C23475b fIk = new C23475b();

        public C26450a() {
            AppMethodBeat.m2504i(58370);
            AppMethodBeat.m2505o(58370);
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final int acB() {
            return 0;
        }

        /* renamed from: ZR */
        public final /* bridge */ /* synthetic */ C4834d mo14537ZR() {
            return this.fIj;
        }

        /* renamed from: ZS */
        public final /* bridge */ /* synthetic */ C4835e mo5618ZS() {
            return this.fIk;
        }
    }

    public C26448f(long j, byte[] bArr) {
        this.fHM = j;
        this.fIi = bArr;
    }

    public C26448f(long j, byte[] bArr, int i) {
        this.fHM = j;
        this.fIi = bArr;
        this.uin = i;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(58373);
        if (C5046bo.m7540cb(this.fIi)) {
            C4990ab.m7413e("MicroMsg.NetSceneNotifyData", "dkpush %s", "get keyBuf failed");
            AppMethodBeat.m2505o(58373);
            return -1;
        }
        if (this.uin == 0) {
            this.ftU = new C26450a();
        } else {
            this.ftU = new C26449b();
            ((C26449b) this.ftU).uin = this.uin;
        }
        C4990ab.m7417i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", Long.valueOf(this.fHM), C5046bo.m7531bZ(this.fIi));
        ((C23476a) this.ftU.acF()).fJB = this.fHM;
        ((C23476a) this.ftU.acF()).cAG = this.fIi;
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(58373);
        return a;
    }

    public final int getType() {
        return 268369922;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58374);
        C4990ab.m7417i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(58374);
    }
}
