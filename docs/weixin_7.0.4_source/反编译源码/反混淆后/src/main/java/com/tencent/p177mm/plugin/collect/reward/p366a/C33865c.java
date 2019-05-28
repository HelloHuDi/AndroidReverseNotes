package com.tencent.p177mm.plugin.collect.reward.p366a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bud;
import com.tencent.p177mm.protocal.protobuf.bue;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.collect.reward.a.c */
public final class C33865c extends C44428p {
    public bue kDw;

    public C33865c(String str, int i) {
        AppMethodBeat.m2504i(41037);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bud();
        c1196a.fsK = new bue();
        c1196a.uri = "/cgi-bin/mmpay-bin/scanrewardmaterialcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bud bud = (bud) this.ehh.fsG.fsP;
        bud.wVT = str;
        bud.scene = i;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardMaterial", "req url: %s, %s", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(41037);
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(41038);
        this.kDw = (bue) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneQrRewardMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.kDw.kCl), this.kDw.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(41038);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bue bue = (bue) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bue.kCl;
        this.AfD = bue.kCm;
    }

    public final int getType() {
        return 2811;
    }

    public final boolean bgR() {
        return true;
    }
}
