package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bhc;
import com.tencent.p177mm.protocal.protobuf.bhd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.ad */
public final class C14105ad extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private bhc tgv;
    public bhd tgw;

    public C14105ad(String str, String str2) {
        AppMethodBeat.m2504i(45332);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bhc();
        c1196a.fsK = new bhd();
        c1196a.uri = "/cgi-bin/mmpay-bin/openlqbaccount";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.tgv = (bhc) this.gme.fsG.fsP;
        this.tgv.vKZ = str;
        this.tgv.wKu = str2;
        this.tgv.tgu = C14103ab.cMM();
        C4990ab.m7417i("MicroMsg.NetSceneOpenLqbAccount", "NetSceneOpenLqbAccount, eCardType: %s, extraData: %s", str, str2);
        AppMethodBeat.m2505o(45332);
    }

    public final int getType() {
        return 2996;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(45333);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(45333);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(45334);
        C4990ab.m7417i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.tgw = (bhd) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneOpenLqbAccount", "onGYNetEnd, retcode: %s, retmsg: %s", Integer.valueOf(this.tgw.kdT), this.tgw.kdU);
        if (this.tgw.kdT == 0) {
            C14103ab.ach(this.tgw.tgu);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(45334);
    }
}
