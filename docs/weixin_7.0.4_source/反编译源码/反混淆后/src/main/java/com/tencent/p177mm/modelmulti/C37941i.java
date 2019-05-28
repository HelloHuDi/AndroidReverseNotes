package com.tencent.p177mm.modelmulti;

import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.protocal.C4787a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C4845x.C4846a;
import com.tencent.p177mm.protocal.C4845x.C4847b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelmulti.i */
public final class C37941i extends C1207m implements C1918k {
    private WakerLock ebJ = new WakerLock(C4996ah.getContext(), "MicroMsg.NetSceneSynCheck");
    private C1202f ehi;
    private final C1929q ftU;

    /* renamed from: com.tencent.mm.modelmulti.i$a */
    public static class C32818a extends C6297k {
        private final C4846a fIv = new C4846a();
        private final C4847b fIw = new C4847b();

        public C32818a() {
            AppMethodBeat.m2504i(58375);
            AppMethodBeat.m2505o(58375);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fIv;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fIw;
        }

        public final int getType() {
            return 39;
        }

        public final String getUri() {
            return null;
        }

        public final int acC() {
            return 1;
        }
    }

    public C37941i() {
        AppMethodBeat.m2504i(58376);
        this.ebJ.lock(3000, "NetSceneSynCheck");
        this.ftU = new C32818a();
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                C1720g.m3537RQ();
                C4846a c4846a = (C4846a) this.ftU.acF();
                c4846a.fIi = C5046bo.anf((String) C1720g.m3536RP().mo5239Ry().get(8195, null));
                C4846a c4846a2 = (C4846a) this.ftU.acF();
                C1720g.m3537RQ();
                C1720g.m3534RN();
                c4846a2.uin = C1668a.m3383QF();
                ((C4846a) this.ftU.acF()).netType = C4787a.getNetType(C4996ah.getContext());
                ((C4846a) this.ftU.acF()).vyo = C4787a.dlZ();
                C4990ab.m7410d("MicroMsg.MMSyncCheck", "NetSceneSynCheck");
                AppMethodBeat.m2505o(58376);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.NetSceneSynCheck", "[arthurdan.NetSceneSynCheckCrash] Notice!!! MMCore.getAccStg() is null");
        AppMethodBeat.m2505o(58376);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(58377);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        if (a == -1 && this.ebJ.isLocking()) {
            this.ebJ.unLock();
        }
        AppMethodBeat.m2505o(58377);
        return a;
    }

    public final boolean acI() {
        return true;
    }

    public final int getType() {
        return 39;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58378);
        C4847b c4847b = (C4847b) c1929q.mo5618ZS();
        C4990ab.m7416i("MicroMsg.NetSceneSynCheck", "new syncCheck complete, selector=" + c4847b.vyM);
        if (C1720g.m3531RK() && !C1668a.m3393QT()) {
            byte[] bArr2 = ((C4846a) c1929q.acF()).eJt;
            if (C5046bo.m7540cb(bArr2)) {
                C4990ab.m7412e("MicroMsg.NetSceneSynCheck", "onGYNetEnd md5 is null");
            }
            c4847b.eJt = bArr2;
            ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a(c4847b.vyM, 2, c4847b.dmu());
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        this.ebJ.unLock();
        AppMethodBeat.m2505o(58378);
    }
}
