package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15389v;
import com.tencent.p177mm.protocal.protobuf.C7553u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.j */
public final class C45482j extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C7553u gmp;
    public C15389v gmq;

    public C45482j(String str, int i, String str2, String str3, int i2) {
        AppMethodBeat.m2504i(40660);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C7553u();
        c1196a.fsK = new C15389v();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaquerydetail";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gmp = (C7553u) this.gme.fsG.fsP;
        this.gmp.vzL = str;
        this.gmp.scene = i;
        this.gmp.vzM = str2;
        if (i == 5) {
            C4990ab.m7416i("MicroMsg.NetSceneAAQueryDetail", "set sign and ver");
            this.gmp.sign = str3;
            this.gmp.ver = i2;
        }
        C4990ab.m7417i("MicroMsg.NetSceneAAQueryDetail", "NetSceneAAQueryDetail, billNo: %s, scene: %s, groupId: %s", str, Integer.valueOf(i), str2);
        AppMethodBeat.m2505o(40660);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40661);
        C4990ab.m7417i("MicroMsg.NetSceneAAQueryDetail", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmq = (C15389v) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneAAQueryDetail", "retcode: %s, retmsg: %s", Integer.valueOf(this.gmq.kCl), this.gmq.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40661);
    }

    public final int getType() {
        return 1695;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40662);
        C4990ab.m7416i("MicroMsg.NetSceneAAQueryDetail", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40662);
        return a;
    }
}
