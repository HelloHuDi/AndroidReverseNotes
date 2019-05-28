package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bua;
import com.tencent.p177mm.protocal.protobuf.bub;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44428p;

/* renamed from: com.tencent.mm.plugin.collect.model.k */
public final class C2832k extends C44428p {
    public bub kCj;

    public C2832k(String str, int i) {
        AppMethodBeat.m2504i(40973);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bua();
        c1196a.fsK = new bub();
        c1196a.uri = "/cgi-bin/mmpay-bin/scanf2fmaterialcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bua bua = (bua) this.ehh.fsG.fsP;
        bua.wVT = str;
        bua.scene = i;
        C4990ab.m7417i("MicroMsg.NetSceneF2fMaterial", "req url: %s, %s", str, Integer.valueOf(i));
        AppMethodBeat.m2505o(40973);
    }

    /* renamed from: b */
    public final void mo6948b(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(40974);
        this.kCj = (bub) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneF2fMaterial", "retcode: %s, retmsg: %s", Integer.valueOf(this.kCj.kCl), this.kCj.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(40974);
    }

    /* renamed from: f */
    public final void mo6949f(C1929q c1929q) {
        bub bub = (bub) ((C7472b) c1929q).fsH.fsP;
        this.AfC = bub.kCl;
        this.AfD = bub.kCm;
    }

    public final int getType() {
        return 1800;
    }
}
