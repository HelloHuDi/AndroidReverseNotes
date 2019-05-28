package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15364n;
import com.tencent.p177mm.protocal.protobuf.C15369o;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C44426i;

/* renamed from: com.tencent.mm.plugin.aa.a.a.i */
public final class C37992i extends C1207m implements C1918k, C44426i {
    private C1202f ehi;
    private C7472b gme;
    private C15364n gmn;
    public C15369o gmo;

    public C37992i(String str, long j, int i, String str2) {
        AppMethodBeat.m2504i(40657);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15364n();
        c1196a.fsK = new C15369o();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaapay";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gmn = (C15364n) this.gme.fsG.fsP;
        this.gmn.vzL = str;
        this.gmn.vAe = j;
        this.gmn.scene = i;
        this.gmn.vzM = str2;
        C4990ab.m7417i("MicroMsg.NetSceneAAPay", "NetSceneAAPay, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s", this.gmn.vzL, Long.valueOf(this.gmn.vAe), Integer.valueOf(this.gmn.scene), this.gmn.vzM);
        AppMethodBeat.m2505o(40657);
    }

    public final int getType() {
        return 1629;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40658);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40658);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40659);
        C4990ab.m7417i("MicroMsg.NetSceneAAPay", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmo = (C15369o) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneAAPay", "retcode: %s, retmsg: %s, paymsgid:%s", Integer.valueOf(this.gmo.kCl), this.gmo.kCm, this.gmo.cJF);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40659);
    }
}
