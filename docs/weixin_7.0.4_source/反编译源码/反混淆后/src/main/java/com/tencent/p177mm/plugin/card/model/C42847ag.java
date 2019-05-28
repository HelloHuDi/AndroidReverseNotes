package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bkx;
import com.tencent.p177mm.protocal.protobuf.bky;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.model.ag */
public final class C42847ag extends C1207m implements C1918k {
    public String cKE;
    public String content;
    private final C7472b ehh;
    private C1202f ehi;
    public String hfo;
    public String ken;
    public String keo;
    public boolean kep;
    public String keq;
    public String ker;
    public String kes;
    public String ket;
    public int status;

    public C42847ag(int i, String str, String str2) {
        AppMethodBeat.m2504i(87913);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bkx();
        c1196a.fsK = new bky();
        c1196a.uri = "/cgi-bin/micromsg-bin/preacceptgiftcard";
        this.ehh = c1196a.acD();
        bkx bkx = (bkx) this.ehh.fsG.fsP;
        bkx.vBA = i;
        bkx.vBB = str;
        bkx.vBC = str2;
        AppMethodBeat.m2505o(87913);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(87914);
        C4990ab.m7417i("MicroMsg.NetScenePreAcceptGiftCard", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            bky bky = (bky) this.ehh.fsH.fsP;
            this.cKE = bky.vBF;
            this.ken = bky.vBG;
            this.status = bky.status;
            this.content = bky.content;
            this.keo = bky.kdE;
            this.hfo = bky.wNR;
            this.kep = bky.kep;
            this.keq = bky.wNS;
            this.ker = bky.wNT;
            this.kes = bky.wNU;
            this.ket = bky.wNV;
            C4990ab.m7411d("MicroMsg.NetScenePreAcceptGiftCard", "fromUserName:%s, fromUserHeadImgUrl:%s, status:%d, content:%s,buttonWording:%s, backgroundColor:%s, ignore:%b", this.cKE, this.ken, Integer.valueOf(this.status), this.content, this.keo, this.hfo, Boolean.valueOf(this.kep));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(87914);
    }

    public final int getType() {
        return 1171;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(87915);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(87915);
        return a;
    }
}
