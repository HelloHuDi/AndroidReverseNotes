package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.protocal.C15312m.C15313a;
import com.tencent.p177mm.protocal.C15312m.C15314b;
import com.tencent.p177mm.protocal.C4787a;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelsimple.c */
public final class C26467c extends C1207m implements C1918k {
    private C1202f ehi;
    private C1929q ftU = new C26468a();

    /* renamed from: com.tencent.mm.modelsimple.c$a */
    public static class C26468a extends C6297k {
        private final C15313a fOp = new C15313a();
        private final C15314b fOq = new C15314b();

        public C26468a() {
            AppMethodBeat.m2504i(16553);
            AppMethodBeat.m2505o(16553);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fOp;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fOq;
        }

        public final int getType() {
            return 0;
        }

        public final String getUri() {
            return null;
        }
    }

    /* renamed from: cQ */
    public static void m42174cQ(boolean z) {
        AppMethodBeat.m2504i(16554);
        C4990ab.m7417i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom isFg[%s], accHasReady[%s] stack[%s]", Boolean.valueOf(z), Boolean.valueOf(C9638aw.m17179RK()), C5046bo.dpG());
        if (!C9638aw.m17179RK()) {
            AppMethodBeat.m2505o(16554);
        } else if (C9638aw.m17182Rg() == null || C9638aw.m17182Rg().ftA == null || C9638aw.m17182Rg().ftA.adg() == null) {
            C4990ab.m7416i("MicroMsg.NetSceneBgFg", "summerbgfg setBgFgForMuteRoom push not rready");
            AppMethodBeat.m2505o(16554);
        } else {
            C9638aw.m17182Rg().ftA.adg().mo5488cE(z);
            if (z) {
                C9638aw.m17182Rg().mo14541a(new C26467c(true), 0);
                AppMethodBeat.m2505o(16554);
                return;
            }
            C9638aw.m17182Rg().mo14541a(new C26467c(C26467c.aiS()), 0);
            AppMethodBeat.m2505o(16554);
        }
    }

    private static boolean aiS() {
        int i;
        boolean z;
        AppMethodBeat.m2504i(16555);
        if (C1947ae.gjf != -1) {
            i = C1947ae.gjf;
        } else {
            try {
                i = C5046bo.getInt(C26373g.m41964Nu().getValue("MuteRoomDisable"), 0);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneBgFg", e, "", new Object[0]);
                i = 0;
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneBgFg", "somr DynamicConfig checkBit:%d TestMuteRoomEnable:%d muteRoomDisable:%d fg:%b", Integer.valueOf(1), Integer.valueOf(C1947ae.gjf), Integer.valueOf(i), Boolean.valueOf(C4872b.foreground));
        if ((i & 1) != 0) {
            z = true;
        } else {
            z = r3;
        }
        AppMethodBeat.m2505o(16555);
        return z;
    }

    private C26467c(boolean z) {
        int i;
        AppMethodBeat.m2504i(16556);
        C15313a c15313a = (C15313a) this.ftU.acF();
        c15313a.netType = C4787a.getNetType(C4996ah.getContext());
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        c15313a.vyo = i;
        AppMethodBeat.m2505o(16556);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16557);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ftU, this);
        AppMethodBeat.m2505o(16557);
        return a;
    }

    public final int getType() {
        return 0;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16558);
        C4990ab.m7411d("MicroMsg.NetSceneBgFg", " ret[%d]", Integer.valueOf(((C15314b) c1929q.mo5618ZS()).vyp.kCl));
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16558);
    }
}
