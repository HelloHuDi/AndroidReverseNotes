package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15357l;
import com.tencent.p177mm.protocal.protobuf.C30203m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.h */
public final class C42260h extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C15357l gml;
    public C30203m gmm;

    public C42260h() {
        AppMethodBeat.m2504i(40654);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15357l();
        c1196a.fsK = new C30203m();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaoperation";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gml = (C15357l) this.gme.fsG.fsP;
        AppMethodBeat.m2505o(40654);
    }

    public final int getType() {
        return 1698;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40655);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40655);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40656);
        C4990ab.m7417i("MicroMsg.NetSceneAAOperation", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmm = (C30203m) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            C4990ab.m7417i("MicroMsg.NetSceneAAOperation", "retCode: %s, retMsg: %s, max_payer_num: %s, max_receiver_num: %s, max_total_num: %s, max_total_amount: %s, max_per_amount: %s, notice: %s, notice_url: %s", Integer.valueOf(this.gmm.kCl), this.gmm.kCm, Integer.valueOf(this.gmm.vzZ), Integer.valueOf(this.gmm.vAa), Integer.valueOf(this.gmm.vAb), Long.valueOf(this.gmm.vAc), Long.valueOf(this.gmm.vAd), this.gmm.kCx, this.gmm.kCy);
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40656);
    }
}
