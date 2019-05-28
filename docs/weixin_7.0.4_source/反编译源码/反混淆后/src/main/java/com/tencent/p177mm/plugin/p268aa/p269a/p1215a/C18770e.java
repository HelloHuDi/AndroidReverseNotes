package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23380d;
import com.tencent.p177mm.protocal.protobuf.C23385e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.aa.a.a.e */
public final class C18770e extends C1207m implements C1918k {
    private C1202f ehi;
    private C7472b gme;
    private C23380d gmf;
    public C23385e gmg;
    public int scene;

    public C18770e(String str, int i, String str2) {
        AppMethodBeat.m2504i(40644);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C23380d();
        c1196a.fsK = new C23385e();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaaclose";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gmf = (C23380d) this.gme.fsG.fsP;
        this.gmf.vzM = str2;
        this.gmf.vzL = str;
        this.gmf.scene = i;
        this.scene = i;
        C4990ab.m7411d("MicroMsg.NetSceneAAClose", "NetSceneAAClose, billNo: %s, scene: %s", this.gmf.vzL, Integer.valueOf(i));
        AppMethodBeat.m2505o(40644);
    }

    public final int getType() {
        return 1530;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40645);
        C4990ab.m7416i("MicroMsg.NetSceneAAClose", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40645);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40646);
        C4990ab.m7417i("MicroMsg.NetSceneAAClose", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmg = (C23385e) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneAAClose", "retcode: %s, retmsg: %s", Integer.valueOf(this.gmg.kCl), this.gmg.kCm);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40646);
    }
}
